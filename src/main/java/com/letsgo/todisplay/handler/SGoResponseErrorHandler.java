package com.letsgo.todisplay.handler;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import com.letsgo.todisplay.exception.SGoException;


/**
 * Created by moksha on 03/07/2016.
 */
public class SGoResponseErrorHandler implements ResponseErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(SGoResponseErrorHandler.class);

    private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

    public boolean hasError(ClientHttpResponse response) throws IOException {
        return errorHandler.hasError(response);
    }

    public void handleError(ClientHttpResponse response) throws IOException {
        logger.error("Response error: {} {}", response.getStatusCode(), response.getStatusText());
        SGoException exception = new SGoException(response.getStatusCode(), response.getStatusText());
        throw exception;
    }
}
