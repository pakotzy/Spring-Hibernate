package com.pakotzy.springhibernate.restcrm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
}
