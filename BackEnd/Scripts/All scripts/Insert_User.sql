DROP PROCEDURE IF EXISTS Insert_User;
CREATE PROCEDURE Insert_User
(IN iEmail VARCHAR(250),
 IN iPassword VARCHAR(250),
 IN iPhone VARCHAR(250))
BEGIN
		
			INSERT INTO login_table(Email, Password_Field, Contact_Number)
			VALUES(iEmail, iPassword, iPhone);

			SELECT MAX(event_user_id) AS user_id from login_table;

END