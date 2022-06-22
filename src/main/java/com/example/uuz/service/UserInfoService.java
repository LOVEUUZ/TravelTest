package com.example.uuz.service;

import com.example.uuz.bean.UserInfo;
import com.example.uuz.responseResult.ResponseResult;


public interface UserInfoService {

    ResponseResult<UserInfo> selectUserAll(String id);
}
