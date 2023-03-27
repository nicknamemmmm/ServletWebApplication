package com.softservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.soft.dao.DBConnection;
@WebServlet("/next")
public class UserLoginServlet extends GenericServlet {
	Connection con = null;
	public void init() {
		DBConnection dbcon = new DBConnection();
	
		con = dbcon.creatConnection();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		try {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
			String Email = req.getParameter("email");
			String Password = req.getParameter("password");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM uregister.prologin where email=? AND password=?");
			
			ps.setString(1, Email);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pw.println("Login succesfully");
				RequestDispatcher rd = req.getRequestDispatcher("addProduct.jsp");
				rd.include(req, res);
			}else {
				pw.println("Login not succesfull");
				RequestDispatcher rd = req.getRequestDispatcher("userRegister.jsp");
				rd.forward(req, res);
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
