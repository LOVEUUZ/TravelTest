package com.example.uuz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users1Bean {

    private int ID;

    private String UserName;

    private String PassWord;

    private Date CreatTime;

    private String captcha;

}
