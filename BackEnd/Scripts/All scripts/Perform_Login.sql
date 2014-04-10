DROP PROCEDURE IF EXISTS Perform_Login;
CREATE PROCEDURE Perform_Login
(IN iEmail VARCHAR(255),
 IN iPassword VARCHAR(255)
 )
BEGIN
			DECLARE User_Id int(11);
			
			SELECT Event_User_Id INTO User_Id
			FROM login_table 
			WHERE Password_Field = iPassword AND
						Email = iEmail;

			
			IF User_Id IS NOT NULL
			THEN SELECT 'true' AS checkLogin,User_Id AS User_Id;
			ELSE SELECT 'false' AS checkLogin,-1 AS User_Id;
			END IF;


END