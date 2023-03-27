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

public class SecondLogin extends GenericServlet{
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
			
			String Name = req.getParameter("name");
			String Surname = req.getParameter("surname");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM best.new_user where name=? AND surname=?");
			ps.setString(2, Name);
			ps.setString(3, Surname);
			int k = ps.executeUpdate();
			
			if(k>0) {
				pw.println("Login succesfull");
			}else {
				pw.println("Not Login Succesfull");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
