package com.capgemini.go.order.exception;

public class CancelException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CancelException(String message) {
		super(message);
	}
}
