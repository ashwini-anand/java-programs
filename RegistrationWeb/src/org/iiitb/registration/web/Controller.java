package org.iiitb.registration.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiitb.registration.dao.BaseDao;

//@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {

		try {
			BaseDao dao = new BaseDao();
			
			conn = dao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UnavailableException(
					"Db connectivity failed. Try after 1 minute.", 60);
		}
	
	}

	public void destroy() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  if(request.getRequestURI().contains("saveDetails")){
		String roll = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String course = request.getParameter("course");
		System.out.println(request.getRealPath((request.getParameter("txtPhoto"))));
		String sql = "insert into students values (?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, roll);
			stmt.setString(2, name);
			stmt.setString(3, college);
			stmt.setString(4, course);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("return.jsp").forward(request, response);
		}	
	  
	  if(request.getRequestURI().contains("getDetails")){
			String roll = request.getParameter("rollNo");
			String sql = "select * from students where roll_no = ?";
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, roll);
				ResultSet rs = stmt.executeQuery();
				String roll_no =null ;
				String college=null;
				String course=null;
				String name=null;
				while (rs.next()) {
					 roll_no = rs.getString("roll_no");
					 college = rs.getString("college");
					 course = rs.getString("course");
					 name = rs.getString("name");
				}
				request.setAttribute("roll_no", roll_no);
				request.setAttribute("college", college);
				request.setAttribute("course", course);
				request.setAttribute("name", name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("details.jsp").forward(request, response);
			}	
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
