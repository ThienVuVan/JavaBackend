package com.javaservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns = {"/servlet02"})
public class Servlet02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		write.println("Hello servlet02 <br/>");
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			write.println(cookie.getName() + " : " + cookie.getValue() + "<br/>");
			if(cookie.getName().equals("age")) {
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
		write.close();
	}
	// cookie is store in header stored in HttpRequest
}
