package com.javachain.demo.utils;

import com.alibaba.fastjson.JSON;
import com.shenyubao.javachain.connection.loader.BaseLoader;
import com.shenyubao.javachain.connection.retriever.Document;
import com.shenyubao.javachain.utils.PythonUtils;

import java.util.List;


/**
 * 临时工具类，二方包内Python文件暂时没有加载到
 */
public class LocalPdfLoader extends BaseLoader {
    private String filePath;

    @Override
    public List<Document> load(String dataSetId) {
        String result = PythonUtils.invokeMethodAsResource(getClass(), "pdfLoader.py", filePath);
        List<Document> documentList = JSON.parseArray(result, Document.class);

        for (Document document: documentList){
            document.setDatasetID(dataSetId);
        }
        documentList = onTransformer(documentList);
        return documentList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
