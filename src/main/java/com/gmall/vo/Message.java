package com.gmall.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author chenyisheng
 * @Date 2019/1/29 14:14
 * @Description
 * @Version 1.0
 **/
@Data
public class Message<T> implements Serializable {

    public static final Message FACTORY = new Message();

    private static final long serialVersionUID = 7903762158672432784L;
    private int code;
    private String msg;
    private T data;

    public Message<T> build(Integer code) {
        return this.build(code, null);
    }

    public Message<T> build(Integer code, String msg) {
        return this.build(code, msg, null);
    }

    public Message<T> build(Integer code, String msg, T data) {
        return new Message(code, msg, data);
    }

    public Message<T> success(T data){
        return new Message(ResponseStatus.OK.getCode(), ResponseStatus.OK.getMessage(), data);
    }


    public Message(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Message() {
    }

    public Message(ResponseStatus status) {
        this.code = status.getCode();
        this.msg = status.getMessage();
    }

    public static Message success() {
        return new Message(ResponseStatus.OK);
    }

    public static Message failed() {
        return new Message(ResponseStatus.FAILED);
    }
}
