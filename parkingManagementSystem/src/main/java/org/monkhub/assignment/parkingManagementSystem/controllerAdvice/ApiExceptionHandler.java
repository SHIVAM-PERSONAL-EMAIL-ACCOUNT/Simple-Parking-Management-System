package org.monkhub.assignment.parkingManagementSystem.controllerAdvice;

import org.monkhub.assignment.parkingManagementSystem.controllerAdvice.exceptions.EntryNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {DataIntegrityViolationException.class, EntryNotFoundException.class})
	private ResponseEntity<Object> handleInvalidCredentials(RuntimeException rex, WebRequest wx) {
		return handleExceptionInternal(rex, rex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, wx);
	}
}
