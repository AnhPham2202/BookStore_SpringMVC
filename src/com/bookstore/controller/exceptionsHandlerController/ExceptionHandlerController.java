package com.bookstore.controller.exceptionsHandlerController;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javassist.NotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.JasperException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

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
	

	@ExceptionHandler({Exception.class, JasperException.class})
	 public String redirectToErrorPage(Exception e) {

	     return "error/500";
	 }

}
