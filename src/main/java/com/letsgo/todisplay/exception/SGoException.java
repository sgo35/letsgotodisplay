package com.letsgo.todisplay.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by moksha on 03/07/2016.
 */
@Getter
@Setter
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

}
