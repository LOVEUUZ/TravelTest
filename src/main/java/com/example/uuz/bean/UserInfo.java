package com.example.uuz.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private int Id;
    private String userName;
    private String phone;
    private String address;
    private String addressFull;
    private String order;
    private String CreatTime;
}
