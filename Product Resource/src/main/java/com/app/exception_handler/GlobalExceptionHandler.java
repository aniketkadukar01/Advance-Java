package com.app.exception_handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exception.ProductNotFoundException;
import com.app.custom_exception.ResourceAlreadyExistsException;


//Global  
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//similar to IllegalArgumentException
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<String> 
	handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex){
		//fluent Api
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}
	
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> 
	handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		String errorMessage ="Validation failed : ";
		for(FieldError error : (List<FieldError>) ex.getBindingResult().getFieldError()) {
			errorMessage+=error.getDefaultMessage() + "; ";
			System.out.println();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex){
		//traditional Way
		return new ResponseEntity<String>(ex.getMessage()
				,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> 
	handleProductNotFoundException(ProductNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
}
