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

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet{

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
			long Price = Long.parseLong(req.getParameter("pprice"));
			
			PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?)");
			
			ps.setInt(1,ProductId);
			ps.setString(2, ProductName);
			ps.setInt(3, ProductQuantity);
			ps.setLong(4, Price);
			
			int k=ps.executeUpdate();
			
			if(k>0) {
				pw.println("product Addes succesfull");
				RequestDispatcher rd= req.getRequestDispatcher("ProductDashbord.jsp");
				rd.forward(req, resp);
			}else {
				pw.println("not successfull");
				RequestDispatcher rd= req.getRequestDispatcher("addProduct.jsp");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
