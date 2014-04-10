/*
Navicat MySQL Data Transfer

Source Server         : Networking_Project
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : location_services

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2014-04-06 17:32:41
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
