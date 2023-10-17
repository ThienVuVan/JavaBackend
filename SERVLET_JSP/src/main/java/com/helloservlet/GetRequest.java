package com.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/get-request")
public class GetRequest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		write.println("test");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		write.println("hello: " + name + " age: " + age);
	}
	// http://localhost:8080/ServletJsp/get-request?name=thien
	// test hello: thien
	// http://localhost:8080/ServletJsp/get-request?name=thien&age=19
	// test hello: thien age: 19
}
