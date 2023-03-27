package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.soft.dao.DBconnection;

public class LoginServlet extends GenericServlet{

Connection con = null;
	
	public void init() {
		DBconnection dbcon = new DBconnection();
		con = dbcon.createConnection();
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			String email = req.getParameter("userEmail");
			String password = req.getParameter("userPassword");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user_details.user where useremail=? AND password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pw.println("Login succesfully");
				pw.println("welcome::"+rs.getString(2));
				
				req.setAttribute("username", rs.getString(2));
				req.setAttribute("useremail", rs.getString(2));
				
			}else {
				pw.println("Login not succesfull");
			}
			
		} catch (Exception e) {
			
		}
	}
	public void destroy() {
		
	}

}
