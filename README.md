CSCI_5221_androidApp
====================
<b>Front End : </b><br/>
The client application consists of two parts. One part is used by the event organizer and the other part is used by regularusers. Event Organizer has the ability to add an event and list all events which he has posted so far using the application.Regular user has the ability to see events which are currently happening within a radius of specified distance. For example,a client might get notifications and offers pertaining to restaurants or events taking place near his/her current location .The service owners can also use the application (post secured logging) to post their services for the clients.

<b>Back End : </b><br/>
The back-end server consists of the database server and the Apache Tomcat server. Apache Tomcat implements the Java
Servlet and the JavaServer Pages (JSP) specifications from Sun Microsystems, and provides a ”pure Java” HTTP web server
environment for Java code to run in. MySql is used as the database server.
The backend database server maintains the track of the events posted by the owners. Tomcat serves the requests from the client application by sending the notifications about the requested category of service based on the location of the client. Posting the events to the back-end server is authentication based.
