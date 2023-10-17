package com.bookuser.controller;

import com.bookuser.dto.UserDTO;
import com.bookuser.entity.User;
import com.bookuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") User user, ModelMap model) {
        System.out.println(user);
        User userResult = userService.checklogin(user);
        if (userResult != null) {
            model.addAttribute("userName", userResult.getUserName());
            return "welcome";
        } else {
            model.addAttribute("error", "invalid");
            return "login";
        }
    }

    // I changed this;
    @GetMapping("/list-user")
    public List<UserDTO> getUser() {
        List<User> list = userService.getUser();
        List<UserDTO> listDto = new ArrayList<UserDTO>();
        for (User user : list) {
            listDto.add(new UserDTO(user.getUserId(), user.getUserName(), user.getPassword()));
        }
        return listDto;
    }

    @GetMapping("/addUser")
    public String addUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user, ModelMap model) {
//		if(result.hasErrors()) {
//			return "addUser";
//		}
		userService.saveUser(user);
		return "redirect:/user/list-user";
	}

    @GetMapping("/detail/{userId}")
    public String getBook(ModelMap model, @PathVariable("userId") String userId) {
        return "redirect:/book/" + userId + "/list-book";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int userId) {
        return "redirect:/book/" + userId + "/delete";
    }
}
