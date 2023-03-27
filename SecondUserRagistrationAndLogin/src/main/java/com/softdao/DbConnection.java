package com.softdao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	Connection con = null;
	
	public Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 /best","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
