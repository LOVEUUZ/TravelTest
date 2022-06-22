package com.example.uuz.service;

import com.example.uuz.responseResult.ResponseResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface TestService {

    ResponseResult getBackground(HttpServletResponse response) throws IOException;

    ResponseResult getBackgroundMsg() throws InterruptedException;
}
