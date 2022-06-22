package com.example.uuz.service.UserServiceImpl;

import com.example.uuz.bean.Users1Bean;
import com.example.uuz.service.LoginService;
import org.springframework.stereotype.Service;


@Service("LoginService")
public class LoginServiceImpl implements LoginService {


    @Override
    public Users1Bean userLogin(String UserName, String PassWord) {
        Users1Bean users1Bean = new Users1Bean();
        System.out.println(users1Bean);
        return users1Bean;
    }

}
