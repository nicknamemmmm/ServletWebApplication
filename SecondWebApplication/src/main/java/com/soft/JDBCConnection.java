package com.soft;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

public class JDBCConnection extends GenericServlet{

	Connection con = null;
	
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / testwebapp","root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		try {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
			String FirstName = req.getParameter("fname");
			String LastName = req.getParameter("lname");
			String address = req.getParameter("address");
			String Email = req.getParameter("email");
			
		    PreparedStatement ps = con.prepareStatement("insert into testwebapp.userdata values(?,?,?,?)");
			
		    ps.setString(1, FirstName);
		    ps.setString(2, LastName);
		    ps.setString(3, address);
		    ps.setString(4, Email);
		    
		    int k = ps.executeUpdate();
		    
		    if(k>0) {
		    	pw.println("Data inserted succesfuly in Database");
		    }else {
		    	pw.println("data could not inseted succesfully");
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void destroy() {
	   	 try {
	   		 con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	          }
}
