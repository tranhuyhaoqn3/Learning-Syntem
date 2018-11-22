/*
SQLyog Professional v12.09 (64 bit)
MySQL - 10.1.35-MariaDB : Database - doanweb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`doanweb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `doanweb`;

/*Table structure for table `answer` */

DROP TABLE IF EXISTS `answer`;

CREATE TABLE `answer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QuestionID` int(11) DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `IsCorrect` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Table structure for table `childtest` */

DROP TABLE IF EXISTS `childtest`;

CREATE TABLE `childtest` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` int(11) DEFAULT NULL,
  `IDTest` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `childtest_question` */

DROP TABLE IF EXISTS `childtest_question`;

CREATE TABLE `childtest_question` (
  `IDChildTest` int(11) NOT NULL,
  `IdQuestion` int(11) NOT NULL,
  PRIMARY KEY (`IDChildTest`,`IdQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FullName` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Description` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `ShortName` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `StartDate` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `EndDate` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Table structure for table `class_test` */

DROP TABLE IF EXISTS `class_test`;

CREATE TABLE `class_test` (
  `IDClass` int(11) NOT NULL,
  `IDChildTest` int(11) NOT NULL,
  `ExamTime` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDClass`,`IDChildTest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `QuestionText` varchar(1000) DEFAULT NULL,
  `Score` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `question_subject` */

DROP TABLE IF EXISTS `question_subject`;

CREATE TABLE `question_subject` (
  `IDQuestion` int(11) NOT NULL,
  `IDSubject` int(11) NOT NULL,
  PRIMARY KEY (`IDQuestion`,`IDSubject`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `scoretype` */

DROP TABLE IF EXISTS `scoretype`;

CREATE TABLE `scoretype` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(250) DEFAULT NULL,
  `Range` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Time` varchar(255) DEFAULT NULL,
  `NumberQuestion` int(11) DEFAULT NULL,
  `TimeStart` datetime DEFAULT NULL,
  `TimeEnd` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `DOB` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `UserName` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `PassWord` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `TypeAccount` int(11) DEFAULT '0',
  `Deleted` bit(1) DEFAULT b'0',
  `Address` varchar(255) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Image` varchar(1000) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*Table structure for table `user_class` */

DROP TABLE IF EXISTS `user_class`;

CREATE TABLE `user_class` (
  `IDUser` int(11) NOT NULL,
  `IDClass` int(11) NOT NULL,
  PRIMARY KEY (`IDUser`,`IDClass`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `user_question` */

DROP TABLE IF EXISTS `user_question`;

CREATE TABLE `user_question` (
  `IDUser` int(11) NOT NULL,
  `IDQuestion` int(11) NOT NULL,
  `IDLanLam` int(11) NOT NULL,
  `IDAnswer` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDUser`,`IDQuestion`,`IDLanLam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `user_test` */

DROP TABLE IF EXISTS `user_test`;

CREATE TABLE `user_test` (
  `IDUser` int(11) NOT NULL,
  `IDChildTest` int(11) NOT NULL,
  `Score` int(11) DEFAULT NULL,
  `IDLanLam` int(11) NOT NULL,
  PRIMARY KEY (`IDUser`,`IDChildTest`,`IDLanLam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
