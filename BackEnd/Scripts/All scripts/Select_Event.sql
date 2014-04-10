DROP PROCEDURE IF EXISTS Select_Event;
CREATE PROCEDURE Select_Event
(
)
BEGIN
		SELECT Event_Id, Event_Name, Category_Id, Street, City, State, Zip_Code, Latitude, Longitude, Start_Date, End_Date
	  FROM event_details_table;
END