package com.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/servlet01"})
public class Servlet01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter write = resp.getWriter();
		//
		String jdbc = (String)getServletContext().getInitParameter("jdbc");
		write.println("Hello servlet01, initparam in servletcontext: " + jdbc);
		//
		getServletContext().setAttribute("name", "java");
		//
		write.close();
	}
}
