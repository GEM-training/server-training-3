package com.cloudteddy.gemcs01product;

/**
 * Created by huylv on 29/01/2016.
 */
public class CustomRuntimeException extends RuntimeException {
    private String message;

    public CustomRuntimeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
