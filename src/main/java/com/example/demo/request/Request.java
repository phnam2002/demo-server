package com.example.demo.request;

import java.sql.Date;


public class Request<T>{
    private int status;
    private String message;
    private T data;

    public Request(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Request() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
