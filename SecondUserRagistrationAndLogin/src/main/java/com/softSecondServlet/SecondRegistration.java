package com.softSecondServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.softdao.DbConnection;

public class SecondRegistration extends GenericServlet{

	Connection con = null;
	
	public void init() {
		DbConnection dbconn = new DbConnection();
		
		con = dbconn.createConnection();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
	
		int Id = Integer.parseInt(req.getParameter("id"));
		String Name = req.getParameter("name");
		String Surname = req.getParameter("surname");
		String Place = req.getParameter("place");
		
		PreparedStatement ps = con.prepareStatement("insert into best.new_user values (?,?,?,?)");
		
		ps.setInt(1, Id);
		ps.setString(2, Name);
		ps.setString(3, Surname);
		ps.setString(4, Place);
		
		int k=ps.executeUpdate();
		
		if(k>0) {
			pw.println("user registration succesfully");
		}else {
			pw.println("user not register succesfull");
		}
			
		} catch (Exception e) {
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
