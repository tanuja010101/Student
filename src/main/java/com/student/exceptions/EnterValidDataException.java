package com.student.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class EnterValidDataException extends Exception {
    public EnterValidDataException(String message) {

        super(message);
    }

}
