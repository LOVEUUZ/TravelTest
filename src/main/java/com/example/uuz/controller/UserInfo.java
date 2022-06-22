package com.example.uuz.controller;

import com.example.uuz.responseResult.ResponseResult;
import com.example.uuz.service.UserInfoService;
import com.example.uuz.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags={"用户信息"})
@RestController
public class UserInfo {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("用户详细信息")
    @PostMapping("/user/info")
    public ResponseResult<com.example.uuz.bean.UserInfo> userInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println("这个是token >>> " + token);
        String ID = JwtUtil.parseJWT(token).getSubject();
        return userInfoService.selectUserAll(ID);
    }


}
