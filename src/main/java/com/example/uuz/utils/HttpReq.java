package com.example.uuz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpReq {

    public InputStream HttpRequest(String url,String reqMethod) throws IOException {
        URL bingUrl = new URL(url);
        HttpURLConnection httpUrlConn = (HttpURLConnection) bingUrl.openConnection();
        httpUrlConn.setRequestMethod(reqMethod);
        httpUrlConn.setConnectTimeout(5 * 1000);
        return httpUrlConn.getInputStream();
    }
}
