package org.iiitb.student.dl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/iiitb";
	final static String USER = "root";
	final static String PASS = "";
	static Connection con;
	public static Connection getConnection()
	{
		if(con==null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	static void closeConnection()
	{
		try {
			if(con!=null)
				con.close();
			System.out.println("Connection Closed Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
