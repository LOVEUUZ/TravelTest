package com.example.uuz.controller;

import com.example.uuz.bean.Users1Bean;
import com.example.uuz.responseResult.ResponseEnum;
import com.example.uuz.responseResult.ResponseResult;
import com.example.uuz.service.LoginService;
import com.example.uuz.utils.JwtUtil;
import com.ramostear.captcha.HappyCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(tags = {"登录"})
@Slf4j
@RestController
public class UserLoginAndCancellation {
    //    static Logger log = LoggerFactory.getLogger(UserLoginAndCancellation.class);
    @Autowired
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseResult<Map<String, Object>> userLogin(@RequestBody Users1Bean user, HttpServletRequest request) {
        log.info("账号名：" + user.getUserName());
        log.info("密码：" + user.getPassWord());
        log.info("验证码：" + user.getCaptcha());
        if (verify(String.valueOf(user.getCaptcha()), request)) {
            Users1Bean users1Bean = loginService.userLogin(user.getUserName(), user.getPassWord());
            if (users1Bean != null) {
                Map<String, Object> map = new HashMap<>();
                String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(users1Bean.getID()), null);
                map.put("token", token);
                return ResponseResult.okResult(map);
            } else return new ResponseResult<>(ResponseEnum.ERROR);
        } else {
            return new ResponseResult<>(999, "验证码错误");
        }
    }

    //验证码
    @ApiOperation("验证码获取")
    @GetMapping("/captcha")
    public void happyCaptcha(HttpServletRequest request, HttpServletResponse response) {
        HappyCaptcha.require(request, response).build().finish();
    }

    //验证码校验
//    @PostMapping("/verify")
    public boolean verify(@RequestBody String code, HttpServletRequest request) {
        //Verification Captcha
        return HappyCaptcha.verification(request, code, true);
    }

    //清理更换验证码
    @ApiOperation("清理更换验证码")
    @GetMapping("/remove/captcha")
    public void removeCaptcha(HttpServletRequest request, HttpServletResponse response) {
        HappyCaptcha.remove(request);
        happyCaptcha(request, response);
    }

}
