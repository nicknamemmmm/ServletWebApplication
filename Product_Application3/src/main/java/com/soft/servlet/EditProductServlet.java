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

import com.soft.dao.DBConnection;
@WebServlet("/updateProduct")
public class EditProductServlet extends HttpServlet{

	private Connection con;
	public void init() {
		DBConnection dbcon= new DBConnection();
		con =dbcon.createConnection();
	}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		try {
			
			int ProductId = Integer.parseInt(req.getParameter("pid"));
			String ProductName = req.getParameter("pname");
			int ProductQuantity = Integer.parseInt(req.getParameter("pqnumber"));
			double Price = Double.parseDouble(req.getParameter("pprice"));
			
			PreparedStatement ps = con.prepareStatement("update product set pname=?,pqty=?,price=? where pid=?");
			
			ps.setString(1, ProductName);
			ps.setInt(2, ProductQuantity);
			ps.setDouble(3, Price);
			ps.setInt(4, ProductId);
			
			int k = ps.executeUpdate();
			
			if(k>0) {
				pw.println("updateded succesfull");
				RequestDispatcher rd= req.getRequestDispatcher("ProductDashbord.jsp");
				rd.include(req, resp);
			}else {
				pw.println("updateded succesfull");
				RequestDispatcher rd= req.getRequestDispatcher("editProduct.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}
}
