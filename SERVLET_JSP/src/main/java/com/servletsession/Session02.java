package com.servletsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/session02")
public class Session02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		String name = "";
		Integer age = null;
		HttpSession httpSession = req.getSession(); // create new session if server does not have any session else get
													// the current session;
		Object obj0 = httpSession.getAttribute("name");
		Object obj1 = httpSession.getAttribute("age");
		if (obj0 != null && obj1 != null) {
			name = String.valueOf(obj0);
			age = Integer.valueOf((String)obj1);
		} else {
			resp.sendRedirect("/ServletJsp/session01");
		}
		write.println("Name: " + name + " Age: " + age);
	}
}
