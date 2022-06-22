package com.example.uuz.service.UserServiceImpl;

import com.example.uuz.bean.UserInfo;
import com.example.uuz.bean.Users1Bean;
import com.example.uuz.mapper.UserInfoMapper;
import com.example.uuz.responseResult.ResponseResult;
import com.example.uuz.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ResponseResult<UserInfo> selectUserAll(String id) {
        Users1Bean users1Bean = userInfoMapper.selectUserAll(id);
        UserInfo userInfo = userInfoMapper.selectUserMsgAll(users1Bean.getUserName());
        userInfo.setCreatTime(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(users1Bean.getCreatTime()));
        return ResponseResult.okResult(userInfo);
    }
}
