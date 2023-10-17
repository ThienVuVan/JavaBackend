package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {
	@GetMapping(value = { "/hello", "/" })
	public String showHello(ModelMap model) {
		model.addAttribute("message", "Hi everyone !");
		return "hello-form";
	}
}
