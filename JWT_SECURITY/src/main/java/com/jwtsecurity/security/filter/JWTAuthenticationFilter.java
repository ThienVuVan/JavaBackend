package com.jwtsecurity.security.filter;

import com.jwtsecurity.security.service.TokenAuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

// OncePerRequestFilter is executed only once for a given request
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = new TokenAuthenticationService().authenticateRequestByToken(request);
        // Set into SecurityContextHolder to Authorization;
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Goto EndPoint;
        filterChain.doFilter(request,response);
    }
}
