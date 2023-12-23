package com.sercurity.spring_sercurity_oauth2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.oauth2.login.OAuth2LoginSecurityMarker;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
    @GetMapping("/normal")
    public ResponseEntity<?> demo(){
        return ResponseEntity.ok("login normal is successful");
    }

    @GetMapping("/oauth")
    public ResponseEntity<?> test(@AuthenticationPrincipal OAuth2User oAuth2User){
        return ResponseEntity.ok(oAuth2User.getAttributes());
    }
}
