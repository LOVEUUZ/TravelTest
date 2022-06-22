package com.example.uuz.responseResult;

public enum ResponseEnum {
    SUCCESS(200, "操作成功"),
    ERROR(999, "账号或者密码错误"),
    NEED_LOGIN(401, "需要登录后操作"),
    ACCOUNT_REPEAT(402,"账户名称重复,请更换");

    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
