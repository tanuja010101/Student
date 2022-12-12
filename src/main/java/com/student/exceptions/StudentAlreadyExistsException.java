package com.student.exceptions;

public class StudentAlreadyExistsException extends RuntimeException {

    private String msg;

    public StudentAlreadyExistsException() {
    }

    public StudentAlreadyExistsException(String message) {
        super(message);
        this.msg = message;
    }
}
