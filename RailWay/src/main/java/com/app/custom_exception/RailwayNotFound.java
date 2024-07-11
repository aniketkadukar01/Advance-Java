package com.app.custom_exception;

@SuppressWarnings("serial")
public class RailwayNotFound extends RuntimeException {
	
	public RailwayNotFound(String message) {
		super(message);
	}
}
