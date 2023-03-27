package com.soft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.soft.dao.DBConnection;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet{

	private Connection con;
	public void init() {
		DBConnection dbcon= new DBConnection();
		con =dbcon.createConnection();
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		try {
			String userEmail = req.getParameter("uemail");
			String password = req.getParameter("upassword");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM product_details.user where user_email=? AND password=?");
			ps.setString(1, userEmail);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pw.println("login succesfull");
				RequestDispatcher rd= req.getRequestDispatcher("ProductDashbord.jsp");
				rd.forward(req, resp);
			}else {
				
				RequestDispatcher rd= req.getRequestDispatcher("userRegister.jsp");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
