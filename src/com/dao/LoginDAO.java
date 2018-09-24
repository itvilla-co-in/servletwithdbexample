package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.to.User;


import dbutil.MySQLDemoDbConnection;

public class LoginDAO {

	public boolean isValidUser(User u)
	{
		boolean b=false;
		Connection conn=MySQLDemoDbConnection.getConnection();
		System.out.println("testing after connection");
		String sql="select UNAME from project1.loginusers where UNAME=? and UPASS=?";
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2, u.getPassword());
			ResultSet rs=pstmt.executeQuery();
			System.out.println("testing after query");
			
			if(rs.next())
			{
				b=true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		
		
		return b;
	}
	
}
