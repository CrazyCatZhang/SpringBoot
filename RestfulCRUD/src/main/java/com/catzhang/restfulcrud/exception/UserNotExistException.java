package com.catzhang.restfulcrud.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("User is not existed");
    }
}
