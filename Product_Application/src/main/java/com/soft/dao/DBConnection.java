package com.soft.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	Connection con = null;
	
	public Connection creatConnection () {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 /uregister","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
