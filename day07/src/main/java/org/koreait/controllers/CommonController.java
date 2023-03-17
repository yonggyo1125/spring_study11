package org.koreait.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonController {
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e, Model model) {
		e.printStackTrace();
		
		model.addAttribute("errorMessage", e.getMessage());
		
		return "errors/error";
	}
	
}
