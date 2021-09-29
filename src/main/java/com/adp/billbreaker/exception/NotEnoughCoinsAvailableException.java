package com.adp.billbreaker.exception;

public class NotEnoughCoinsAvailableException extends RuntimeException {

	private static final long serialVersionUID = 5109081883536777857L;

	private String message;

	public NotEnoughCoinsAvailableException(String message) {
		this.message = message;
	}

	public NotEnoughCoinsAvailableException() {
		this.message = "Not Enough Coin Available for the given bill";
	}

	public NotEnoughCoinsAvailableException(Exception e) {
		this.message = e.getMessage();
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}