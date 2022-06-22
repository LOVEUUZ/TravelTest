package com.example.uuz.controller;

import com.example.uuz.bean.Users1Bean;
import com.example.uuz.responseResult.ResponseEnum;
import com.example.uuz.responseResult.ResponseResult;
import com.example.uuz.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"注册"})
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;


    @ApiOperation("注册新用户")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseResult<String> registerUser(@RequestBody Users1Bean user) {
        List<Users1Bean> registerUser = registerService.repeatUserName(user.getUserName());
        if (!registerUser.isEmpty()) {
            System.out.println("注册失败：查询到有相同username:" + registerUser);
            return new ResponseResult<>(ResponseEnum.ACCOUNT_REPEAT);
        }
        System.out.println("UserName：" + " " + user.getUserName());
        System.out.println("PassWord：" + " " + user.getPassWord());
        registerService.registerUser(user.getUserName(), user.getPassWord());
        return ResponseResult.okResult("注册成功");
    }

}
