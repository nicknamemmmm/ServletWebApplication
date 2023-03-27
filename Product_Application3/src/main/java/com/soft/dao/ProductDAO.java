package com.soft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soft.beans.Product;

public class ProductDAO {

	public List<Product> findProducts(){
		List<Product> productlist = new ArrayList<>();
		try {
			DBConnection dbcon=new DBConnection();
			Connection con = dbcon.createConnection();
			Statement stm =con.createStatement();
			ResultSet rs = stm.executeQuery("select * from product ");
			
			while(rs.next()) {
				
				Product newProduct = new Product();
				newProduct.setPid(rs.getInt(1));
				newProduct.setpName(rs.getString(2));
				newProduct.setpQty(rs.getInt(3));
				newProduct.setPrice(rs.getDouble(4));
				//Add New Product
				productlist.add(newProduct);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}
	public Product findBypidP(int pid){
		Product exitProduct = new Product();
		try {
			
			DBConnection dbcon=new DBConnection();
			Connection con = dbcon.createConnection();
			
			PreparedStatement ps= con.prepareStatement("select * from product where pid=?");
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				exitProduct.setPid(rs.getInt(1));
				exitProduct.setpName(rs.getString(2));
				exitProduct.setpQty(rs.getInt(3));
				exitProduct.setPrice(rs.getDouble(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
	}
		return exitProduct;
	}
}
