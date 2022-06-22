package com.example.uuz.responseResult;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)  //序列化操作
public class ResponseResult<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }


    public ResponseResult(int code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static <T> ResponseResult<T> okResult() {
        return new ResponseResult<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
    }

    public static <T> ResponseResult<T> okResult(T data) {
        return new ResponseResult<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data);
    }


    public static <T> ResponseResult<T> ErrorResult() {
        return new ResponseResult<>(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMsg());
    }


}
