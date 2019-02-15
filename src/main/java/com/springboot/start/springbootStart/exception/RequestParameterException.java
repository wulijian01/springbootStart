package com.springboot.start.springbootStart.exception;

import lombok.Getter;

@Getter
public class RequestParameterException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1531923230067326061L;
	
	private String code;
	
	public RequestParameterException(String message) {
		super(message);
		this.code="100";	
	}

}
