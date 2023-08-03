import com.javachain.demo.utils.LocalPdfLoader;
import com.shenyubao.javachain.connection.retriever.Document;
import com.shenyubao.javachain.connection.transformer.RecursiveCharacterTextSplitter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

/**
 * @author shenyubao
 * @date 2023/6/27 23:39
 */
public class PdfLoaderTest {


    @Test
    public void loadPdf(){
        String path = Objects.requireNonNull(getClass().getClassLoader().getResource("demo.pdf")).getPath();
        LocalPdfLoader loader = new LocalPdfLoader();
        loader.setFilePath(path);
        loader.registerTransformer(new RecursiveCharacterTextSplitter());
        List<Document> documents = loader.load("10001");
        Assertions.assertTrue(documents.size()>0);
    }

}
