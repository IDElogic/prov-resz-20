package com.xoxo.logistic.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.xoxo.logistic.service.NonUniqueStreetAddressException;

@RestControllerAdvice
public class CustomExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);


	@ExceptionHandler(NonUniqueStreetAddressException.class)
	public ResponseEntity<MyError> handleNonUniqueIata(NonUniqueStreetAddressException e, WebRequest req){
		log.warn(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new MyError(e.getMessage(), 1002));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> handleValidationError(MethodArgumentNotValidException e, WebRequest req){
		log.warn(e.getMessage(), e);
		MyError myError = new MyError(e.getMessage(), 1002);
		myError.setFieldErrors(e.getBindingResult().getFieldErrors());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(myError);
	}
}
