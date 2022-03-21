package com.userapplication.user.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionalHandler {

    Log logger = LogFactory.getLog(Exception.class);

    @ExceptionHandler
    public String handleException(Exception exception) {
        logger.info(exception.getMessage());
        return "exception created by rishi";
    }
}

