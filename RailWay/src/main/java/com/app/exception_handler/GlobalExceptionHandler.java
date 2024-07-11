package com.app.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exception.RailwayNotFound;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RailwayNotFound.class)
	public ResponseEntity<String> handleRailwayNotFound(RailwayNotFound ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
