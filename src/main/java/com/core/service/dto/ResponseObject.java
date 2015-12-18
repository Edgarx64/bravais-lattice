package com.core.service.dto;

import org.apache.commons.httpclient.HttpStatus;

public class ResponseObject<T> {
    private int status;
    private String message;
    private T data;

    public ResponseObject(){
        status = HttpStatus.SC_OK;
        message = "OK";
    }

    public ResponseObject(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
