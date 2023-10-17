package com.servletsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/session01")
public class Session01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession(); // create new session if server does not have any session else get
													// the current session;
		httpSession.setAttribute("name", "thien");
		httpSession.setAttribute("age", "19");
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		write.println("hello - set session");
	}
}
