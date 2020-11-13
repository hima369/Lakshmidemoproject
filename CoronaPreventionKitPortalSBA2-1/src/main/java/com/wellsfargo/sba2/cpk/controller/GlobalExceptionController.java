package com.wellsfargo.sba2.cpk.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.sba2.cpk.exception.cpkException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(cpkException.class)
	public ModelAndView handlekitException(cpkException exception) {
		return new ModelAndView("errPage", "errMsg", exception.getMessage());
	}
	
}
