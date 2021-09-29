package com.adp.billbreaker.exception;

public class InvalidBreakTypeException extends RuntimeException {

	private static final long serialVersionUID = 5109081883536777857L;

	private String message;

	public InvalidBreakTypeException(String message) {
		this.message = message;
	}

	public InvalidBreakTypeException() {
		this.message = "Bill Break Type is wrong. It should be maxcoins or mincoins";
	}

	public InvalidBreakTypeException(Exception e) {
		this.message = e.getMessage();
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}