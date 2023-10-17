package com.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

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
		write.println("<h1>Hello servlet02</h1>");
		
		String name = (String)getServletContext().getAttribute("name");
		
		write.println("Hello: " + name);
		write.close();
	}
}
