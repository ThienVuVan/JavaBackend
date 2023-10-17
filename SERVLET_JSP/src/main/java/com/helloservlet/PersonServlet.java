package com.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/addPerson")
public class PersonServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		write.println("Name: " + name + " Age: " + age + " Address: " + address);
		write.close();
	}
	
	// Name: Vũ Văn Thiện Age: 19 Address: Bạch Liên
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		write.println("method: " + req.getMethod());
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		write.println("Name: " + name + " Age: " + age + " Address: " + address);
		write.close();
		// http://localhost:8080/ServletJsp/addPerson?name=V%26%23361%3B+V%26%23259%3Bn+Thi%26%237879%3Bn&age=19&address=B%26%237841%3Bch+Li%EAn
	}
}
