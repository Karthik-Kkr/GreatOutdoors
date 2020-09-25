package com.capgemini.go.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "You cant cancel the order now", value = HttpStatus.LOCKED)
public class CancelException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CancelException(String message) {
		super(message);
	}
}
