package com.helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/form-add")
public class FormPerson extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		write.println("<form action='/ServletJsp/addPerson' method='post'>");
		write.println("Name: <input type='text' name='name'><br/>");
		write.println("Age: <input type='text' name='age'><br/>");
		write.println("Address: <input type='text' name='address'><br/>");
		write.println("<input type='submit' value='Submit'>");
		write.println("</form>");
		write.close();
	}
	
}
