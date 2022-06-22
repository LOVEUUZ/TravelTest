package com.example.uuz.service;

import com.example.uuz.bean.Users1Bean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegisterService {

    void registerUser(String userName, String passWord);

    @Select("SELECT UserName FROM users1 WHERE Username=#{UserName}")
    List<Users1Bean> repeatUserName(String userName);
}
