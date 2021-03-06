package com.bookstore.controller.exceptionsHandlerController;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javassist.NotFoundException;

import org.springframework.http.HttpStatus;


@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public String handleWrongUrl()  {
	     return "error/404";
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = NotFoundException.class)
	public String handle404()  {
	     return "error/404";
	}
	

	@ExceptionHandler({Exception.class})
	 public String redirectToErrorPage(Exception e) {

	     return "error/500";
	 }

}
