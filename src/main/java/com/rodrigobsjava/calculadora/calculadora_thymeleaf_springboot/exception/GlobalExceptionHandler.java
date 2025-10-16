package com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String, Object>> handleArithmeticException(ArithmeticException ex) {
		Map<String, Object> response = Map.of(
			"erro", ex.getMessage(), 
			"timestamp", LocalDateTime.now(), 
			"status", HttpStatus.BAD_REQUEST.value()
		);
		return ResponseEntity.badRequest().body(response);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
		Map<String, Object> response = Map.of(
			"erro", "Erro interno do servidor", 
			"detalhe", ex.getMessage(), 
			"timestamp", LocalDateTime.now(), 
			"status", HttpStatus.INTERNAL_SERVER_ERROR
		);
		return ResponseEntity.internalServerError().body(response);
	}
}
