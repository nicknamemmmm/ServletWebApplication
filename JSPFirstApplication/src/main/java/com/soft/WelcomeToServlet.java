package com.soft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class WelcomeToServlet extends HttpServlet{


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	PrintWriter pw = resp.getWriter();
	
	resp.setContentType("text/html");
	String str = "abcd";
	req.setAttribute("name",str);
	
	RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
	rd.forward(req, resp);
	}
}
