package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.component.MyException;
import com.component.ResourceNotFoundException;

@Controller
@RequestMapping("/abc")
public class MathController {

	@GetMapping("/")
	public String login() {
		return "input";
	}

	@GetMapping("/caculate")
	public String calculateSum(@RequestParam("a") int a, @RequestParam("b") int b, ModelMap model) {

		model.addAttribute("sum", (a + b));
		model.addAttribute("subtract", (a - b));
		model.addAttribute("multiply", (a * b));
		model.addAttribute("divide", (a / b));

		return "MathResult";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String doFileUpload(@RequestParam("a") int a) throws IOException, SQLException {

		// handles file upload stuff...
		if (a == 1) {
			throw new IOException("Could not read upload file.");
		} else if (a == 2) {
			throw new SQLException("Database exception!!!");
		} else if (a == 3) {
			throw new MyException("myerror01", "this is myexception");
		} else if (a == 4) {
			throw new ResourceNotFoundException("404");
		}
		return "done";
	}

//	@ExceptionHandler({ IOException.class, java.sql.SQLException.class })
//	public ModelAndView handleIOException(Exception ex) {
//		ModelAndView model = new ModelAndView("exception");
//		model.addObject("exception", ex.getMessage());
//		return model;
//	}

}
