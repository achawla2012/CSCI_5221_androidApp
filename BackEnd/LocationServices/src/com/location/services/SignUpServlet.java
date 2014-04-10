package com.location.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.location.business.Login;
import com.location.interfaces.IConstants;
import com.mysql.jdbc.CallableStatement;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private java.sql.CallableStatement stmt;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() throws SQLException, ClassNotFoundException {
    	super();
    	// Register JDBC driver
    	Class.forName("com.mysql.jdbc.Driver");
    	conn = DriverManager.getConnection(IConstants.DB_URL,
				IConstants.DB_USER, IConstants.DB_PASSWORD);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter out = response.getWriter(); 
		 //out.println("<html>");
		 //out.println("<body>"); out.println("<h1>Inside sign up servlet</h1>");
		 //out.println(request.getParameter(IConstants.EMAIL));
		 //out.println("</body>"); out.println("</html>");
		 Login loginObj = new Login();
		 Boolean login = new Boolean(true);
		 Gson gson = new Gson();				
		 try {
			stmt = conn.prepareCall(IConstants.SIGN_UP_PROCEDURE);
			stmt.setString("iEmail", request.getParameter(IConstants.EMAIL));
			stmt.setString("iPassword", request.getParameter(IConstants.PASSWORD));
			stmt.setString("iPhone", request.getParameter(IConstants.CONTACT_NUMBER));
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			if(rs.next())
			{
				loginObj.setEventUserId(rs.getInt("user_id"));
				loginObj.setCheckLogin(true);
			}
			
			
			String json = gson.toJson(loginObj);
			out.println(json);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			login = false;
			String json = gson.toJson(loginObj);
			out.println(json);
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
