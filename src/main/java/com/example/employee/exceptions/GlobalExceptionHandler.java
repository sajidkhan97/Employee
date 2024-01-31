package com.example.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(CustomException.class)
	    public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request) {
	        Map<String, Object> errorDetails = new HashMap<>();
	        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
	        errorDetails.put("error", "Custom Exception");
	        errorDetails.put("message", ex.getMessage());
	        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	        Map<String, Object> errorDetails = new HashMap<>();
	        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorDetails.put("error", "Internal Server Error");
	        errorDetails.put("message", ex.getMessage());
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    
    }

}
