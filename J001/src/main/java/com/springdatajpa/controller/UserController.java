package com.springdatajpa.controller;

import com.springdatajpa.dto.UserDto;
import com.springdatajpa.modelcustom.UserPost;
import com.springdatajpa.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/save")
    public Long saveUser(@RequestBody UserDto user){
        Long id = userService.save(user);
        return id;
    }
    @GetMapping("/detail")
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/find")
    public List<UserDto> findUser(@RequestParam String username){
        return userService.findByName(username);
    }

    @GetMapping("/pass")
    public List<UserDto> findPassword(@RequestParam String password){
        return userService.findByPassword(password);
    }

    @GetMapping("/userpost")
    public ResponseEntity<List<UserPost>> getUserPost(){
        List<UserPost> list = userService.getUserPost();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @GetMapping("/userpostbyname")
    public ResponseEntity<List<UserPost>> getUserPost(@RequestParam("username") String username) {
        List<UserPost> list = userService.getUserPostByName(username);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<List<UserDto>> addUser(@RequestBody UserDto user){
        userService.save(user);
        List<UserDto> list = userService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<List<UserDto>> addUser(@RequestParam("username") String username) {
        userService.deleteByUsername(username);
        List<UserDto> list = userService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
