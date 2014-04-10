/*
Navicat MySQL Data Transfer

Source Server         : Networking_Project
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : location_services

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2014-04-06 17:29:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for event_details_table
-- ----------------------------
DROP TABLE IF EXISTS `event_details_table`;
CREATE TABLE `event_details_table` (
  `Event_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Event_Name` varchar(100) NOT NULL,
  `Category_Id` int(11) DEFAULT NULL,
  `Street` varchar(100) DEFAULT NULL,
  `City` varchar(20) DEFAULT NULL,
  `State` varchar(20) DEFAULT NULL,
  `Zip_Code` varchar(20) DEFAULT NULL,
  `Latitude` decimal(11,2) DEFAULT NULL,
  `Longitude` decimal(11,2) DEFAULT NULL,
  `Event_Details` varchar(1000) DEFAULT NULL,
  `Start_Date` varchar(100) DEFAULT NULL,
  `End_Date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Event_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of event_details_table
-- ----------------------------
INSERT INTO `event_details_table` VALUES ('1', 'April Fool', '2', '814 11th avenue se', 'Minneapolis', 'Minnesota', '55414', '45.00', '-93.00', null, '1/1/2000', '5-3-2014');
INSERT INTO `event_details_table` VALUES ('2', 'chipotle event', '2', '814 11th avenue se', 'Minneapolis', 'Minnesota', '55414', '45.00', '-93.00', null, '1/1/2000', '5-3-2014');
INSERT INTO `event_details_table` VALUES ('3', 'P Domino\'s Event', '2', '2nd Street', 'Minneapolis', 'MN', '55414', '70.00', '21.00', null, '3-3-2014', '5-3-2014');
INSERT INTO `event_details_table` VALUES ('4', 'P Domino\'s Event', '2', '2nd Street', 'Minneapolis', 'MN', '55414', '44.99', '-93.24', null, '3-3-2014', '5-3-2014');
INSERT INTO `event_details_table` VALUES ('5', 'rocket event', '2', '814 11th avenue se', 'Minneapolis', 'Minnesota', '55414', '44.99', '-93.24', null, '1/1/2000', '5-3-2014');
INSERT INTO `event_details_table` VALUES ('6', 'today energy', '2', '810 11th avenue se ', 'Minneapolis', 'Minnesota', '55414', '44.99', '-93.24', null, '1/1/2000', '5-3-2014');
INSERT INTO `event_details_table` VALUES ('7', 'welcome', '2', '708 university avenue  se', 'Minneapolis', 'Minnesota', '55414', '44.98', '-93.25', null, '1/1/2000', '5-3-2014');
INSERT INTO `event_details_table` VALUES ('8', 'qeft', '2', '708 university ave se', 'mineapolis', 'minnesota', '55414', '44.98', '-93.25', null, '1/1/2000', '1/1/2001');
INSERT INTO `event_details_table` VALUES ('9', 'new every', '2', '708 university avenue  se', 'Minneapolis', 'Minnesota', '55414', '44.98', '-93.25', null, '1/1/2000', '1/1/2000');

-- ----------------------------
-- Table structure for event_organizer_table
-- ----------------------------
DROP TABLE IF EXISTS `event_organizer_table`;
CREATE TABLE `event_organizer_table` (
  `Event_Id` int(11) NOT NULL,
  `Event_User_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of event_organizer_table
-- ----------------------------
INSERT INTO `event_organizer_table` VALUES ('3', '14');
INSERT INTO `event_organizer_table` VALUES ('4', '14');
INSERT INTO `event_organizer_table` VALUES ('5', '14');
INSERT INTO `event_organizer_table` VALUES ('6', '11');
INSERT INTO `event_organizer_table` VALUES ('7', '11');
INSERT INTO `event_organizer_table` VALUES ('8', '29');
INSERT INTO `event_organizer_table` VALUES ('9', '29');
INSERT INTO `event_organizer_table` VALUES ('10', '29');
INSERT INTO `event_organizer_table` VALUES ('11', '14');
INSERT INTO `event_organizer_table` VALUES ('12', '15');
INSERT INTO `event_organizer_table` VALUES ('13', '15');
INSERT INTO `event_organizer_table` VALUES ('14', '15');
INSERT INTO `event_organizer_table` VALUES ('15', '71');
INSERT INTO `event_organizer_table` VALUES ('16', '14');
INSERT INTO `event_organizer_table` VALUES ('17', '14');
INSERT INTO `event_organizer_table` VALUES ('18', '73');
INSERT INTO `event_organizer_table` VALUES ('19', '74');
INSERT INTO `event_organizer_table` VALUES ('20', '81');
INSERT INTO `event_organizer_table` VALUES ('21', '73');
INSERT INTO `event_organizer_table` VALUES ('22', '73');
INSERT INTO `event_organizer_table` VALUES ('23', '73');
INSERT INTO `event_organizer_table` VALUES ('24', '73');
INSERT INTO `event_organizer_table` VALUES ('25', '14');
INSERT INTO `event_organizer_table` VALUES ('26', '14');
INSERT INTO `event_organizer_table` VALUES ('27', '14');
INSERT INTO `event_organizer_table` VALUES ('28', '14');
INSERT INTO `event_organizer_table` VALUES ('29', '14');
INSERT INTO `event_organizer_table` VALUES ('30', '14');
INSERT INTO `event_organizer_table` VALUES ('31', '14');
INSERT INTO `event_organizer_table` VALUES ('32', '14');
INSERT INTO `event_organizer_table` VALUES ('33', '14');
INSERT INTO `event_organizer_table` VALUES ('34', '14');
INSERT INTO `event_organizer_table` VALUES ('35', '14');
INSERT INTO `event_organizer_table` VALUES ('36', '14');
INSERT INTO `event_organizer_table` VALUES ('37', '14');
INSERT INTO `event_organizer_table` VALUES ('38', '14');
INSERT INTO `event_organizer_table` VALUES ('39', '14');
INSERT INTO `event_organizer_table` VALUES ('40', '14');
INSERT INTO `event_organizer_table` VALUES ('41', '14');
INSERT INTO `event_organizer_table` VALUES ('42', '14');
INSERT INTO `event_organizer_table` VALUES ('43', '14');
INSERT INTO `event_organizer_table` VALUES ('44', '14');
INSERT INTO `event_organizer_table` VALUES ('45', '14');
INSERT INTO `event_organizer_table` VALUES ('46', '14');
INSERT INTO `event_organizer_table` VALUES ('47', '14');
INSERT INTO `event_organizer_table` VALUES ('48', '14');
INSERT INTO `event_organizer_table` VALUES ('49', '14');
INSERT INTO `event_organizer_table` VALUES ('50', '14');
INSERT INTO `event_organizer_table` VALUES ('51', '14');
INSERT INTO `event_organizer_table` VALUES ('52', '14');
INSERT INTO `event_organizer_table` VALUES ('53', '14');
INSERT INTO `event_organizer_table` VALUES ('54', '14');
INSERT INTO `event_organizer_table` VALUES ('55', '14');
INSERT INTO `event_organizer_table` VALUES ('56', '14');
INSERT INTO `event_organizer_table` VALUES ('57', '14');
INSERT INTO `event_organizer_table` VALUES ('58', '14');
INSERT INTO `event_organizer_table` VALUES ('59', '14');
INSERT INTO `event_organizer_table` VALUES ('1', '14');
INSERT INTO `event_organizer_table` VALUES ('2', '14');
INSERT INTO `event_organizer_table` VALUES ('3', '14');
INSERT INTO `event_organizer_table` VALUES ('4', '14');
INSERT INTO `event_organizer_table` VALUES ('5', '14');
INSERT INTO `event_organizer_table` VALUES ('6', '14');
INSERT INTO `event_organizer_table` VALUES ('7', '14');
INSERT INTO `event_organizer_table` VALUES ('8', '85');
INSERT INTO `event_organizer_table` VALUES ('9', '85');

-- ----------------------------
-- Table structure for login_table
-- ----------------------------
DROP TABLE IF EXISTS `login_table`;
CREATE TABLE `login_table` (
  `Email` varchar(255) NOT NULL,
  `Contact_Number` varchar(255) DEFAULT NULL,
  `Password_Field` varchar(255) NOT NULL,
  `Event_User_Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Event_User_Id`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login_table
-- ----------------------------
INSERT INTO `login_table` VALUES ('fhfgg@gmail.com', '16843843', '123456', '10');
INSERT INTO `login_table` VALUES ('abcd@gmail.com', '612-123-3919', 'test', '13');
INSERT INTO `login_table` VALUES ('rohitmdeshpande@gmail.com', '612-123-3919', 'a', '14');
INSERT INTO `login_table` VALUES ('amardeep@gmail.com', '612-123-1111', 'test123', '15');
INSERT INTO `login_table` VALUES ('rohan@gmail.com', '612-123-3296', 'project', '16');
INSERT INTO `login_table` VALUES ('xhxhdb', '2684685', '123', '18');
INSERT INTO `login_table` VALUES ('xhxhkdb@gmail.com', '2684685', '123', '19');
INSERT INTO `login_table` VALUES ('amRdb@gmail.com', '2684685', '123', '21');
INSERT INTO `login_table` VALUES ('ansr@gmail.com', '238460580', '123', '22');
INSERT INTO `login_table` VALUES ('amat@gmail.com', '489588', '123', '23');
INSERT INTO `login_table` VALUES ('anawq@gmail.com', '4589426', '123', '24');
INSERT INTO `login_table` VALUES ('absf@gmail.com', '1555', '126', '26');
INSERT INTO `login_table` VALUES ('kakapasalkar@gmail.com', '612-123-3296', 'project', '27');
INSERT INTO `login_table` VALUES ('kaka@gmail.com', '612-123-3296', 'project', '29');
INSERT INTO `login_table` VALUES ('asdgfhvh@hmail.com', '23856568685', '123', '30');
INSERT INTO `login_table` VALUES ('qwedd@gmail.com', '45555558479', '123', '31');
INSERT INTO `login_table` VALUES ('Pranjulyadav@gmail.com@gmail.com', null, 'test', '32');
INSERT INTO `login_table` VALUES ('Pranjulyadav@gmail.com', null, 'test', '35');
INSERT INTO `login_table` VALUES ('pickup123@gmail.com', '1234567890', '123', '39');
INSERT INTO `login_table` VALUES ('ffcg@gmail@com', '5255456886', 'abcd', '40');
INSERT INTO `login_table` VALUES ('pik123@gmail.com', '1234567890', '123', '41');
INSERT INTO `login_table` VALUES ('Sumit@gmail.com', '612-123-3919', 'test', '44');
INSERT INTO `login_table` VALUES ('ohgj@gmail.com', '126859', '123', '46');
INSERT INTO `login_table` VALUES ('que@gmail.com', '123456', '123', '49');
INSERT INTO `login_table` VALUES ('wertf@gmail.com', '123456', '123', '50');
INSERT INTO `login_table` VALUES ('get@gmail.com', '123456789', '123', '51');
INSERT INTO `login_table` VALUES ('shiftz@gmail.com', '5455535', 'test', '53');
INSERT INTO `login_table` VALUES ('SumitRaj@gmail.com', '612-123-3919', 'test', '54');
INSERT INTO `login_table` VALUES ('zact@gmail.com', '552864896', 'abcd', '55');
INSERT INTO `login_table` VALUES ('zactdchhyvhh@gmail.com', '552864896', 'abcd', '56');
INSERT INTO `login_table` VALUES ('ghfbhj@gmail.com', '55888', 'test', '58');
INSERT INTO `login_table` VALUES ('ghhgf@gmail.com', '58854268855', 'abc', '59');
INSERT INTO `login_table` VALUES ('cgtdvbh@gmail.com', '588545', '123', '60');
INSERT INTO `login_table` VALUES ('dfghhb@gmail.com', '58855', '123', '61');
INSERT INTO `login_table` VALUES ('avd@gmail.com', '569855', '123', '62');
INSERT INTO `login_table` VALUES ('Bbz@gm.com', '555', 'qwe', '63');
INSERT INTO `login_table` VALUES ('xx@ff', '55', 'ww', '64');
INSERT INTO `login_table` VALUES ('ggfgh@gmail.com', '123', '123', '65');
INSERT INTO `login_table` VALUES ('feeku@gmail.com', '123456789', '123', '66');
INSERT INTO `login_table` VALUES ('dfdfd@gmail.com', '123456', '123', '71');
INSERT INTO `login_table` VALUES ('achawla@gmail.com', '123456789', '123', '73');
INSERT INTO `login_table` VALUES ('asc@gmail.com', '123456789', '123', '74');
INSERT INTO `login_table` VALUES ('picku@gmail.com', '123456', '123', '75');
INSERT INTO `login_table` VALUES ('yup@gmail.com', '123456789', '123', '76');
INSERT INTO `login_table` VALUES ('eygjvhcj@gjgb', '56858', '123', '77');
INSERT INTO `login_table` VALUES ('eete@gmail.com', '133456789', '123', '78');
INSERT INTO `login_table` VALUES ('jhgfyt@gcom', '123889', '123', '79');
INSERT INTO `login_table` VALUES ('wtfvjfh@gmail.com', '1236545', '123', '80');
INSERT INTO `login_table` VALUES ('qwer@gmail.com', '123456789', '123', '81');
INSERT INTO `login_table` VALUES ('qefqer@gmail.com', '1234567', '123', '83');
INSERT INTO `login_table` VALUES ('aas@gmail.com', '123', '123', '85');

-- ----------------------------
-- Procedure structure for GET_Event_Of_Organizer
-- ----------------------------
DROP PROCEDURE IF EXISTS `GET_Event_Of_Organizer`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_Event_Of_Organizer`(
	IN iUser_Id INT
)
BEGIN
		SELECT ED.Event_Id, Event_Name, Category_Id, Street, City, State, Zip_Code, Latitude, Longitude, Start_Date, End_Date 
		FROM event_details_table ED
		INNER JOIN event_organizer_table EO 
		ON EO.Event_Id = ED.Event_Id
		WHERE EO.Event_User_Id = iUser_Id;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Insert_Event
-- ----------------------------
DROP PROCEDURE IF EXISTS `Insert_Event`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Insert_Event`(
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
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Insert_User
-- ----------------------------
DROP PROCEDURE IF EXISTS `Insert_User`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Insert_User`(IN iEmail VARCHAR(250),
 IN iPassword VARCHAR(250),
 IN iPhone VARCHAR(250))
BEGIN
		
			INSERT INTO login_table(Email, Password_Field, Contact_Number)
			VALUES(iEmail, iPassword, iPhone);

			SELECT MAX(event_user_id) AS user_id from login_table;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Inser_User
-- ----------------------------
DROP PROCEDURE IF EXISTS `Inser_User`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Inser_User`(IN iEmail VARCHAR(250),
 IN iPassword VARCHAR(250),
 IN iPhone VARCHAR(250))
BEGIN
	
			INSERT INTO login_table(Email, Password_Field, Phone)
			VALUES(iEmail, iPassword, iPhone);
	
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Perform_Login
-- ----------------------------
DROP PROCEDURE IF EXISTS `Perform_Login`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Perform_Login`(IN iEmail VARCHAR(255),
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
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for Select_Event
-- ----------------------------
DROP PROCEDURE IF EXISTS `Select_Event`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Select_Event`(
)
BEGIN
		SELECT Event_Id, Event_Name, Category_Id, Street, City, State, Zip_Code, Latitude, Longitude, Start_Date, End_Date
	  FROM event_details_table;
END
;;
DELIMITER ;
