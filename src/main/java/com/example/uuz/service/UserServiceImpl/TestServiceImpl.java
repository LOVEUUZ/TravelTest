package com.example.uuz.service.UserServiceImpl;

import com.example.uuz.responseResult.ResponseResult;
import com.example.uuz.service.TestService;
import com.example.uuz.utils.HttpReq;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


@Service
public class TestServiceImpl<T> implements TestService {

    HashMap<Object, Object> hashMap = new HashMap<>();

    String prefix = "https://cn.bing.com/";
    String url = "https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-CN";

        TestServiceImpl() {
        try {
            InputStream inputStream = new HttpReq().HttpRequest(url, "GET");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder buffer = new StringBuilder();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();

            //裁剪buffer
            String substring = buffer.toString().substring(buffer.indexOf("\"", 2));
            String substring1 = substring.substring(4, substring.length() - 2);

            //string转map
            String[] strarr = substring1.replace("\"", "").split(",");
            for (String s : strarr) {
                String[] split = s.trim().split(":", 2);
                hashMap.put(split[0], split[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用fastjson2解析
     */
//    TestServiceImpl() throws MalformedURLException {
//        JSONObject j = JSON.parseObject(new URL(url));
//        String url1 = j.getString("images");
//        String url2 = url1.substring(1,url1.length()-1);
//        Map map = JSON.parseObject(url2);
//        System.out.println(map.get("copyrightlink"));
//    }

//    public static void main(String[] args) throws MalformedURLException {
//        new TestServiceImpl<>();
//    }

    @Override
    public ResponseResult<T> getBackground(HttpServletResponse response) throws IOException {

        //开始获取bing中的图片
        InputStream bingPig = new HttpReq().HttpRequest(prefix + hashMap.get("url"), "GET");
        ServletOutputStream out = response.getOutputStream();
        int len;
        byte[] byt = new byte[1024];
        while ((len = bingPig.read(byt)) != -1) {
            out.write(byt, 0, len);
        }
        //清空缓存区
        out.flush();
        out.close();
        bingPig.close();

        return null;
    }

    @Override
    public ResponseResult<HashMap<Object, Object>> getBackgroundMsg() {
        return ResponseResult.okResult(hashMap);
    }
}

