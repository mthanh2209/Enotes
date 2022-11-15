package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	private static Connection conn;
	public static Connection getConn()
	{
		try {
			if(conn==null) {
				// connect to database
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","220902");
				System.out.println("connection");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static Connection getCon() {
		// TODO Auto-generated method stub
		return null;
	}
}