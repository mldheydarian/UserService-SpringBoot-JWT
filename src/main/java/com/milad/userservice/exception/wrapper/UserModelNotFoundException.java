package com.milad.userservice.exception.wrapper;

public class UserModelNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserModelNotFoundException(String message) {
        super(message);
    }

    public UserModelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserModelNotFoundException(Throwable cause) {
        super(cause);
    }


}
