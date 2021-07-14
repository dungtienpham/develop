package com.laptrinhjavaweb.controller;

public class BusinessException extends BaseException {
	public BusinessException() {
	}

	public BusinessException(String code, String message) {
		super(code,message);
	}

	public BusinessException(String code, String message, String messageDescription) {
		super(code,message,messageDescription);

	}
}
