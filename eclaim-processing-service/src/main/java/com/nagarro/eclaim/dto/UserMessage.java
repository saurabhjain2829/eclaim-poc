package com.nagarro.eclaim.dto;

import java.io.Serializable;

public class UserMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    private int code;


    public UserMessage() {

    }


    public UserMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }


    public int getCode() {
        return code;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public void setCode(int code) {
        this.code = code;
    }

}
