package com.location.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.location.interfaces.IConstants;

/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private java.sql.CallableStatement stmt;
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() throws SQLException, ClassNotFoundException {
        super();
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
		 Gson gson = new Gson();	
		 try {
				stmt = conn.prepareCall(IConstants.ADD_EVENT_PROCEDURE);
				stmt.setInt("iUser_Id", Integer.parseInt(request.getParameter(IConstants.USER_ID)));
				stmt.setString("iEvent_Name", request.getParameter(IConstants.EVENT_NAME));
				stmt.setInt("iCategory_Id", Integer.parseInt(request.getParameter(IConstants.CATEGORY_ID)));
				stmt.setString("iStreet", request.getParameter(IConstants.STREET));
				stmt.setString("iCity", request.getParameter(IConstants.CITY));
				stmt.setString("iState", request.getParameter(IConstants.STATE));
				stmt.setString("iZip_Code", request.getParameter(IConstants.ZIP_CODE));
				stmt.setDouble("iLatitude", Double.parseDouble(request.getParameter(IConstants.LATITUDE)));
				stmt.setDouble("iLongitude", Double.parseDouble(request.getParameter(IConstants.LONGITUDE)));
				stmt.setString("iStart_Date", request.getParameter(IConstants.START_DATE));
				stmt.setString("iEnd_Date", request.getParameter(IConstants.END_DATE));				
				stmt.execute(); 
				Boolean eventAdded = true;
				String json = gson.toJson(eventAdded);
				out.println(json);
			} catch (SQLException e) {
				Boolean eventAdded = false;
				String json = gson.toJson(eventAdded);
				out.println(json);				
				e.printStackTrace();
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
