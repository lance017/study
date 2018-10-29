package com.lance017.study.advice;

/**
 * @author lance
 * @date Created by on 2018/10/29.下午7:51
 */
public class MyException extends RuntimeException{

    private String msg;

    private String code;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
