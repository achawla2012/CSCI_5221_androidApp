DROP PROCEDURE IF EXISTS GET_Event_Of_Organizer;
CREATE PROCEDURE GET_Event_Of_Organizer
(
	IN iUser_Id INT
)
BEGIN
		SELECT ED.Event_Id, Event_Name, Category_Id, Street, City, State, Zip_Code, Latitude, Longitude, Start_Date, End_Date 
		FROM event_details_table ED
		INNER JOIN event_organizer_table EO 
		ON EO.Event_Id = ED.Event_Id
		WHERE EO.Event_User_Id = iUser_Id;
END