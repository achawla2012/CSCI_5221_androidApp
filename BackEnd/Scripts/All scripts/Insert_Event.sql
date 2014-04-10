DROP PROCEDURE IF EXISTS Insert_Event;
CREATE PROCEDURE Insert_Event
(
 IN iUser_Id INT,
 IN iEvent_Name VARCHAR(100),
 IN iCategory_Id INT,
 IN iStreet VARCHAR(100),
 IN iCity VARCHAR(50),
 IN iState VARCHAR(50),
 IN iZip_Code VARCHAR(20),
 IN iLatitude NUMERIC(11,2),
 IN iLongitude NUMERIC(11,2),
 IN iStart_Date VARCHAR(50),
 IN iEnd_Date VARCHAR(50)
)
BEGIN
			DECLARE Max_Event_Id int(11);
			
			INSERT INTO event_details_table( Event_Name, Category_Id, Street, City, State, Zip_Code, Latitude, Longitude, Start_Date, End_Date)
			VALUES( iEvent_Name, iCategory_Id, iStreet, iCity, iState, iZip_Code, iLatitude, iLongitude, iStart_Date, iEnd_Date);

			SELECT MAX(Event_Id) INTO Max_Event_Id
			FROM event_details_table;

			INSERT INTO event_organizer_table(Event_Id, Event_User_Id)
			VALUES(Max_Event_Id, iUser_Id);
			

END