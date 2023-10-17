package com.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.component.MyException;
import com.component.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler(MyException.class)
	public ModelAndView handleMyException(MyException mex) {
		ModelAndView model = new ModelAndView();
		model.addObject("errCode", mex.getErrCode());
		model.addObject("errMsg", mex.getErrMsg());
		model.setViewName("show-error");
		return model;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView model = new ModelAndView();
		model.addObject("errMsg", ex.getMessage());
		model.setViewName("show-error");
		return model;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleResourceNotFoundException(ResourceNotFoundException ex) {
		ModelAndView model = new ModelAndView();
		model.addObject("errMsg", ex.getErrMsg());
		model.setViewName("show-error");
		return model;
	}

}
