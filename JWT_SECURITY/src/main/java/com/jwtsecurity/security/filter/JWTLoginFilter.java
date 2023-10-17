package com.jwtsecurity.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwtsecurity.security.credentials.AccountCredentials;
import com.jwtsecurity.security.service.TokenAuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

// The filter requires that you set the authenticationManager property, and a request URL to intercept;
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    private TokenAuthenticationService tokenAuthenticationService;
    public JWTLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManager);
        tokenAuthenticationService = new TokenAuthenticationService();
    }
    // Get User Credentials To Authenticate and ifSuccess Set Into SecurityContext for the current thread;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
        AccountCredentials credentials = new ObjectMapper().readValue(request.getInputStream(),AccountCredentials.class);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        return getAuthenticationManager().authenticate(token);
    }
    // Run If Authentication Success;
    // Target: Response a Token;
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication  authentication) throws IOException {
        String email = authentication.getName();
        tokenAuthenticationService.generateToken(response,email);
    }
}
