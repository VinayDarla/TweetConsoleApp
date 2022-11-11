package com.start.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {

	static Connection con;
	public static Connection createConnection() {
		try {
			//to load the drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//creating connection with mysql creds
			String user ="root";
			String password = "pass@word1";
			String url = "jdbc:mysql://localhost:3306/tweet_db";
			
			con = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
