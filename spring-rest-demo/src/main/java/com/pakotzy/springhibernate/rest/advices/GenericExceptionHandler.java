package com.pakotzy.springhibernate.rest.advices;

import com.pakotzy.springhibernate.rest.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleGenericException(Exception e) {
		ExceptionResponse error = new ExceptionResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

