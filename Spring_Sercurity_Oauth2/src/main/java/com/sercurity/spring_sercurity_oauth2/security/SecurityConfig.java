package com.sercurity.spring_sercurity_oauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(request -> request
                .anyRequest()
                .authenticated());
        // say spring security have oauth2 authentication
//        http.oauth2Login(Customizer.withDefaults());
        /*
        step1: redirect http://localhost:8080/oauth2/authorization/google
        or http://localhost:8080/oauth2/authorization/github
        step2: redirect https://accounts.google.com/o/oauth2/v2/auth?response_type=code&client_id=1021338613424-mjfoqf03hi8dfmv87mfm86ghqtqe908g.apps.googleusercontent.com&scope=email%20profile&state=9nTFJFKq2wEgSSAlWFY-WPGQBpejxVUNq5CNjGBn84E%3D&redirect_uri=http://localhost:8080/login/oauth2/code/google
        step3: redirect http://localhost:8080/login/oauth2/code/google?state=9nTFJFKq2wEgSSAlWFY-WPGQBpejxVUNq5CNjGBn84E%3D&code=4%2F0AfJohXn7L_yETr0-pxAQXQjb26CEKXlVJRoX4eb3iXSG8toX6TuO3qUYdgF0ivIbGdkcag&scope=email+profile+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile+openid&authuser=0&prompt=none
        after step3: set authentication object to security context
        step4: redirect http://localhost:8080/api/v1/oauth
        */
        // say the default redirect when login success
        http.oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("/api/v1/oauth"));
        http.formLogin(login -> login.defaultSuccessUrl("/api/v1/normal"));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
