package br.com.gunthercloud.distributor.controller.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.gunthercloud.distributor.service.exceptions.DatabaseException;
import br.com.gunthercloud.distributor.service.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> findById(NotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("NotFoundException error");
		err.setMessage(e.getLocalizedMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		StandardError standard = new StandardError();
		standard.setTimestamp(Instant.now());
		standard.setStatus(HttpStatus.BAD_REQUEST.value());
		standard.setError("DatabaseException error");
		standard.setPath(request.getRequestURI());
		standard.setMessage(e.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standard);
	}

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> bodyIsEmpty(DataIntegrityViolationException e, HttpServletRequest req) {
        StandardError standard = new StandardError();
        standard.setPath(req.getRequestURI());
        standard.setError("DataIntegrityViolationException error");
        standard.setTimestamp(Instant.now());
        standard.setStatus(HttpStatus.CONFLICT.value());
        String[] parts = e.getLocalizedMessage().split(":");
        standard.setMessage(parts[0] + "!");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(standard);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegal(IllegalArgumentException e, HttpServletRequest req) {
        StandardError standard = new StandardError();
        standard.setPath(req.getRequestURI());
        standard.setError("IllegalArgumentException error");
        standard.setTimestamp(Instant.now());
        standard.setStatus(HttpStatus.BAD_REQUEST.value());
        standard.setMessage(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standard);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<StandardError> invalidTransient(InvalidDataAccessApiUsageException e, HttpServletRequest req) {
        StandardError standard = new StandardError();
        standard.setPath(req.getRequestURI());
        standard.setError("InvalidDataAccessApiUsageException error");
        standard.setTimestamp(Instant.now());
        standard.setStatus(HttpStatus.BAD_REQUEST.value());
        standard.setMessage(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standard);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> bodyIsEmpty(HttpMessageNotReadableException e, HttpServletRequest req) {
        StandardError standard = new StandardError();
        standard.setPath(req.getRequestURI());
        standard.setError("HttpMessageNotReadableException error");
        standard.setTimestamp(Instant.now());
        standard.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        String[] parts = e.getLocalizedMessage().split(":");
        standard.setMessage(parts[0] + "!");
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(standard);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError standard = new ValidationError();
        standard.setTimestamp(Instant.now());
        standard.setStatus(HttpStatus.BAD_REQUEST.value());
        standard.setError("MethodArgumentNotValidException error");
        standard.setMessage("Validation failed in these fields below");
        standard.setPath(request.getRequestURI());
        for(FieldError f : e.getBindingResult().getFieldErrors()) {
            standard.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standard);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationError> constraintViolation(ConstraintViolationException e, HttpServletRequest request) {
        ValidationError standard = new ValidationError();
        standard.setTimestamp(Instant.now());
        standard.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        standard.setError("ConstraintViolationException error");
        standard.setMessage("Validation failed in these fields below");
        standard.setPath(request.getRequestURI());
        for(ConstraintViolation<?> f : e.getConstraintViolations()) {
            standard.addError(f.getPropertyPath().toString(),f.getMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(standard);
    }
}
