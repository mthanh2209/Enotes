package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Db.DBCon;
import com.User.UserDetails;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;

public class UserDAO {
	private static Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	public UserDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addUser(UserDetails us) {
		conn=DBCon.getConn();
		
		boolean f=false;
		try {
			String query="insert into user(name,email,password)"+ "values(?,?,?)";
			 // create statement to insert UserDetails
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			// get data from table 'user'
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public UserDetails loginUser(UserDetails us) {
		UserDetails user = null;
		try {
			String query = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());
			ResultSet rs = ps.executeQuery();
			
			// show data
			if(rs.next()) {
				user = new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword("password");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
