package com.apifut.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apifut.services.exceptions.DatabaseException;
import com.apifut.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest r){
		String error = "Jogador não encontrado.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError  = new StandardError (Instant.now(),status.value(),error,e.getMessage(),r.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
		
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseError(DatabaseException e, HttpServletRequest r){
		String error = "Conflito no banco de dados.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError  = new StandardError (Instant.now(),status.value(),error,e.getMessage(),r.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
		
	}
	
}
