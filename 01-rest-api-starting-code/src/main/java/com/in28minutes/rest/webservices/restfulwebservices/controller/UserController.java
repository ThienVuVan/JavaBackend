package com.in28minutes.rest.webservices.restfulwebservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @PostMapping("/login")
    public ResponseEntity<Boolean> lognin(){
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }
}
