package com.springboot.start.springbootStart.exception.handler;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestController
//@ControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//	@ExceptionHandler(BindException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ExceptionResponse handleBindException(BindException e) {
//
//		return new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage(),
//				UUID.randomUUID().toString());
//	}
//
//}
