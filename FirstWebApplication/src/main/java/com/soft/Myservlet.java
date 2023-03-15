package com.soft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Myservlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<h1>This is my servlet</h1>");
	}

}
