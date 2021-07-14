package com.laptrinhjavaweb.controller;

public class BaseException extends RuntimeException {
	protected String code;
	protected String message;
	protected String messageDescription;

	public BaseException() {
	}

	public BaseException(String code, String message, String messageDescription) {
		super(message);
		this.code = code;
		this.message = message;
		this.messageDescription = messageDescription;
	}

	public BaseException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDescription() {
		return messageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

}
