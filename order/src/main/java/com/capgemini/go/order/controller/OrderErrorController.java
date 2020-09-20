package com.capgemini.go.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderErrorController {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code =HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "Enter the correct Url")
	public void handleError() {
		
	}
}
