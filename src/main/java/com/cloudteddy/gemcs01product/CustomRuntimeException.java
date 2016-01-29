package com.cloudteddy.gemcs01product;

/**
 * Created by huylv on 29/01/2016.
 */
public class CustomRuntimeException extends RuntimeException {
    private String messageError;

    public CustomRuntimeException(String messageError) {
        this.messageError = messageError;
    }
}
