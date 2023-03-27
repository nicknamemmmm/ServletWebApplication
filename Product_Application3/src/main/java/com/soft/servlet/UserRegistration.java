package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.beans.User;
import com.soft.dao.DBConnection;

@WebServlet("/registerh")
public class UserRegistration extends HttpServlet{

	private Connection con;
	public void init() {
		DBConnection dbcon= new DBConnection();
		con =dbcon.createConnection();
	}
	
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		try {
			int userId = Integer.parseInt(req.getParameter("uid"));
			String userName = req.getParameter("uname");
			String userEmail = req.getParameter("uemail");
			String password = req.getParameter("upassword");
			long cantactNo =Long.parseLong(req.getParameter("ucantact"));
			String Address = req.getParameter("uaddress");		
			
			PreparedStatement ps = con.prepareStatement("insert into  user values(?,?,?,?,?,?)");
			
			User user =new User();
			user.setUserId(userId);
			user.setUserName(userName);
			user.setUserEmail(userEmail);
			user.setPassword(password);
			user.setContactNumber(cantactNo);
			user.setContactNumber(cantactNo);
			
			ps.setInt(1, userId);
			ps.setString(2, userName);
			ps.setString(3, userEmail);
			ps.setString(4, password);
			ps.setLong(5, cantactNo);
			ps.setString(6, Address);
			
			int k=ps.executeUpdate();
			
			if(k>0) {
				pw.println("register succefill");
				RequestDispatcher rd = req.getRequestDispatcher("userLogin.jsp");
				rd.forward(req, resp);
			}else {
				pw.println("register not succefill");
				RequestDispatcher rd = req.getRequestDispatcher("userRegister.jsp");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
