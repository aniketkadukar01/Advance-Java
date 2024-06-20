package com.app.custom_exception;

@SuppressWarnings("serial")
public class IllegalArgumentException extends RuntimeException {
	public IllegalArgumentException(String msg) {
		super(msg);
	}
}
