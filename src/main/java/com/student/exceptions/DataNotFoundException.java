package com.student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends Exception{
    public DataNotFoundException(String Exception)
    {
        super(Exception);
    }

}
