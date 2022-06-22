package com.example.uuz.controller;

import com.example.uuz.bean.Users1BeanVO;
import com.example.uuz.responseResult.ResponseResult;
import com.example.uuz.service.ReviseService;
import com.example.uuz.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = {"修改密码"})
@RestController
@RequestMapping("/revise")
public class Revise {

    @Autowired
    private ReviseService reviseService;

    @ApiOperation("获取账号信息")
    @PostMapping("/update")
    public ResponseResult<String> update(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        String ID = JwtUtil.parseJWT(token).getSubject();
        System.out.println("ID是： "+ ID);
        String userName = reviseService.selectUserName(ID);
        return ResponseResult.okResult(userName);
    }


    @ApiOperation("验证账号密码")
    @PostMapping("/verify")
    public ResponseResult<String> verify(@RequestBody Users1BeanVO users1BeanVO) {
        Users1BeanVO verify = reviseService.verify(users1BeanVO.getUserName(), users1BeanVO.getPassWord());
        System.out.println(verify.getUserName() + " <><><><><>" + verify.getPassWord());
        return ResponseResult.okResult("验证成功");
    }

    @ApiOperation("修改密码")
    @PostMapping("/sureUpdate")
    public ResponseResult<String> sureUpdate(@RequestBody Users1BeanVO users1BeanVO) {
        reviseService.sureUpdate(users1BeanVO.getUserName(), users1BeanVO.getPassWord());
        return ResponseResult.okResult("修改成功");
    }

}
