package com.example.uuz.service.UserServiceImpl;

import com.example.uuz.bean.Users1Bean;
import com.example.uuz.service.RegisterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Override
    public void registerUser(String userName, String passWord) {

    }

    @Override
    public List<Users1Bean> repeatUserName(String userName) {
        return new ArrayList<Users1Bean>();
    }
}
