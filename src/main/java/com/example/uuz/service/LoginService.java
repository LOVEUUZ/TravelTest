package com.example.uuz.service;

import com.example.uuz.bean.Users1Bean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface LoginService {

    @Select("SELECT * FROM users1 WHERE Username=#{UserName} and PassWord = #{PassWord}")
    Users1Bean userLogin(String UserName, String PassWord);
}
