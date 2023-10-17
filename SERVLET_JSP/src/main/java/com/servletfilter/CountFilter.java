package com.servletfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "count", value = "100") })
public class CountFilter implements Filter {

	private int count;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String c = filterConfig.getInitParameter("count");
		count = Integer.valueOf(c);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		count++;
		System.out.println(count);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}
