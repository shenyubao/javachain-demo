package com.javachain.demo.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadUtils {
    public static String downloadPDF(String remoteUrl) throws IOException {
        // 从远程 URL 下载 PDF 文件
        URL pdfUrl = new URL(remoteUrl);
        URLConnection connection = pdfUrl.openConnection();
        InputStream input = connection.getInputStream();

        // 将 PDF 写入本地临时文件
        Path tempFilePath = Files.createTempFile("temp", ".pdf");
        File tempFile = tempFilePath.toFile();
        FileOutputStream output = new FileOutputStream(tempFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }

        // 关闭输入输出流
        input.close();
        output.close();

        // 返回临时文件的绝对路径
        return tempFile.getAbsolutePath();
    }
}
