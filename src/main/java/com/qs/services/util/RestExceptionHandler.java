package com.qs.services.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
 
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleTheRest(Exception ex, WebRequest request) {
        logException(ex);
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String bodyOfResponse = error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
				status, request);
    }
    
    public static String error(HttpStatus status, String moreInfo) {
        String error = "{\"status\":\"" + status.value() + "\", " +
                "\"message\":\"" + status.getReasonPhrase() + "\", " +
        		"\"more_info\":\"" + moreInfo + "\"}";
        return error;
    }
    
    private void logException(Exception ex) {
		logger.error(ex.getMessage(), ex);
    }
}
