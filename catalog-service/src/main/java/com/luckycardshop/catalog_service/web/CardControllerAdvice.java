package com.luckycardshop.catalog_service.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.luckycardshop.catalog_service.domain.CardAlreadyExistsException;
import com.luckycardshop.catalog_service.domain.CardNotFoundException;

@RestControllerAdvice
public class CardControllerAdvice {
	//@RestControllerAdvice annotation marks a class as a centralized exception handler
	
	//@ExceptionHandler marks the method as the one to handle this specific exception
	@ExceptionHandler(CardNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String cardNotFoundHandler(CardNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(CardAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	String cardAlreadyExistsHandler(CardAlreadyExistsException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		var errors = new HashMap<String, String>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}
}
