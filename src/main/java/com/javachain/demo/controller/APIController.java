package com.javachain.demo.controller;


import com.javachain.demo.common.AjaxResult;
import com.javachain.demo.utils.DownloadUtils;
import com.shenyubao.javachain.chain.extend.LLMChain;
import com.shenyubao.javachain.chain.extend.RetrievalChain;
import com.shenyubao.javachain.chain.extend.StuffDocumentChain;
import com.shenyubao.javachain.chain.router.SequentialChain;
import com.shenyubao.javachain.connection.embeddings.OpenAIEmbeddings;
import com.shenyubao.javachain.connection.loader.PdfLoader;
import com.shenyubao.javachain.connection.retriever.Document;
import com.shenyubao.javachain.connection.transformer.RecursiveCharacterTextSplitter;
import com.shenyubao.javachain.connection.vectorstore.MilvusStore;
import com.shenyubao.javachain.llms.OpenAI;
import com.shenyubao.javachain.prompt.PromptConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class APIController {
    @Value("${openai.endpoint}")
    private String endpoint;

    @Value("${openai.key}")
    private String apikey;

    @Value("${milvus.endpoint}")
    private String milvus_endpoint;

    @Value("${milvus.key}")
    private String milvus_apiKey;

    @GetMapping("/chat")
    public AjaxResult chat(@RequestParam("question") String question) {
        OpenAI openAI = new OpenAI(endpoint, apikey);
        String result = openAI.predict(question).outputString();
        return AjaxResult.success(result);
    }

    @GetMapping("/chat/doc")
    public AjaxResult chatDoc(@RequestParam("datasetId") String datasetId,@RequestParam("question") String question) {
        //  构建向量数据库
        MilvusStore milvusStore = new MilvusStore(milvus_endpoint,milvus_apiKey);
        milvusStore.setEmbedding(new OpenAIEmbeddings(endpoint, apikey)); //openai提供的embeddings
        milvusStore.init();

        // 构建检索Chain
        RetrievalChain retrievalChain = new RetrievalChain();
        retrievalChain.setRetriever(milvusStore.asRetriever());
        retrievalChain.setRecommendDocumentCount(2);
        retrievalChain.setDatasetId(datasetId);

        // 构建文档合并Chain
        StuffDocumentChain stuffDocumentChain = new StuffDocumentChain();

        // 构建LLM对接Chain
        OpenAI openAI = new OpenAI(endpoint,apikey);

        LLMChain llmChain = new LLMChain();
        llmChain.setPrompt(PromptConstants.QA_CONVERSATION_CH);
        llmChain.setLlm(openAI);
        llmChain.setVerbose(true);
        llmChain.setIsSteam(false);

        // 构建顺序连接器，将以上Chain链接起来
        SequentialChain sequentialChain = new SequentialChain();
        sequentialChain.setChains(Arrays.asList(retrievalChain, stuffDocumentChain, llmChain));
        String response = sequentialChain.call(question);
        return AjaxResult.success(response);
    }

    @GetMapping("/train")
    public AjaxResult train(@RequestParam("datasetId") String datasetId,
                            @RequestParam("remotePath") String remotePath
    ) throws IOException {
        // 数据库知识库向量持久化
        MilvusStore milvusStore = new MilvusStore(milvus_endpoint, milvus_apiKey);
        milvusStore.setEmbedding(new OpenAIEmbeddings(endpoint, apikey)); //openai提供的embeddings
        milvusStore.init();

        String localPath = DownloadUtils.downloadPDF(remotePath);

        // 获取PDF内容
        PdfLoader loader = new PdfLoader();
        loader.setFilePath(localPath);
        loader.registerTransformer(new RecursiveCharacterTextSplitter());
        List<Document> documents = loader.load(datasetId);

        List<String> documentIds = milvusStore.addDocuments(documents);

        return AjaxResult.success(documentIds);
    }
}
