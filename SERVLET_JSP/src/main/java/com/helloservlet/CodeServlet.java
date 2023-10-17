package com.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/test-code")
public class CodeServlet extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		resp.sendError(501);
		write.println("badgateway");
	}
	
	// 100 continue
	// 200 sucsses
	// 301 redirect url
	// 401 unauthoried
	// 403 forbidden
	// 404 not found
	// 500
	// 502 bad gateway
}
