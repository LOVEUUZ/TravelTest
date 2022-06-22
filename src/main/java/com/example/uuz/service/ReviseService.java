package com.example.uuz.service;

import com.example.uuz.bean.Users1BeanVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReviseService {

    Users1BeanVO verify(String userName, String passWord);

    @Select("SELECT UserName FROM users1 WHERE ID = #{ID}")
    String selectUserName(String ID);

    void sureUpdate(String userName, String passWord);
}
