package com.learn.lesson_04_URL;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDownload {
    public static void main(String[] args) throws Exception {
        // 1.下载地址
        // URL url = new URL("http://localhost:8080/testPage/testPage.txt");
        URL url = new URL("https://m701.music.126.net/20211013154944/b640eb4566ffade622ff3bbbf9674860/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/11139333748/83cb/f421/3c64/0b063ef761dff05a4f47b746aea720f1.m4a");


        // 2.连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        // FileOutputStream fos = new FileOutputStream("testPageDown.txt");
        FileOutputStream fos = new FileOutputStream("music.m4a");

        byte[] buffer = new byte[1024];
        int len;
        // 还是，从is中读取数据放到buffer中
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer, 0, len); // 写出数据
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();

    }
}
