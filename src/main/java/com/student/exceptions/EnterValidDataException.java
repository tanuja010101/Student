package com.student.exceptions;

public class EnterValidDataException extends RuntimeException {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EnterValidDataException(String message) {
        super(message);
        this.msg = message;
    }
}
