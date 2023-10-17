package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xyz")
public class InterceptorController {
	@GetMapping("/")
	public String Test() {
		System.out.println("Test");
		return "index";
	}
}
