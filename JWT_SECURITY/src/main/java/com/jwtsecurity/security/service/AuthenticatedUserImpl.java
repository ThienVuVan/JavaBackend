package com.jwtsecurity.security.service;

import com.jwtsecurity.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.*;

public class AuthenticatedUserImpl implements Authentication {
    private String email;
    private  Collection<? extends GrantedAuthority> authorities;
    private boolean authenticated;
    private UserDetailsService userDetailsService;
    public AuthenticatedUserImpl(String email) {
        // Get UserDetailsService from Context, Cannot Autowired In Non-Managed Class By Spring;
        userDetailsService = BeanUtils.getBean(UserDetailServiceImpl.class);
        User user = (User) userDetailsService.loadUserByUsername(email);
        this.email = user.getUsername();
        this.authorities = user.getAuthorities();
        this.authenticated = true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public Object getCredentials() {
        return null;
    }
    @Override
    public Object getDetails() {
        return null;
    }
    @Override
    public Object getPrincipal() {
        return email;
    }
    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }
    @Override
    public String getName() {
        return email;
    }
}
