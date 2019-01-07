package com.letsgo.todisplay.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;

/**
 * Created by moksha on 03/07/2016.
 */
public class SGoException extends IOException {
    private HttpStatus statusCode;

    private String body;

    public SGoException(String msg) {
        super(msg);
    }

    public SGoException(HttpStatus statusCode, String msg) {
        super(msg);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
