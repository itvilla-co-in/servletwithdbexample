package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDemoDbConnection 
{
	
	public static Connection getConnection()
	{

		java.sql.Connection conn=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("lets see if afer class forname something is coming");
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/project1";
			//define the connection with id,password and link of DB
			conn=DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("I am before the printing of error");
			System.out.println(e);
			System.out.println("I am after the printing of error");
		}
		
		
		return conn;
		
	}

}
