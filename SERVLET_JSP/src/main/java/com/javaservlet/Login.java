package com.javaservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		write.println("<form action='/ServletJsp/login' method='post'>");
		write.println("UserName: <input type='text' name='userName'> <br/>");
		write.println("UserPassword: <input type='password' name='userPassword'> <br/>");
		write.println("<input type='submit' value='Login'> <br/>");
		write.println("<form/>");
		write.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userPassword = req.getParameter("userPassword");
		if(userName.equals("thien") && userPassword.equals("12345")) {
			Cookie cookie = new Cookie("userName", userName);
			cookie.setMaxAge(30);
			resp.addCookie(cookie);
			resp.sendRedirect("/ServletJsp/welcome");
		}else {
			resp.sendRedirect("/ServletJsp/login");
		}
	}
}
