package com.location.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.location.business.Login;
import com.location.interfaces.IConstants;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private java.sql.CallableStatement stmt;

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() throws ClassNotFoundException, SQLException {
		super();
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(IConstants.DB_URL,
				IConstants.DB_USER, IConstants.DB_PASSWORD);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        Login loginObj = new Login();
  	    Gson gson = new Gson();				

		try {
			stmt = conn.prepareCall(IConstants.LOGIN_PROCEDURE);
			stmt.setString("iEmail", request.getParameter(IConstants.EMAIL));
			stmt.setString("iPassword", request.getParameter(IConstants.PASSWORD));
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if(rs.next())
			{
				loginObj.setEventUserId(rs.getInt("User_Id"));
				loginObj.setCheckLogin(Boolean.parseBoolean(rs.getString("checkLogin")));
			}
			String json = gson.toJson(loginObj);
			out.println(json);
		}
		catch (SQLException e) {
			String json = gson.toJson(loginObj);
			out.println(json);
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
