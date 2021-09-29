package com.adp.billbreaker.exception;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorInfo handleNotFoundException(NoHandlerFoundException exception ) {
		logger.error("", exception.getMessage());
        return new ErrorInfo(exception.getMessage(), "BadRequest", "10001", "Request");
    }
	
	@ResponseBody
    @ExceptionHandler(InvalidBreakTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleInvalidBreakTypeException(InvalidBreakTypeException exception){
		logger.error("", exception.getMessage());
        return new ErrorInfo(exception.getMessage(), "BadRequest", "10002", "Request");
    }

	@ResponseBody
    @ExceptionHandler(NotEnoughCoinsAvailableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo handleNotEnoughCoinsAvailableException(NotEnoughCoinsAvailableException exception){
		logger.error("", exception.getMessage());
        return new ErrorInfo(exception.getMessage(), "Resource Unavailable", "10003", "Server");
    }
	
	@ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorInfo handleConstraintViolationException(ConstraintViolationException exception){
		logger.error("", exception.getMessage());
        return new ErrorInfo(exception.getMessage(), "BadRequest", "10004", "Request");
    }
	
	@ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInfo handleInternalException(Exception exception) {
        return new ErrorInfo(exception.getMessage(), "Internal Server Error", "10005", "Server");
    }

}
