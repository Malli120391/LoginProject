package com.javacodes.loginpage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javacodes.loginpage.model.LoginModel;

public class LoginDAO {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/logindb";
	private String dbUser = "root";
	private String dbPwd = "root";
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	 public void loadDriver(String driverClassName) {
		 
		 try {
			Class.forName(driverClassName);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	 }
	
	 public Connection getConnection()  {
		 
		 Connection conn = null;
		 
		  try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	 }
	
	public boolean validate(LoginModel loginmodel) {
		loadDriver(driverClassName);
		Connection connection = getConnection();
		boolean status = false;
		
		String sql = "select * from login where username = ? and password=?";
		
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, loginmodel.getUsername());
			ps.setString(2, loginmodel.getPassword());
			
			 ResultSet rs = ps.executeQuery();
			 
			 status = rs.next();
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
		
	}

}
