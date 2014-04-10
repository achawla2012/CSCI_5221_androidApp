package com.location.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.location.business.DistanceCalculator;
import com.location.business.Event;
import com.location.interfaces.IConstants;

/**
 * Servlet implementation class GetEventClientServlet
 */
@WebServlet("/GetEventClientServlet")
public class GetEventClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DistanceCalculator calculator = new DistanceCalculator();
	private Connection conn;
	private java.sql.CallableStatement stmt;
	private int latitude;
	private int longitude;
    /**
     * @throws ClassNotFoundException 
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public GetEventClientServlet() throws ClassNotFoundException, SQLException {
        super();
        Class.forName("com.mysql.jdbc.Driver");
    	conn = DriverManager.getConnection(IConstants.DB_URL,
				IConstants.DB_USER, IConstants.DB_PASSWORD);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter(); 
		 List<Event> list = new ArrayList<Event>();
		 double distance = Double.parseDouble(request.getParameter(IConstants.DISTANCE));
		 double latitude = Double.parseDouble(request.getParameter(IConstants.LATITUDE));
		 double longitude = Double.parseDouble(request.getParameter(IConstants.LONGITUDE));
		 try {
				stmt = conn.prepareCall(IConstants.GET_EVENT_PROCEDURE);
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				Event event;
				// Extract data from result set
				while (rs.next()) {
					event = new Event();
					event.setEventId(rs.getInt("Event_Id"));
					event.setEventName(rs.getString("Event_Name"));
					event.setCategoryId(rs.getInt("Category_Id"));
					event.setStreet(rs.getString("Street"));
					event.setCity(rs.getString("City"));
					event.setState(rs.getString("State"));
					event.setZipCode(rs.getString("Zip_Code"));
					event.setLatitude(rs.getDouble("Latitude"));
					event.setLongitude(rs.getDouble("Longitude"));
					event.setStart_Date(rs.getString("Start_Date"));
					event.setEndDate(rs.getString("End_Date"));
					if(calculator.checkWithingDistance(event, distance, latitude, longitude))
					{
						list.add(event);
					}
					
				}
				Gson gson = new Gson();				 
				String json = gson.toJson(list);
				json = "{events :"+json+"}";
				out.println(json);
   			    //out.println("</body>"); out.println("</html>");
				
		 }
		 catch (SQLException e)
		 {
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
