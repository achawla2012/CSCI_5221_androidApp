/*
Navicat MySQL Data Transfer

Source Server         : Networking_Project
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : location_services

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2014-04-06 17:33:00
*/

SET FOREIGN_KEY_CHECKS=0;

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
