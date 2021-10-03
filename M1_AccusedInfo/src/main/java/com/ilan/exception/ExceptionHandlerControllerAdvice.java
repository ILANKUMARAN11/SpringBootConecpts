package com.ilan.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(BrioTecException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final BrioTecException e,final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse(new Date(), e.getMessage(),request.getRequestURI());
		error.setErrorMessage(e.getMessage());
		error.setRequestedURI(request.getRequestURI());

		return error;
	}
	
	
	

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception e,final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse(new Date(), e.getMessage(),request.getRequestURI());
		error.setErrorMessage(e.getMessage());
		error.setRequestedURI(request.getRequestURI());

		return error;
	}

	@ExceptionHandler(ArithmeticException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException1(final Exception e,final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse(new Date(), e.getMessage(),request.getRequestURI());
		error.setErrorMessage(e.getMessage());
		error.setRequestedURI(request.getRequestURI());

		return error;
	}

}

