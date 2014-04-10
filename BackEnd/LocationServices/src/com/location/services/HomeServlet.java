package com.location.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.location.interfaces.IConstants;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Statement stmt;
	private Connection conn;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String requestType = request.getParameter(IConstants.REQUEST);
		if (requestType.equals(IConstants.SIGN_UP)) {
			RequestDispatcher rd = request.getRequestDispatcher(IConstants.SIGNUPSERVLETPATH);
			rd.forward(request, response);
		}
		else if(requestType.equals(IConstants.ADD_EVENT))
		{
			RequestDispatcher rd = request.getRequestDispatcher(IConstants.ADDEVENTSERVLETPATH);
			rd.forward(request, response);
		}
		else if(requestType.equals(IConstants.GET_EVENT))
		{
			RequestDispatcher rd = request.getRequestDispatcher(IConstants.GETEVENTSERVLETPATH);
			rd.forward(request, response);
		}
		else if(requestType.equals(IConstants.LOGIN))
		{
			RequestDispatcher rd = request.getRequestDispatcher(IConstants.LOGINSERVLETPATH);
			rd.forward(request, response);
		}
		else if(requestType.equals(IConstants.GET_ORGANIZER_EVENT))
		{
			RequestDispatcher rd = request.getRequestDispatcher(IConstants.GETEVENTORGANIZERSERVLETPATH);
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

}
