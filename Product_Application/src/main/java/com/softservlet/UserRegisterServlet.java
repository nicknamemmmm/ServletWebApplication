package com.softservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.dao.DBConnection;
@WebServlet("/test")
public class UserRegisterServlet extends GenericServlet {

	Connection con = null;
	
	public void init() {
		DBConnection db=new DBConnection();
		
		con = db.creatConnection();
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	 
	
		try {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
			String Name = req.getParameter("fname");
			String Email = req.getParameter("email");
			String pass = req.getParameter("password");
			int contactno = Integer.parseInt(req.getParameter("fnumber"));
			String Address = req.getParameter("address");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO  uregister.prologin values(?,?,?,?,?)");
			
			ps.setString(1, Name);
			ps.setString(2, Email);
			ps.setString(3, pass);
			ps.setInt(4, contactno);
			ps.setString(5, Address);
			
			int k =ps.executeUpdate();
			
			if(k>0) {
				pw.println("User Register Succesfull");
				RequestDispatcher rd = req.getRequestDispatcher("userLogin.jsp");
				rd.include(req, res);
			}else {
				pw.println("User Register not succesfull");
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
