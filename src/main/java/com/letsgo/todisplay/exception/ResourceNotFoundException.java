package com.letsgo.todisplay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	@Getter String resourceName;
	@Getter	String fieldName;
	@Getter Object fieldValue;

    public ResourceNotFoundException() {
        // TODO Auto-generated constructor stub
    }

    public ResourceNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }
}
