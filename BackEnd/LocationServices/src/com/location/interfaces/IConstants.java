package com.location.interfaces;

public interface IConstants
{
	 public static final String DB_USER = "root";
     public static final String DB_PASSWORD = "test";
     public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
     public static final String DB_URL="jdbc:mysql://localhost/location_services";
     public static final String SIGNUPSERVLETPATH = "/SignUpServlet";
     public static final String ADDEVENTSERVLETPATH = "/AddEventServlet";
     public static final String GETEVENTSERVLETPATH = "/GetEventClientServlet";
     public static final String LOGINSERVLETPATH = "/LoginServlet";
     public static final String GETEVENTORGANIZERSERVLETPATH = "/GetEventOrganizerServlet";
     public static final String QUESTION_MARK = "?";
     public static final String EQUAL_MARK = "=";
     public static final String EMAIL = "Email";
     public static final String PASSWORD = "Password";
     public static final String CONTACT_NUMBER = "Contact_Number";
     public static final String REQUEST = "request";
     public static final String SIGN_UP = "Signup";
     public static final String USER_ID = "User_Id";
     public static final String SIGN_UP_PROCEDURE  = "{CALL Insert_User(?,?,?)}";
     public static final String ADD_EVENT_PROCEDURE  = "{CALL Insert_Event(?,?,?,?,?,?,?,?,?,?,?)}";
     public static final String GET_EVENT_PROCEDURE = "{CALL Select_Event}";
     public static final String LOGIN_PROCEDURE  = "{CALL Perform_Login(?,?)}";
     public static final String GET_EVENT_ORGANIZER_PROCEDURE = "{CALL GET_Event_Of_Organizer(?)}";
     public static final String GET_EVENT = "GetEvent";
     public static final String GET_ORGANIZER_EVENT = "GetOrganizerEvent";
     public static final String ADD_EVENT = "AddEvent";
     public static final String EVENT_NAME = "Event_Name";
     public static final String LOGIN = "Login";
     public static final String CATEGORY_ID = "Category_Id";
     public static final String STREET = "Street";
     public static final String CITY =  "City";
     public static final String STATE = "State";
     public static final String ZIP_CODE = "Zip_Code";
     public static final String LATITUDE = "Latitude";
     public static final String LONGITUDE = "Longitude";
     public static final String DISTANCE = "Distance";
     public static final String START_DATE= "Start_Date";
     public static final String END_DATE = "End_Date";

}
