package com.example.newsservice.pojo;

/**
 * @author myself
 */
public class RequestResult<T> {

    private T data;

    private String message;

    private int code;

    public RequestResult() {
    }

    public RequestResult(T data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public RequestResult(String message, Integer code) {
        this(null, message, code);
    }

    public RequestResult(T data) {
        this(data, "操作成功", 200);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
