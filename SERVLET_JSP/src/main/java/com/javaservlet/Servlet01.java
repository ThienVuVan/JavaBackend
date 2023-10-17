package com.javaservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns = {"/servlet01"})
public class Servlet01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		write.println("<h1>Hello servlet01</h1>");
		Cookie cookie = new Cookie("name", "servlet01");
		Cookie cookie02 = new Cookie("age", "19");
		cookie.setMaxAge(10);
		cookie02.setMaxAge(20);
		resp.addCookie(cookie);
		resp.addCookie(cookie02);
		write.close();
	}
}
