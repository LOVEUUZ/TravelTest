package com.example.uuz.mapper;

import com.example.uuz.bean.UserInfo;
import com.example.uuz.bean.Users1Bean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    Users1Bean selectUserAll(String id);

    @Select("select * from userInfo where UserName = #{UserName}")
    UserInfo selectUserMsgAll(String UserName);
}
