package com.nagarro.eclaim.exceptions.handler;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nagarro.eclaim.constants.Constants;
import com.nagarro.eclaim.dto.UserMessage;
import com.nagarro.eclaim.exceptions.EclaimException;
import com.nagarro.eclaim.exceptions.InvalidRequestException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@ExceptionHandler(value = { InvalidRequestException.class })
	protected ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException ex, WebRequest request) {
		LOGGER.error("Error occured", ex);
		return handleExceptionInternal(ex, new UserMessage(Constants.ERROR_CODE, ex.getMessage()), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = { EclaimException.class })
	protected ResponseEntity<Object> handleEclaimException(EclaimException ex, WebRequest request) {
		LOGGER.error("Error occured", ex);
		return handleExceptionInternal(ex, new UserMessage(Constants.ERROR_CODE, ex.getMessage()), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleExceptionRequestException(Exception ex, WebRequest request) {
		LOGGER.error("Error occured", ex);
		return handleExceptionInternal(ex, new UserMessage(Constants.ERROR_CODE, ex.getMessage()), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { ObjectOptimisticLockingFailureException.class })
	protected ResponseEntity<Object> handleSimultaneousDBOperationException(ObjectOptimisticLockingFailureException ex,
			WebRequest request) {
		LOGGER.error("Error occured", ex);
		return handleExceptionInternal(ex, new UserMessage(Constants.ERROR_CODE, Constants.SIMULTANEOUS_UPDATE_MSG),
				new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { Throwable.class })
	protected ResponseEntity<Object> handleException(ObjectOptimisticLockingFailureException ex, WebRequest request) {
		LOGGER.error("Error occured", ex);
		return handleExceptionInternal(ex, new UserMessage(Constants.ERROR_CODE, Constants.INTERNAL_SERVER_ERROR),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
