package com.practice.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestdbConnection
 */
@WebServlet("/TestdbConnection")
public class TestdbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variables
		String user = "demouser";
		String pass = "demouser";
		String jdbcUrl = "jdbc:mysql://@192.168.1.21:3306/otsiqa?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to the database..... "+jdbcUrl);
			Class.forName(driver);
			Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println(" Success!!!!");
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
