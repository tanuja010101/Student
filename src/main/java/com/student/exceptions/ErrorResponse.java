package com.student.exceptions;

public class ErrorResponse {
    private int msgCode;
    private String msg;

    public ErrorResponse() {

    }

    public ErrorResponse(int msgCode, String msg) {
        this.msgCode = msgCode;
        this.msg = msg;
    }

    public ErrorResponse(String msg) {
        super();
        this.msg = msg;

    }

    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
