package com.student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends Exception{
    private String msg;
    public DataNotFoundException(){

    }
    public DataNotFoundException(String message)
    {
        super(message);
        this.msg=message;
    }

}
