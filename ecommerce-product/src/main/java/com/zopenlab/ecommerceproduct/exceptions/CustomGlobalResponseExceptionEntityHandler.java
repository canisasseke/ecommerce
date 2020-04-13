package com.zopenlab.ecommerceproduct.exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalResponseExceptionEntityHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
		
		Map<String, Object> body= new LinkedHashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.NOT_FOUND.value());
		body.put("errors", Arrays.asList(ex.getMessage()));
		
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleProductNotFoundException(Exception ex, WebRequest request) {
		
		Map<String, Object> body= new LinkedHashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.put("errors", Arrays.asList(ex.getMessage()));
		
		return new ResponseEntity<Object>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, Object> body= new LinkedHashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", status);
		List<String> errors = ex.getBindingResult()
								.getFieldErrors()
								.stream()
								.map(x -> x.getDefaultMessage())
								.collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<Object>(body, headers, status);
	}
	
	

}
