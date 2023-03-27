package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.soft.dao.DBconnection;

public class RegisterUserServlet extends GenericServlet {

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
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		String UserName = req.getParameter("userName");
		String UserEmail = req.getParameter("userEmail");
		String Password = req.getParameter("userPassword");
		
		PreparedStatement ps = con.prepareStatement("insert into user_details.user values(?,?,?,?)");
		ps.setInt(1, userId);
		ps.setString(2, UserName);
		ps.setString(3, UserEmail);
		ps.setString(4, Password);
		
		int k=ps.executeUpdate();
		
		if(k>0) {
			pw.println("User Register Succesfully");
		}else {
			pw.println("User not Register Succesfully");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
			
		}
	}

}
