package com.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/")
	public String addUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "addUser";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			System.out.println("error");
			return "addUser";
			
		}
		model.addAttribute("user", user);
		return "welcome";
	}

}
