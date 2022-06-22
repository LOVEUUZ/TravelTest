package com.example.uuz.service.UserServiceImpl;

import com.example.uuz.bean.Users1BeanVO;
import com.example.uuz.service.ReviseService;
import org.springframework.stereotype.Service;

@Service
public class ReviseServiceImpl implements ReviseService {

    @Override
    public Users1BeanVO verify(String userName, String passWord) {
        return new Users1BeanVO();
    }

    @Override
    public String selectUserName(String subject) {
        return null;
    }

    @Override
    public void sureUpdate(String userName, String passWord) {

    }
}
