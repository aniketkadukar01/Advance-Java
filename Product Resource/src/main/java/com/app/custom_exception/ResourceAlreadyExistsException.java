package com.app.custom_exception;

@SuppressWarnings("serial")
public class ResourceAlreadyExistsException extends RuntimeException {
	public ResourceAlreadyExistsException(String msg) {
		super(msg);
	}
}
