package com.capgemini.go.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Found", value = HttpStatus.NOT_FOUND)
public class OrderIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OrderIdNotFoundException(String message) {
		super(message);
	}

}
