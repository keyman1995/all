package com.micro.chen.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class HttpUtils {


    public static String getHtmlString(String targetUrl) {
        String content = null;

        HttpURLConnection connection = null;
        try {
            URL url = new URL(targetUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.13 Safari/537.36 Aoyou/NUN4dmkjdnFpJi55XmxoCr6y5iqj6r_zeabz_swf6oLgYhgA-VwhXZbh");
            connection.setRequestProperty("Accept", "image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash, application/vnd.ms-powerpoint, application/vnd.ms-excel, application/msword, */*");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("UA-CPU", "x86");
            //为什么没有deflate呢
            connection.setRequestProperty("Accept-Encoding", "gzip");
            connection.setRequestProperty("Content-type", "text/html");
            //keep-Alive，有什么用呢，你不是在访问网站，你是在采集。嘿嘿。减轻别人的压力，也是减轻自己。
            connection.setRequestProperty("Connection", "close");
            //不要用cache，用了也没有什么用，因为我们不会经常对一个链接频繁访问。（针对程序）
            connection.setUseCaches(false);
            connection.setConnectTimeout(60 * 1000);
            connection.setReadTimeout(60 * 1000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Charset", "utf-8");

            connection.connect();

            if (200 == connection.getResponseCode()) {
                InputStream inputStream = null;
                if (connection.getContentEncoding() != null && !connection.getContentEncoding().equals("")) {
                    String encode = connection.getContentEncoding().toLowerCase();
                    if (encode != null && !encode.equals("") && encode.indexOf("gzip") >= 0) {
                        inputStream = new GZIPInputStream(connection.getInputStream());
                    }
                }

                if (null == inputStream) {
                    inputStream = connection.getInputStream();
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append("\n");
                }
                content = builder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return content;
    }

}
