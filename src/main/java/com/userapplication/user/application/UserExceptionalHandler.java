package com.userapplication.user.application;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.ILoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RestControllerAdvice
public class UserExceptionalHandler {

    Log logger = LogFactory.getLog(Exception.class);

    @ExceptionHandler
    public String handleException(Exception exception){
        logger.info(exception.getMessage());
//        return exception.getMessage();
        return "exception created by rishi";
    }
}

