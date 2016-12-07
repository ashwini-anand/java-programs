package org.iiitb.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	public Connection getConnection() throws DaoException {
		try {
			String url = "jdbc:mysql://localhost/iiitb";
			String user = "root";
			String password ="root";
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	protected void close(Connection conn, Statement stmt, ResultSet rs)
			throws DaoException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}
}

