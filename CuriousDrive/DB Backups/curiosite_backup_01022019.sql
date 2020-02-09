-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: curiosite
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_code`
--

DROP TABLE IF EXISTS `sys_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_code` (
  `CODE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_DESCRIPTION` varchar(50) NOT NULL,
  `DATA1_CAPTION` varchar(50) DEFAULT NULL,
  `DATA1_TYPE` varchar(50) DEFAULT NULL,
  `DATA2_CAPTION` varchar(50) DEFAULT NULL,
  `DATA2_TYPE` varchar(50) DEFAULT NULL,
  `DATA3_CAPTION` varchar(50) DEFAULT NULL,
  `DATA3_TYPE` varchar(50) DEFAULT NULL,
  `COMMENTS` varchar(50) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_code`
--

LOCK TABLES `sys_code` WRITE;
/*!40000 ALTER TABLE `sys_code` DISABLE KEYS */;
INSERT INTO `sys_code` VALUES (1,'Network Type',NULL,NULL,NULL,NULL,NULL,NULL,'This code id holds data for different types of net',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(2,'Gender',NULL,NULL,NULL,NULL,NULL,NULL,'Gender Values',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(3,'Constants',NULL,NULL,NULL,NULL,NULL,NULL,'Costant Values',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(4,'Region',NULL,NULL,NULL,NULL,NULL,NULL,'System Region',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(5,'Message Type',NULL,NULL,NULL,NULL,NULL,NULL,'Message Types',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(6,'Category Status',NULL,NULL,NULL,NULL,NULL,NULL,'Category Statuses',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(7,'Thread Status',NULL,NULL,NULL,NULL,NULL,NULL,'Thread Statuses',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(8,'Post Comment Types',NULL,NULL,NULL,NULL,NULL,NULL,'Post Comment Types',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(9,'Vote Types',NULL,NULL,NULL,NULL,NULL,NULL,'Vote Types',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(10,'Post Vote Types',NULL,NULL,NULL,NULL,NULL,NULL,'Post Vote Types',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(11,'Action Types',NULL,NULL,NULL,NULL,NULL,NULL,'Action Types',1,'2017-11-15 02:46:53',1,'2017-11-15 02:46:53',0),(12,'Point Types',NULL,NULL,NULL,NULL,NULL,NULL,'Point Types',1,'2017-11-15 02:47:17',1,'2017-11-15 02:47:17',0),(14,'Roles',NULL,NULL,NULL,NULL,NULL,NULL,'Roles',1,'2018-06-17 12:11:52',1,'2018-06-17 12:11:52',0),(15,'User Groups',NULL,NULL,NULL,NULL,NULL,NULL,'User Groups',1,'2018-06-17 12:11:52',1,'2018-06-17 12:11:52',0),(16,'Group Status',NULL,NULL,NULL,NULL,NULL,NULL,'Group Status',1,'2018-08-01 09:45:34',1,'2018-08-01 09:45:34',0),(17,'User Group Types',NULL,NULL,NULL,NULL,NULL,NULL,'User Group Types',1,'2018-08-05 21:25:29',1,'2018-08-05 21:25:29',0),(18,'User Status',NULL,NULL,NULL,NULL,NULL,NULL,'User Statuses',1,'2018-12-02 23:07:38',1,'2018-12-02 23:07:38',0);
/*!40000 ALTER TABLE `sys_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_code_value`
--

DROP TABLE IF EXISTS `sys_code_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_code_value` (
  `CODE_VALUE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_ID` int(11) NOT NULL,
  `CODE_VALUE` varchar(500) NOT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `DATA1` varchar(500) DEFAULT NULL,
  `DATA2` varchar(500) DEFAULT NULL,
  `DATA3` varchar(500) DEFAULT NULL,
  `COMMENTS` varchar(50) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`CODE_VALUE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_code_value`
--

LOCK TABLES `sys_code_value` WRITE;
/*!40000 ALTER TABLE `sys_code_value` DISABLE KEYS */;
INSERT INTO `sys_code_value` VALUES (1,1,'FACE','Facebook Network',NULL,NULL,NULL,'Facebook Network',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(2,1,'GOOG','Google Network',NULL,NULL,NULL,'Google Network',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(3,1,'APPC','Application Network',NULL,NULL,NULL,'Application Network',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(4,2,'MALE','Gender Male',NULL,NULL,NULL,'Gender Male',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(5,2,'FEML','Gender Female',NULL,NULL,NULL,'Gender Female',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(6,3,'GCIU','Google Client Id UAT','140500360968-gl23jgs6b5e9b0n052a417g66ter4e60.apps.googleusercontent.com',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(7,3,'GCIS','Google Client Id SYS','140500360968-f8t3e7pmt1e09knbdsq2jjjrr5fi4b3e.apps.googleusercontent.com',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(8,3,'GCIL','Google Client Id LOC','140500360968-qjbi53f7ie19ef4ufor51nqp6i4vt83m.apps.googleusercontent.com',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(9,3,'GAKU','Google API Key UAT','AIzaSyBnRA2rwLNKqPgdWuuPOXTR3UTaCJe9hH4',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(10,3,'GAKS','Google API Key SYS','AIzaSyDyxvLMSvnr1nfnXl_TuSvryixhJibK3Hg',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(11,3,'GAKL','Google API Key LOC','AIzaSyCp2Jq9z9MeCQEz3F0Q_mnvX13ngZu1jEI',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(12,3,'FCIU','Facebook Client Id UAT','768654456560330',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(13,3,'FCIS','Facebook Client Id SYS','764678906943496',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(14,3,'FCIL','Facebook Client Id LOC','801162613266480',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(15,3,'RDUU','Redirect URL UAT','http://www.curiositebox.com/siteAero/index.html',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(16,3,'RDUS','Redirect URL SYS','http://localhost/serviceAero/vAero/',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(17,3,'RDUL','Redirect URL LOC','http://localhost:8080/siteAero/index.html',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(18,3,'RSUU','Rest Service URL UAT','http://www.curiositebox.com/serviceAero/vAero/',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(19,3,'RSUS','Rest Service URL SYS','http://localhost/serviceAero/vAero/',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(20,3,'RSUL','Rest Service URL LOC','http://localhost:8080/api/vAero/',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(21,4,'REGN','System Region Values','LOC',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(22,5,'ERRR','Error Message',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(23,6,'CATA','Category Status Approved',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(24,6,'CATP','Category Status Pending For Approval',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(25,7,'THRA','Thread Status Approved',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(26,7,'THRP','Thread Status Pending For Approval',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(31,10,'QUES','Post Type Question',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(32,10,'ANSR','Post Type Answer',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(33,10,'CMNT','Post Type Comment',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(34,11,'UPVQ','Action Type - Up Vote Question',NULL,NULL,NULL,'',1,'2017-11-15 02:47:47',1,'2017-11-15 02:47:47',0),(35,11,'DNVQ','Action Type - Down Vote Question',NULL,NULL,NULL,'',1,'2017-11-15 02:48:07',1,'2017-11-15 02:48:07',0),(36,11,'UPVA','Action Type - Up Vote Answer',NULL,NULL,NULL,'',1,'2017-11-15 02:48:18',1,'2017-11-15 02:48:18',0),(37,11,'DNVA','Action Type - Down Vote Answer',NULL,NULL,NULL,'',1,'2017-11-15 02:48:31',1,'2017-11-15 02:48:31',0),(38,11,'UPVC','Action Type - Up Vote Comment',NULL,NULL,NULL,'',1,'2017-11-15 02:49:05',1,'2017-11-15 02:49:05',0),(39,11,'DNVC','Action Type - Down Vote Comment',NULL,NULL,NULL,'',1,'2017-11-15 02:49:05',1,'2017-11-15 02:49:05',0),(40,12,'VOTE','Vote Point',NULL,NULL,NULL,'',1,'2017-11-15 02:49:05',1,'2017-11-15 02:49:05',0),(41,12,'BONS','Bonus Point',NULL,NULL,NULL,'',1,'2017-11-15 02:49:05',1,'2017-11-15 02:49:05',0),(42,9,'UPVT','Vote Type Up',NULL,NULL,NULL,'',1,'2017-11-15 02:50:31',1,'2017-11-15 02:50:31',0),(43,9,'DNVT','Vote Type Down',NULL,NULL,NULL,'',1,'2017-11-15 02:50:31',1,'2017-11-15 02:50:31',0),(44,5,'INFO','Information Message',NULL,NULL,NULL,'',1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(54,11,'ANSR','Action Type - Answer',NULL,NULL,NULL,'',1,'2018-05-08 14:13:58',1,'2018-05-08 14:13:58',0),(56,11,'ASKQ','Action Type - Ask Question',NULL,NULL,NULL,'',1,'2018-05-08 14:13:58',1,'2018-05-08 14:13:58',0),(57,1,'TWIT','Twitter Network',NULL,NULL,NULL,'Twitter Network',1,'2018-05-08 14:17:17',1,'2018-05-08 14:17:17',0),(58,3,'REGN','System Envirionment','DEV',NULL,NULL,'',1,'2018-05-08 14:17:17',1,'2018-05-08 14:17:17',0),(59,11,'CMTQ','Action Type - Comment on Question',NULL,NULL,NULL,'',1,'2018-05-15 14:12:28',1,'2018-05-15 14:12:28',0),(60,11,'CMTA','Action Type - Comment on Answer',NULL,NULL,NULL,'',1,'2018-05-15 14:12:28',1,'2018-05-15 14:12:28',0),(61,14,'GNRL','General',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(62,14,'STUD','Student',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(63,14,'MDTR','Moderator',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(64,14,'TCHR','Teacher',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(65,14,'ADMN','Admin',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(66,15,'FRSH','Freshman','STUD',NULL,NULL,'',1,'2018-06-17 12:40:13',1,'2018-06-17 12:40:13',0),(67,15,'SPMR','Sophomore','STUD',NULL,NULL,'',1,'2018-06-17 12:40:13',1,'2018-06-17 12:40:13',0),(68,15,'JUNR','Junior','STUD',NULL,NULL,'',1,'2018-06-17 12:40:13',1,'2018-06-17 12:40:13',0),(69,15,'SENR','Senior','STUD',NULL,NULL,'',1,'2018-06-17 12:40:13',1,'2018-06-17 12:40:13',0),(70,15,'GNRL','General','',NULL,NULL,'',1,'2018-06-21 15:59:34',1,'2018-06-21 15:59:34',0),(71,15,'WOLI','World Literature Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:00:24',1,'2018-06-21 16:00:24',0),(72,15,'EULI','European Literature Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:01:06',1,'2018-06-21 16:01:06',0),(73,8,'ANSR','Comment Type Answer',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(74,8,'QUES','Comment Type Question',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(76,15,'ENLA','English Language Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(77,15,'ENLI','English Literature Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(78,15,'WOHI','World History Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(79,15,'HUGP','Human Geography Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(80,15,'PCLG','Psychology Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(81,15,'USHI','U.S. History Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(82,15,'CMST','Chemistry Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(83,15,'ANTM','Anatomy Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(84,15,'PSLG','Physiology Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(85,15,'PHSC','Physics Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(86,15,'ALGB','Algebra Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(87,15,'GMTR','Geometry Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(88,15,'CALS','Calculus Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(89,15,'STAT','Statistics Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(90,15,'FRCH','French Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(91,15,'LATN','Latin Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(92,15,'SPNS','Spanish Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(93,15,'FNAT','Fine Arts Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(94,15,'PHED','Physical Education Teacher','TCHR',NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(95,16,'ACTV','Active',NULL,NULL,NULL,'',1,'2018-08-01 09:45:34',1,'2018-08-01 09:45:34',0),(96,16,'INAC','Inactive',NULL,NULL,NULL,'',1,'2018-08-01 09:45:34',1,'2018-08-01 09:45:34',0),(97,17,'INDV','Individual',NULL,NULL,NULL,'',1,'2018-08-05 21:26:27',1,'2018-08-05 21:26:27',0),(99,17,'USGP','User Group',NULL,NULL,NULL,'',1,'2018-08-05 21:26:27',1,'2018-08-05 21:26:27',0),(100,17,'YEAR','Year',NULL,NULL,NULL,'',1,'2018-08-10 13:20:22',1,'2018-08-10 13:20:22',0),(101,10,'ANNC','Post Type Announcement',NULL,NULL,NULL,'',1,'2018-08-10 14:17:59',1,'2018-08-10 14:17:59',0),(102,11,'MNQU','Action Type - Mentioned In Question',NULL,NULL,NULL,'',1,'2018-08-11 12:44:25',1,'2018-08-11 12:44:25',0),(103,11,'MNAN','Action Type - Mentioned In Announcement',NULL,NULL,NULL,'',1,'2018-08-11 12:44:25',1,'2018-08-11 12:44:25',0),(104,18,'ACTV','Active',NULL,NULL,NULL,'',1,'2018-12-02 23:11:28',1,'2018-12-02 23:11:28',0),(105,18,'INAC','Inactive',NULL,NULL,NULL,'',1,'2018-12-02 23:11:28',1,'2018-12-02 23:11:28',0),(106,15,'ITCO','IT Coordinator',NULL,NULL,NULL,'',1,'2018-12-09 13:22:06',1,'2018-12-09 13:22:06',0);
/*!40000 ALTER TABLE `sys_code_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_level`
--

DROP TABLE IF EXISTS `sys_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_level` (
  `LEVEL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_NO` int(11) NOT NULL,
  `LEVEL_NAME` varchar(500) NOT NULL,
  `POINTS` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`LEVEL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_level`
--

LOCK TABLES `sys_level` WRITE;
/*!40000 ALTER TABLE `sys_level` DISABLE KEYS */;
INSERT INTO `sys_level` VALUES (1,1,'Beginner',0,'',1,'2018-03-31 12:48:03',1,'2018-03-31 12:48:03',0),(2,2,'Intermediate',100,'',1,'2018-03-31 12:58:55',1,'2018-03-31 12:58:55',0),(3,3,'Semi-professional',250,'',1,'2018-03-31 12:58:55',1,'2018-03-31 12:58:55',0),(4,4,'Professional',1000,'',1,'2018-03-31 12:58:55',1,'2018-03-31 12:58:55',0),(5,5,'World Class',2500,'',1,'2018-03-31 12:58:56',1,'2018-03-31 12:58:56',0),(6,6,'Legendary',10000,'',1,'2018-03-31 12:58:56',1,'2018-03-31 12:58:56',0);
/*!40000 ALTER TABLE `sys_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_message`
--

DROP TABLE IF EXISTS `sys_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_message` (
  `MESSAGE_ID` int(11) NOT NULL,
  `DISPLAY_MESSAGE` varchar(200) NOT NULL,
  `SEVERITY_ID` varchar(50) DEFAULT NULL,
  `SEVERITY_VALUE` varchar(50) DEFAULT NULL,
  `INTERNAL_INSTRUCTIONS` varchar(200) DEFAULT NULL,
  `USER_INSTRUCTIONS` varchar(200) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`MESSAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_message`
--

LOCK TABLES `sys_message` WRITE;
/*!40000 ALTER TABLE `sys_message` DISABLE KEYS */;
INSERT INTO `sys_message` VALUES (1,'Please enter first and last name .','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(2,'Looks like you have already signed up with us. Please click on forgot password if you want to reset your password','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(3,'Please enter email address.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(4,'Your password and retyped password does not match','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(5,'Your password should be longer than at least 8 characters','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(6,'Please enter your email address and password to login','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(7,'Either your email address or password does not match with our system. Please enter valid email address and password','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(8,'Please enter valid email address…','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(9,'Your email address does not match with our system. Please enter valid email address.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(10,'Please enter the question title.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(11,'Your question might already exists in the system. Please search for it before asking the question','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(12,'Question description is not descriptive. Please make it at least 100 characters','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(13,'Question title should be at least 20 characters','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(14,'Please login to perform this operation...','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(15,'Answer should be very descriptive and at least 100 characters long.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(16,'You have already voted for this post','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(17,'You cannot vote for your own post.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(18,'Please enter the comment','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(19,'Class name or class decription cannot be empty.','5','ERRR',NULL,NULL,1,'2017-12-07 21:14:30',1,'2017-12-07 21:14:30',0),(20,'Nothing was entered in the feedback box!!','5','ERRR',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(21,'Your feedback has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(22,'Your tag has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(23,'This tag already exists in the system.','5','ERRR',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(24,'Your vote has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(25,'Your comment has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(26,'Your answer has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(27,'Your question has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(28,'Please enter announcement title.','5','ERRR',NULL,NULL,1,'2018-11-30 12:54:42',1,'2018-11-30 12:54:42',0),(29,'Your announcement already exists in the system. Please enter a different title.','5','ERRR',NULL,NULL,1,'2018-12-01 17:38:26',1,'2018-12-01 17:38:26',0),(30,'Announcement description should be at lesat 100 characters','5','ERRR',NULL,NULL,1,'2018-11-30 12:54:42',1,'2018-11-30 12:54:42',0),(31,'Group name or description can not be left empty.','5','ERRR',NULL,NULL,1,'2018-11-30 14:38:05',1,'2018-11-30 14:38:05',0),(32,'Please select users from add users textbox.','5','ERRR',NULL,NULL,1,'2018-11-30 14:38:05',1,'2018-11-30 14:38:05',0),(33,'Your group name already exists in the system. Please enter a different group name.','5','ERRR',NULL,NULL,1,'2018-12-01 17:38:26',1,'2018-12-01 17:38:26',0),(34,'Please select role and user group for this user.','5','ERRR',NULL,NULL,1,'2018-12-09 12:34:37',1,'2018-12-09 12:34:37',0),(35,'Oops something went wrong!! system can not find your account. Please contact system administrator.','5','ERRR',NULL,NULL,1,'2018-12-22 21:02:22',1,'2018-12-22 21:02:22',0),(36,'Please enter the password.','5','ERRR',NULL,NULL,1,'2018-12-24 11:16:40',1,'2018-12-24 11:16:40',0),(37,'Your password must contain some letters.','5','ERRR',NULL,NULL,1,'2018-12-24 13:27:01',1,'2018-12-24 13:27:01',0),(38,'Your password must contain at least one number.','5','ERRR',NULL,NULL,1,'2018-12-24 13:27:01',1,'2018-12-24 13:27:01',0),(39,'Your password cannot be same as your email address.','5','ERRR',NULL,NULL,1,'2018-12-24 13:27:01',1,'2018-12-24 13:27:01',0);
/*!40000 ALTER TABLE `sys_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(50) NOT NULL,
  `ROLE_DESCRIPTION` varchar(50) NOT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'General','General','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0),(2,'Students','Students','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0),(3,'Moderators','Moderators','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0),(4,'Teachers','Teachers','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0),(5,'Admins','Admins','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL_ADDRESS` varchar(50) NOT NULL,
  `SALT_VALUE` varchar(500) DEFAULT NULL,
  `PASSWORD` varchar(500) DEFAULT NULL,
  `OTP` varchar(500) DEFAULT NULL,
  `IS_USER_VERIFIED` varchar(5) DEFAULT NULL,
  `IS_PASSWORD_FORGOTTEN` varchar(50) DEFAULT NULL,
  `USER_STATUS_ID` int(11) NOT NULL,
  `USER_STATUS_VALUE` varchar(50) DEFAULT NULL,
  `DISPLAY_NAME` varchar(50) NOT NULL,
  `FIRST_NAME` varchar(50) NOT NULL,
  `LAST_NAME` varchar(50) NOT NULL,
  `PICTURE_URL` varchar(2048) DEFAULT NULL,
  `NETWORK_ID` int(11) NOT NULL,
  `NETWORK_VALUE` varchar(50) DEFAULT NULL,
  `NETWORK_USER_ID` varchar(50) DEFAULT NULL,
  `BIRTH_DATE` datetime DEFAULT NULL,
  `GENDER_ID` int(11) NOT NULL,
  `GENDER_VALUE` varchar(50) DEFAULT NULL,
  `PHONE_NUMBER` varchar(50) DEFAULT NULL,
  `OCCUPATION` varchar(2048) DEFAULT '',
  `INTERESTS` varchar(2048) DEFAULT '',
  `ABOUT_ME` varchar(10000) DEFAULT '',
  `WEBSITE_URL` varchar(2048) DEFAULT '',
  `TWITTER_URL` varchar(2048) DEFAULT '',
  `FACEBOOK_URL` varchar(2048) DEFAULT '',
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'useradmin@gmail.com','eC6Xk5DEWLLsGgGFN2I4zg==','9a9cab78b9b4dafa985d934d93b0f145','bd347a00e9d95c13005b52360c1833c1','Y','N',18,'ACTV','User Admin','User','Admin','',1,'APPC','useradmin@gmail.com','2017-03-23 19:03:03',2,'MALE','785-969-9492','','','','','','',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(2,'community.user@gmail.com','bgvV8yuTlog=','5bac0dae59410bfefad869d0603b37da','3b727a4d5d196dff9e92d353ed761e95','Y','N',18,'ACTV','Community User','Community','User','\\ProfilePictures\\pp_2.jpg',1,'APPC','community.user@gmail.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2017-03-27 16:27:04',1,'2017-03-27 16:27:04',0),(12,'florence.butler68@curiousdrive.com','C4Z/ROmfAnpQsbaRJsRFag==','33952bc164e3dcbc7f4b524972267848','966f90a844033a4c1a2397609bf5f884','Y','N',18,'ACTV','Florence Butler','Florence','Butler','\\ProfilePictures\\pp_12.jpg',1,'APPC','florence.butler68@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:46:28',1,'2018-02-27 10:46:28',0),(13,'matthew.brooks21@curiousdrive.com','RAkR0yG8ulY=','593ebd262f0aed4ef6210a584b4770d1','01e8bb38ad51b471f8e8a17963410407','Y','N',18,'ACTV','Matthew Brooks','Matthew','Brooks','\\ProfilePictures\\pp_13.jpg',1,'APPC','matthew.brooks21@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:48:00',1,'2018-02-27 10:48:00',0),(14,'patsy.harris30@curiousdrive.com','HFnmSmbg5ooep3RjHZhgTQ==','2d69990a3a461e58e8897d725d30d84d','957a688333f3f90e679c026a67c0e8bc','Y','N',18,'ACTV','Patsy Harris','Patsy','Harris','\\ProfilePictures\\pp_14.jpg',1,'APPC','patsy.harris30@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:48:51',1,'2018-02-27 10:48:51',0),(15,'noah.peters58@curiousdrive.com','PLMR96BO2On5eHXOqAEHFA==','35a5f45e96c8a75056456e2d61148b64','e95ba21b15f0425e2e899216f68afd0c','Y','N',18,'ACTV','Noah Peters','Noah','Peters','\\ProfilePictures\\pp_15.jpg',1,'APPC','noah.peters58@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:49:35',1,'2018-02-27 10:49:35',0),(16,'ritthy.fox48@curiousdrive.com','oW8H2l7pBWybR5o9Jn/gtg==','56f4f2d3496b2debdcc3c260f12b468a','5172677815cbff0a64335d8ad04ff149','Y','N',18,'ACTV','Ritthy Fox','Ritthy','Fox','\\ProfilePictures\\pp_16.jpg',1,'APPC','ritthy.fox48@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:49:58',1,'2018-02-27 10:49:58',0),(17,'gertrude.morris19@curiousdrive.com','eC6Xk5DEWLLsGgGFN2I4zg==','ac7ece1cbbc7046cc3488e1e7e0a7205','c42682633b44f5b66c6b300585276ef8','Y','N',18,'ACTV','Gertrude Morris','Gertrude','Morris','\\ProfilePictures\\pp_17.jpg',1,'APPC','gertrude.morris19@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:50:33',1,'2018-02-27 10:50:33',0),(18,'ralph.wagner50@curiousdrive.com','5StlOocpY6GiW70IDig0Qg==','41dc1bc762a477997f9d483dbb266214','faa2c7d52356a599067c8bb69e115282','Y','N',18,'ACTV','Ralph Wagner','Ralph','Wagner','\\ProfilePictures\\pp_18.jpg',1,'APPC','ralph.wagner50@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:50:56',1,'2018-02-27 10:50:56',0),(19,'leona.perez44@curiousdrive.com','S0v4CGMG8dF7G744MWVlZQ==','8347fb27efe835545097633238cd16c1','0b3041860410db4ec3878ebdb88295b5','Y','N',18,'ACTV','Leona Perez','Leona','Perez','\\ProfilePictures\\pp_19.jpg',1,'APPC','leona.perez44@curiousdrive.com',NULL,0,NULL,'999-999-9999',NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 00:00:00',0,'2018-03-11 14:13:10',0),(20,'arron.cox92@curiousdrive.com','bYjraD6oX4c=','0c34bb759903556dd96e9f8557b53b04','4efe4e02692760c7a4a2656ae4a98f18','Y','N',18,'ACTV','Arron Cox','Arron','Cox','\\ProfilePictures\\pp_20.jpg',1,'APPC','arron.cox92@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:51:46',1,'2018-02-27 10:51:46',0),(21,'liam.bradley28@curiousdrive.com','5g2artMY0GE=','646ae1816d5cc42af42eb65f66b892a2','2a0fddf365bcc9569bfe2118959b26fd','Y','N',18,'ACTV','Liam Bradley','Liam','Bradley','\\ProfilePictures\\pp_21.jpg',1,'APPC','liam.bradley28@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:52:06',1,'2018-02-27 10:52:06',0),(22,'hunter.rodriquez23@curiousdrive.com','RAkR0yG8ulY=','bb467f00edaaa7445134693c50e1d51d','a5a86d94bffd8397f5b08dd30e2f5f9b','Y','N',18,'ACTV','Hunter Rodriquez','Hunter','Rodriquez','\\ProfilePictures\\pp_22.jpg',1,'APPC','hunter.rodriquez23@curiousdrive.com',NULL,0,NULL,'7859699492',NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 00:00:00',0,'2018-03-22 13:26:29',0),(23,'jimmy.carr41@curiousdrive.com','bgvV8yuTlog=','8acfc3b5a5201afceef9a098f31106d6','426924b31b523fed4c9662edc8ad43da','Y','N',18,'ACTV','Jimmy Carr','Jimmy','Carr','\\ProfilePictures\\pp_23.jpg',1,'APPC','jimmy.carr41@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:52:53',1,'2018-02-27 10:52:53',0),(24,'sarah.horton16@curiousdrive.com','5g2artMY0GE=','77ab548c4e8af2833e8da749f6a50c83','15e9149235080f01264e9faf3e61feb5','Y','N',18,'ACTV','Sarah Horton','Sarah','Horton','\\ProfilePictures\\pp_24.jpg',1,'APPC','sarah.horton16@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:53:18',1,'2018-02-27 10:53:18',0),(25,'riley.powell33@curiousdrive.com','747hzIiGHwdeOusEXq5cDw==','69f55e60b912a9f99bc9e5701da22e68','f43a9e9c22bd4372a8f849d3c3a4a560','Y','N',18,'ACTV','Riley Powell','Riley','Powell',NULL,1,'APPC','riley.powell33@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:53:39',1,'2018-02-27 10:53:39',0),(26,'beatrice.harrison19@curiousdrive.com','747hzIiGHwdeOusEXq5cDw==','bc09ffa66c3261c808f51557e580c281','adf2d30d9526bda36409b2136130cf87','Y','N',18,'ACTV','Beatrice Harrison','Beatrice','Harrison','\\ProfilePictures\\pp_26.jpg',1,'APPC','beatrice.harrison19@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:54:06',1,'2018-02-27 10:54:06',0),(27,'kylie.kelley38@curiousdrive.com','C4Z/ROmfAnpQsbaRJsRFag==','89d0f2569bf76a88d4fb8d587fec02f8','94e4e9d912bfb2749a4e108a6b7ba428','Y','N',18,'ACTV','Kylie Kelley','Kylie','Kelley','\\ProfilePictures\\pp_27.jpg',1,'APPC','kylie.kelley38@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:54:30',1,'2018-02-27 10:54:30',0),(28,'leo.cole59@curiousdrive.com','5Zo1BaqR9LCvG5HSG4+uGhHWp/jKfX0L','3244c1f4ae41de4200a7c6284cdced67','37eaa8d03e5719fffc2eb7fd488e2923','Y','N',18,'ACTV','Leo Cole','Leo','Cole','\\ProfilePictures\\pp_28.jpg',1,'APPC','leo.cole59@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 10:54:58',1,'2018-02-27 10:54:58',0),(29,'gail.baker76@curiousdrive.com','TU27nBaqRiSI/pCTrwI27A==','169d5edbf2a03a981b03de2e536afa37','9ab4e324b3932a725b2d83ab0c2aa3ff','Y','N',18,'ACTV','Gail Baker','Gail','Baker','\\ProfilePictures\\pp_29.jpg',1,'APPC','gail.baker76@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:17:20',1,'2018-02-27 11:17:20',0),(30,'ritthy.reid40@curiousdrive.com','bgvV8yuTlog=','e745cb35f740980e3687ad6bd9076554','fc35e80836068f12101692fac654bd6d','Y','N',18,'ACTV','Ritthy Reid','Ritthy','Reid','\\ProfilePictures\\pp_30.jpg',1,'APPC','ritthy.reid40@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:17:44',1,'2018-02-27 11:17:44',0),(31,'suzanne.king32@curiousdrive.com','eC6Xk5DEWLLsGgGFN2I4zg==','8c344a8006da37a56f9b2fbf3e8377c2','00586e0eb29b8e3ec7d21fbceaff6a6a','Y','N',18,'ACTV','Suzanne King','Suzanne','King','\\ProfilePictures\\pp_31.jpg',1,'APPC','suzanne.king32@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:18:08',1,'2018-02-27 11:18:08',0),(32,'marie.cox79@curiousdrive.com','C4Z/ROmfAnpQsbaRJsRFag==','36d40d4f55b0e1c29a632ca697165100','65d0c886e7a0412f4a25096517650037','Y','N',18,'ACTV','Marie Cox','Marie','Cox',NULL,1,'APPC','marie.cox79@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:18:33',1,'2018-02-27 11:18:33',0),(33,'carlos.castro48@curiousdrive.com','q4IfUFbQl6WJtseoc+74FA==','1ea693328db19f6138f8ac3b087f7432','b0753be9ca14a51dea43c76764dc1027','Y','N',18,'ACTV','Carlos Castro','Carlos','Castro','\\ProfilePictures\\pp_33.jpg',1,'APPC','carlos.castro48@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:19:02',1,'2018-02-27 11:19:02',0),(34,'max.reid75@curiousdrive.com','S0v4CGMG8dF7G744MWVlZQ==','b206f36c4d0dcc525ea6ae24034c922f','03b7aef48d6114e540bed73d75bdd3ee','Y','N',18,'ACTV','Max Reid','Max','Reid','\\ProfilePictures\\pp_34.jpg',1,'APPC','max.reid75@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:19:26',1,'2018-02-27 11:19:26',0),(35,'ronald.welch47@curiousdrive.com','mYKzVjNjXDCKFa9Dclpf3g==','15462376016bd2fb3446197b022f716c','d1a0d6e470f6f9a235e6caa2b0ba85a4','Y','N',18,'ACTV','Ronald Welch','Ronald','Welch','\\ProfilePictures\\pp_35.jpg',1,'APPC','ronald.welch47@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:19:57',1,'2018-02-27 11:19:57',0),(36,'kevin.collins34@curiousdrive.com','C4Z/ROmfAnpQsbaRJsRFag==','99b4f6355512b682d9a0f5e39d11036c','7379ef6b0276b23c675a9959dc79e663','Y','N',18,'ACTV','Kevin Collins','Kevin','Collins','\\ProfilePictures\\pp_36.jpg',1,'APPC','kevin.collins34@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:20:16',1,'2018-02-27 11:20:16',0),(37,'jacqueline.spencer16@curiousdrive.com','bgvV8yuTlog=','1d31d1709aa21d64b424192c00ce148f','5850952074ce310720f4aef7fc9ef013','Y','N',18,'ACTV','Jacqueline Spencer','Jacqueline','Spencer','\\ProfilePictures\\pp_37.jpg',1,'APPC','jacqueline.spencer16@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:20:39',1,'2018-02-27 11:20:39',0),(38,'catherine.griffin61@curiousdrive.com','q4IfUFbQl6WJtseoc+74FA==','248d96f1d15ff6df29bb78bc90f14eb3','d9cd3393bac2cdb1bd62ce7da1982db4','Y','N',18,'ACTV','catherine griffin','catherine','griffin','\\ProfilePictures\\pp_38.jpg',1,'APPC','catherine.griffin61@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:21:06',1,'2018-02-27 11:21:06',0),(39,'william.curtis71@curiousdrive.com','747hzIiGHwdeOusEXq5cDw==','86330ef29d7fa71b4aa543f158a10a56','155ff35752f9e545b3d2e0b78c70759e','Y','N',18,'ACTV','William Curtis','William','Curtis',NULL,1,'APPC','william.curtis71@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:21:47',1,'2018-02-27 11:21:47',0),(40,'kenzi.richardson26@curiousdrive.com','PLMR96BO2On5eHXOqAEHFA==','1649084a0c44f2f538ed29abb7ee57e1','3046ac6d94cbc8b5c596161a5c9c9ed4','Y','N',18,'ACTV','Kenzi Richardson','Kenzi','Richardson','\\ProfilePictures\\pp_40.jpg',1,'APPC','kenzi.richardson26@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:30:51',1,'2018-02-27 11:30:51',0),(41,'jack.phillips72@curiousdrive.com','+Y8s+NpJm5eOdmlpujXIoA==','91f8c1b2651be47c4cdd89a33f8941a1','38143fe086a2c41612d460f2e3346336','Y','N',18,'ACTV','Jack Phillips','Jack','Phillips','\\ProfilePictures\\pp_41.jpg',1,'APPC','jack.phillips72@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:31:16',1,'2018-02-27 11:31:16',0),(42,'victor.marshall94@curiousdrive.com','TU27nBaqRiSI/pCTrwI27A==','43b5f537297529b4fa5d594fe9d16eef','29000cce7e6bdb783d9a75963ec16d06','Y','N',18,'ACTV','Victor Marshall','Victor','Marshall','\\ProfilePictures\\pp_42.jpg',1,'APPC','victor.marshall94@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:31:38',1,'2018-02-27 11:31:38',0),(43,'marian.burns62@curiousdrive.com','bgvV8yuTlog=','e52e242ad5f78957a7174022c46fb4b2','9c0128a9cf788d6f8e5f7ffa85fb6440','Y','N',18,'ACTV','Marian Burns','Marian','Burns','\\ProfilePictures\\pp_43.jpg',1,'APPC','marian.burns62@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:32:00',1,'2018-02-27 11:32:00',0),(44,'ronald.peters56@curiousdrive.com','o4UhjEI94IH0Bb9QSOvUnIyOo/6MqKvT','6378eed95fac6a3d94acc6d46ab564ff','b449dfb3f84feb0205404f076a92a8c9','Y','N',18,'ACTV','Ronald Peters','Ronald','Peters','\\ProfilePictures\\pp_44.jpg',1,'APPC','ronald.peters56@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:32:25',1,'2018-02-27 11:32:25',0),(45,'erin.morris25@curiousdrive.com','EgF0XPOUFuTKZVUjN+ndCg==','9568f6c3451cf39a0f513880bf7e28c2','5c2e99c3d0964f39cd19c10554ea7654','Y','N',18,'ACTV','Erin Morris','Erin','Morris','\\ProfilePictures\\pp_45.jpg',1,'APPC','erin.morris25@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:32:49',1,'2018-02-27 11:32:49',0),(46,'juan.holt10@curiousdrive.com','bYjraD6oX4c=','d9df0d514cb3da6f0deb744c905f166a','f840c266f28aad5ad40cfb01c5b2fc33','Y','N',18,'ACTV','Juan Holt','Juan','Holt','\\ProfilePictures\\pp_46.jpg',1,'APPC','juan.holt10@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:33:09',1,'2018-02-27 11:33:09',0),(47,'joe.watson17@curiousdrive.com','mYKzVjNjXDCKFa9Dclpf3g==','8b4391d655cc68dca392fee2eee0e43d','dd694a00b7c0eb0fe3ad7cadc67ddc49','Y','N',18,'ACTV','Joe Watson','Joe','Watson','\\ProfilePictures\\pp_47.jpg',1,'APPC','joe.watson17@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:33:30',1,'2018-02-27 11:33:30',0),(48,'shane.castro24@curiousdrive.com','PLMR96BO2On5eHXOqAEHFA==','5b6b08330cbab763ef57b16223b6cbea','33b7f8472a50ee6a67b27eae82139f7c','Y','N',18,'ACTV','Shane Castro','Shane','Castro','\\ProfilePictures\\pp_48.jpg',1,'APPC','shane.castro24@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:34:39',1,'2018-02-27 11:34:39',0),(49,'madison.hunter48@curiousdrive.com','oW8H2l7pBWybR5o9Jn/gtg==','8bb83aa125436db26ae91cdaede3016c','b47e6bb4d1dea595ab1e8d17177f7a6b','Y','N',18,'ACTV','Madison Hunter','Madison','Hunter','\\ProfilePictures\\pp_49.jpg',1,'APPC','madison.hunter48@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:35:13',1,'2018-02-27 11:35:13',0),(50,'robin.alexander58@curiousdrive.com','eC6Xk5DEWLLsGgGFN2I4zg==','e19ebee70ee8fd713d770e4ab7fdd6fb','cdd09cdada84e0c625ef5b2348e888c0','Y','N',18,'ACTV','Robin Alexander','Robin','Alexander','\\ProfilePictures\\pp_50.jpg',1,'APPC','robin.alexander58@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:35:37',1,'2018-02-27 11:35:37',0),(51,'darryl.montgomery88@curiousdrive.com','bgvV8yuTlog=','ac768281c8d1a57a8568f09e752649bb','2bfd4bb6e7d5d8d3cbda343b6ef69452','Y','N',18,'ACTV','Darryl Montgomery','Darryl','Montgomery','\\ProfilePictures\\pp_51.jpg',1,'APPC','darryl.montgomery88@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:35:57',1,'2018-02-27 11:35:57',0),(52,'holly.holland76@curiousdrive.com','OnNu3iNJimfPZvH48FF1iA==','0123c95878e37a42f7bd088d78876b62','c80a560350150248bf58a1d73e1b28cd','Y','N',18,'ACTV','Holly Holland','Holly','Holland','\\ProfilePictures\\pp_52.jpg',1,'APPC','holly.holland76@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:36:20',1,'2018-02-27 11:36:20',0),(53,'ruben.flores63@curiousdrive.com','wxn8EKXadDg=','bc3342996979e32bd7ece9776dca7374','f4c24a01849436495d5b80d67a9a136a','Y','N',18,'ACTV','Ruben Flores','Ruben','Flores','\\ProfilePictures\\pp_53.jpg',1,'APPC','ruben.flores63@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:36:41',1,'2018-02-27 11:36:41',0),(54,'billy.martinez67@curiousdrive.com','HFnmSmbg5ooep3RjHZhgTQ==','0bf49191adcf561bccc598a1860611f1','c737780ca71ca6bea99b2cc02918ebe1','Y','N',18,'ACTV','Billy Martinez','Billy','Martinez','\\ProfilePictures\\pp_54.jpg',1,'APPC','billy.martinez67@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:37:31',1,'2018-02-27 11:37:31',0),(55,'valerie.patterson64@curiousdrive.com','HFnmSmbg5ooep3RjHZhgTQ==','018090d50928799f860d95bd089d85d9','3c4bed1df23b40462c620dffd7c6b982','Y','N',18,'ACTV','Valerie Patterson','Valerie','Patterson','\\ProfilePictures\\pp_55.jpg',1,'APPC','valerie.patterson64@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:38:25',1,'2018-02-27 11:38:25',0),(56,'tanya.montgomery52@curiousdrive.com','eC6Xk5DEWLLsGgGFN2I4zg==','439167c486f380cf80661e820bd52207','a44572eb711bcb4d2dbc212b95ee26da','Y','N',18,'ACTV','Tanya Montgomery','Tanya','Montgomery','\\ProfilePictures\\pp_56.jpg',1,'APPC','tanya.montgomery52@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:38:49',1,'2018-02-27 11:38:49',0),(57,'pearl.alvarez10@curiousdrive.com','grv1L+AYlUZulIT97oDeow==','b406389294ec5aae08ecc0705d6f25a6','d4930a00cd5e26a3d052a2bc98a14fea','Y','N',18,'ACTV','Pearl Alvarez','Pearl','Alvarez','\\ProfilePictures\\pp_57.jpg',1,'APPC','pearl.alvarez10@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:39:12',1,'2018-02-27 11:39:12',0),(58,'melinda.wood68@curiousdrive.com','bYjraD6oX4c=','be3a3a01ffd78c0357eb10cf23a5bb76','00be96a8d3e8aa2c83690591bc45a922','Y','N',18,'ACTV','Melinda Wood','Melinda','Wood','\\ProfilePictures\\pp_58.jpg',1,'APPC','melinda.wood68@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:39:37',1,'2018-02-27 11:39:37',0),(59,'rachel.elliott81@curiousdrive.com','OnNu3iNJimfPZvH48FF1iA==','d7338a3867e4b545534dabe43789c76e','f9aaadb0957998edc96630248ba3d402','Y','N',18,'ACTV','Rachel Elliott','Rachel','Elliott','\\ProfilePictures\\pp_59.jpg',1,'APPC','rachel.elliott81@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:40:36',1,'2018-02-27 11:40:36',0),(60,'emily.mills97@curiousdrive.com','5Zo1BaqR9LCvG5HSG4+uGhHWp/jKfX0L','cb823918ad2bf7f3227e13cd183d2ac7','adea52737fe9828e34e6601ffeb86bc4','Y','N',18,'ACTV','Emily Mills','Emily','Mills','',1,'APPC','emily.mills97@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-02-27 11:40:57',1,'2018-02-27 11:40:57',0),(61,'esther.kelly25@curiousdrive.com','Vxpz41AAPlfSZSwICD0e2Q==','90246b375d90a536e897e086d928fb52','0ba07fc082ea6e4a80be2bd970c7f39f','Y','N',18,'ACTV','Esther Kelly','Esther','Kelly','\\ProfilePictures\\pp_61.jpg',1,'APPC','esther.kelly25@example.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-04-22 20:53:42',1,'2018-04-22 20:53:42',0),(62,'steve.rogers43@curiousdrive.com','OnNu3iNJimfPZvH48FF1iA==','8e6aedea928635beec9b74cde2498ef5','b8b3231d5dbe13b055007b465102b9a3','Y','N',18,'ACTV','Steve Rogers','Steve','Rogers',NULL,1,'APPC','steve.rogers43@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-04-27 11:20:34',1,'2018-04-27 11:20:34',0),(63,'erin.elliott54@curiousdrive.com','o4UhjEI94IH0Bb9QSOvUnIyOo/6MqKvT','65d745c4afbf77b8281471fbfadfd5e2','6a316077dc81248abecf3a242316d3c9','Y','N',18,'ACTV','Erin Elliott','Erin','Elliott','\\ProfilePictures\\pp_63.jpg',1,'APPC','erin.elliott54@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-04-27 11:24:02',1,'2018-04-27 11:24:02',0),(64,'vincent.berry99@curiousdrive.com','PLMR96BO2On5eHXOqAEHFA==','8139f4110dc65647df94e1a352ff70cd','a35848b37965baba096902961e83725c','Y','N',18,'ACTV','Vincent  Berry','Vincent ','Berry','\\ProfilePictures\\pp_64.jpg',1,'APPC','vincent.berry99@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-21 13:49:42',1,'2018-06-21 13:49:42',0),(65,'glen.olson28@curiousdrive.com','4ppXY3M7EXrjroofUVf8e1ULU2eG3cUK','d3141fd4d751df5aa9c3c8041cc919cf','681f6a06133b0942b7d7749858dea063','Y','N',18,'ACTV','Glen  Olson','Glen ','Olson','\\ProfilePictures\\pp_65.jpg',1,'APPC','glen.olson28@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-21 15:56:54',1,'2018-06-21 15:56:54',0),(66,'shelly.powell99@curiousdrive.com','EgF0XPOUFuTKZVUjN+ndCg==','132d1ae6f1c15165eb564baed634025f','8751aa79231edb0278b17a8912e00ae8','Y','N',18,'ACTV','Shelly  Powell','Shelly ','Powell','\\ProfilePictures\\pp_66.jpg',1,'APPC','shelly.powell99@curious.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 13:59:00',1,'2018-06-22 13:59:00',0),(67,'don.carpenter59@curiousdrive.com','eC6Xk5DEWLLsGgGFN2I4zg==','bea125315daadf8a16ce85d4ade09b6b','7187b2891ab977bb164c880aea4b0a60','Y','N',18,'ACTV','Don  Carpenter','Don ','Carpenter','\\ProfilePictures\\pp_67.jpg',1,'APPC','don.carpenter59@curious.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 13:59:46',1,'2018-06-22 13:59:46',0),(68,' lena.hudson17@curiousdrive.com','RAkR0yG8ulY=','b97a2bea3241101dcd4ea88fb905bb04','2a81b148a7e18bc58d439ebf37bcccbe','Y','N',18,'ACTV','Lena  Hudson','Lena ','Hudson','\\ProfilePictures\\pp_68.jpg',1,'APPC',' lena.hudson17@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:00:52',1,'2018-06-22 14:00:52',0),(69,'patrick.gilbert19@curiousdrive.com','0hM5Rthts7YtBcGv0ldGD4y22xabAKEQ','e5d582e4c55fe188fbc70cd217acf670','9f0e60587b2c243d7ac32a88034eed43','Y','N',18,'ACTV','Patrick  Gilbert','Patrick ','Gilbert','\\ProfilePictures\\pp_69.jpg',1,'APPC','patrick.gilbert19@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:01:32',1,'2018-06-22 14:01:32',0),(70,'wallace.turner61@curiousdrive.com','grv1L+AYlUZulIT97oDeow==','7ba3c421cf49959bcc575abd10a211e1','46578cf4c8c577392f03440b9df044ff','Y','N',18,'ACTV','Wallace  Turner','Wallace ','Turner','\\ProfilePictures\\pp_70.jpg',1,'APPC','wallace.turner61@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:02:15',1,'2018-06-22 14:02:15',0),(71,'alexander.mckinney73@curiousdrive.com','q4IfUFbQl6WJtseoc+74FA==','185858a3a1569fae00652a5104f7774d','23bf54f2690ffb81895921025fda6889','Y','N',18,'ACTV','Alexander  Mckinney','Alexander ','Mckinney','\\ProfilePictures\\pp_71.jpg',1,'APPC','alexander.mckinney73@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:02:57',1,'2018-06-22 14:02:57',0),(72,'tanya.holmes27@curiousdrive.com','bgvV8yuTlog=','b66acef599e2e5dfe6b565ceeea1b4c2','17dbbfd89e2c2ed68e4f56df7ba57c48','Y','N',18,'ACTV','Tanya  Holmes','Tanya ','Holmes','\\ProfilePictures\\pp_72.jpg',1,'APPC','tanya.holmes27@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:03:35',1,'2018-06-22 14:03:35',0),(73,'bruce.stevens37@curiousdrive.com','wxn8EKXadDg=','804d4f7bbe4d99f32a26b37c970af625','a30967042e79f2d82a381d08a02de161','Y','N',18,'ACTV','Bruce  Stevens','Bruce ','Stevens','\\ProfilePictures\\pp_73.jpg',1,'APPC','bruce.stevens37@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:04:27',1,'2018-06-22 14:04:27',0),(74,'billy.sullivan19@curiousdrive.com','bgvV8yuTlog=','8c974690939af3ebd67e237cb5dca6e8','a9d40e07699f178a19628b4bf52d408a','Y','N',18,'ACTV','Billy  Sullivan','Billy ','Sullivan','\\ProfilePictures\\pp_74.jpg',1,'APPC','billy.sullivan19@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:05:17',1,'2018-06-22 14:05:17',0),(75,'marsha.phillips32@curiousdrive.com','wxn8EKXadDg=','17042752c2c6956046593786366140e5','4a9f98c52a826adcb7bdbbd31bc6d429','Y','N',18,'ACTV','Marsha  Phillips','Marsha ','Phillips','\\ProfilePictures\\pp_75.jpg',1,'APPC','marsha.phillips32@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:10:41',1,'2018-06-22 14:10:41',0),(76,'kristina.bennett19@curiousdrive.com','mcLHa5XfnTwdBc5TYZu3mQiEVt4wY17B','6f0f38a83297bcd7067de2bcce2ad28a','c98f208e4f6a3169c8a8434d7048b9d3','Y','N',18,'ACTV','Kristina  Bennett','Kristina ','Bennett','\\ProfilePictures\\pp_76.jpg',1,'APPC','kristina.bennett19@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:13:19',1,'2018-06-22 14:13:19',0),(77,'charlotte.mitchelle14@curiousdrive.com','4ppXY3M7EXrjroofUVf8e1ULU2eG3cUK','96aa3ec19526c061f2c8f597a6977fdf','94e44290753eb4ca0450f9a959607015','Y','N',18,'ACTV','Charlotte  Mitchelle','Charlotte ','Mitchelle','\\ProfilePictures\\pp_77.jpg',1,'APPC','charlotte.mitchelle14@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:14:45',1,'2018-06-22 14:14:45',0),(78,'jessie.ryan92@curiousdrive.com','q4IfUFbQl6WJtseoc+74FA==','f670a629dea7cd8dbae0872cebb0824b','9eb97377df494dcd9a59258cc3b89cd0','Y','N',18,'ACTV','Jessie  Ryan','Jessie ','Ryan','\\ProfilePictures\\pp_78.jpg',1,'APPC','jessie.ryan92@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:21:07',1,'2018-06-22 14:21:07',0),(79,'andy.knight41@curiousdrive.com','HFnmSmbg5ooep3RjHZhgTQ==','0acd5b34281bbe46b927e4e8dfb58e10','fb138e413e084a196dc6f5acbdc96330','Y','N',18,'ACTV','Andy  Knight','Andy ','Knight','\\ProfilePictures\\pp_79.jpg',1,'APPC','andy.knight41@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:22:14',1,'2018-06-22 14:22:14',0),(80,'javier.hughes51@curiousdrive.com','GnjYe72v6CAhCjSt072+Zg==','672f08efe711480bc454764b516b74d7','d9a30ba18f33e8a323d7d3414c96026a','Y','N',18,'ACTV','Javier Hughes','Javier','Hughes',NULL,1,'APPC','javier.hughes51@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:22:56',1,'2018-06-22 14:22:56',0),(81,'meghan.cruz92@curiousdrive.com','RAkR0yG8ulY=','c6a8207907f46ec804e936d7c2565e53','1936886a2c7f0be933f34c54cc9920b6','Y','N',18,'ACTV','Meghan  Cruz','Meghan ','Cruz','\\ProfilePictures\\pp_81.jpg',1,'APPC','meghan.cruz92@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-06-22 14:23:36',1,'2018-06-22 14:23:36',0),(82,'willard.nelson43@curiousdrive.com','mcLHa5XfnTwdBc5TYZu3mQiEVt4wY17B','766bf254a39453f9edc332350dc56e4a','449d59404947ff616ea0cda7ee460c9e','Y','N',18,'ACTV','Willard  Nelson','Willard ','Nelson','\\ProfilePictures\\pp_82.jpg',1,'APPC','willard.nelson43@curiousdrive.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-07-10 18:06:29',1,'2018-07-10 18:06:29',0),(101,'fahadmullaji@gmail.com','q4IfUFbQl6WJtseoc+74FA==','59cacf29c333bcaf83076999b21597b1','611f25b129bd838b59dbdf41daa1a2b2','Y','N',18,'INAC','Fahad Mullaji','Fahad','Mullaji',NULL,1,'APPC','fahadmullaji@gmail.com',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'2018-12-21 13:14:33',0,'2018-12-27 12:26:52',0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `USER_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  `ROLE_VALUE` varchar(50) DEFAULT NULL,
  `USER_GROUP_ID` int(11) DEFAULT NULL,
  `USER_GROUP_VALUE` varchar(50) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1,14,'ADMN',15,NULL,1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(2,2,14,'ADMN',15,NULL,1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(12,12,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(13,13,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(14,14,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(15,15,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(16,16,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(17,17,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(18,18,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(19,19,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(20,20,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(21,21,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(22,22,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(23,23,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(24,24,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(25,25,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(26,26,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(27,27,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(28,28,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(29,29,14,'MDTR',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(30,30,14,'MDTR',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(31,31,14,'MDTR',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(32,32,14,'MDTR',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(33,33,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(34,34,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(35,35,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(36,36,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(37,37,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(38,38,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(39,39,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(40,40,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(41,41,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(42,42,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(43,43,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(44,44,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(45,45,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(46,46,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(47,47,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(48,48,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(49,49,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(50,50,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(51,51,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(52,52,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(53,53,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(54,54,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(55,55,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(56,56,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(57,57,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(58,58,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(59,59,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(60,60,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(61,61,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(62,62,14,'STUD',15,'SENR',0,'2018-04-27 11:20:34',0,'2018-04-27 11:20:34',0),(63,63,14,'TCHR',15,'EULI',1,'2018-04-27 11:24:02',1,'2018-04-27 11:24:02',0),(64,64,14,'TCHR',15,'ENLA',1,'2018-06-21 13:49:42',1,'2018-06-21 13:49:42',0),(65,65,14,'TCHR',15,'ENLI',1,'2018-06-21 15:56:54',1,'2018-06-21 15:56:54',0),(66,66,14,'TCHR',15,'WOHI',1,'2018-06-22 13:59:00',1,'2018-06-22 13:59:00',0),(67,67,14,'TCHR',15,'HUGP',1,'2018-06-22 13:59:46',1,'2018-06-22 13:59:46',0),(68,68,14,'TCHR',15,'PCLG',1,'2018-06-22 14:00:52',1,'2018-06-22 14:00:52',0),(69,69,14,'TCHR',15,'USHI',1,'2018-06-22 14:01:32',1,'2018-06-22 14:01:32',0),(70,70,14,'TCHR',15,'CMST',1,'2018-06-22 14:02:15',1,'2018-06-22 14:02:15',0),(71,71,14,'TCHR',15,'ANTM',1,'2018-06-22 14:02:57',1,'2018-06-22 14:02:57',0),(72,72,14,'TCHR',15,'PSLG',1,'2018-06-22 14:03:35',1,'2018-06-22 14:03:35',0),(73,73,14,'TCHR',15,'PHSC',1,'2018-06-22 14:04:27',1,'2018-06-22 14:04:27',0),(74,74,14,'TCHR',15,'ALGB',1,'2018-06-22 14:05:17',1,'2018-06-22 14:05:17',0),(75,75,14,'TCHR',15,'GMTR',1,'2018-06-22 14:10:41',1,'2018-06-22 14:10:41',0),(76,76,14,'TCHR',15,'CALS',1,'2018-06-22 14:13:19',1,'2018-06-22 14:13:19',0),(77,77,14,'TCHR',15,'STAT',1,'2018-06-22 14:14:45',1,'2018-06-22 14:14:45',0),(78,78,14,'TCHR',15,'FRCH',1,'2018-06-22 14:21:07',1,'2018-06-22 14:21:07',0),(79,79,14,'TCHR',15,'LATN',1,'2018-06-22 14:22:14',1,'2018-06-22 14:22:14',0),(80,80,14,'TCHR',15,'SPNS',1,'2018-06-22 14:22:56',1,'2018-06-22 14:22:56',0),(81,81,14,'TCHR',15,'FNAT',1,'2018-06-22 14:23:36',1,'2018-06-22 14:23:36',0),(82,82,14,'TCHR',15,'PHED',1,'2018-07-10 18:06:29',1,'2018-07-10 18:06:29',0),(83,83,14,'ADMN',15,'ITCO',1,'2018-12-09 13:23:02',1,'2018-12-09 13:23:02',0),(84,84,14,'ADMN',15,'ITCO',1,'2018-12-09 13:32:45',1,'2018-12-09 13:32:45',0),(85,83,14,'ADMN',15,'ITCO',1,'2018-12-13 15:08:17',1,'2018-12-13 15:08:17',0),(86,84,14,'ADMN',15,'ITCO',1,'2018-12-13 16:34:28',1,'2018-12-13 16:34:28',0),(87,85,14,'ADMN',15,'ITCO',1,'2018-12-13 16:44:53',1,'2018-12-13 16:44:53',0),(88,86,14,'ADMN',15,'ITCO',1,'2018-12-17 20:59:43',1,'2018-12-17 20:59:43',0),(89,87,14,'ADMN',15,'ITCO',1,'2018-12-17 21:30:37',1,'2018-12-17 21:30:37',0),(90,88,14,'ADMN',15,'ITCO',1,'2018-12-17 21:45:15',1,'2018-12-17 21:45:15',0),(91,89,14,'ADMN',15,'ITCO',1,'2018-12-17 21:49:09',1,'2018-12-17 21:49:09',0),(92,90,14,'ADMN',15,'ITCO',1,'2018-12-17 22:12:26',1,'2018-12-17 22:12:26',0),(93,91,14,'ADMN',15,'ITCO',1,'2018-12-17 22:30:09',1,'2018-12-17 22:30:09',0),(94,92,14,'ADMN',15,'ITCO',1,'2018-12-17 22:53:53',1,'2018-12-17 22:53:53',0),(95,93,14,'ADMN',15,'ITCO',1,'2018-12-17 23:00:39',1,'2018-12-17 23:00:39',0),(96,94,14,'ADMN',15,'ITCO',1,'2018-12-17 23:01:40',1,'2018-12-17 23:01:40',0),(97,95,14,'ADMN',15,'ITCO',1,'2018-12-17 23:02:16',1,'2018-12-17 23:02:16',0),(98,96,14,'ADMN',15,'ITCO',1,'2018-12-18 12:25:38',1,'2018-12-18 12:25:38',0),(99,97,14,'ADMN',15,'ITCO',1,'2018-12-18 15:19:07',1,'2018-12-18 15:19:07',0),(100,98,14,'ADMN',15,'ITCO',1,'2018-12-18 15:27:38',1,'2018-12-18 15:27:38',0),(101,99,14,'ADMN',15,'ITCO',1,'2018-12-18 15:41:29',1,'2018-12-18 15:41:29',0),(102,100,14,'ADMN',15,'ITCO',1,'2018-12-18 15:59:24',1,'2018-12-18 15:59:24',0),(103,101,14,'ADMN',15,'ITCO',1,'2018-12-21 13:14:33',1,'2018-12-21 13:14:33',0);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_announcement`
--

DROP TABLE IF EXISTS `tran_announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_announcement` (
  `ANNOUNCEMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `ANNOUNCEMENT_TITLE` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `ANNOUNCEMENT_HTML` mediumtext COLLATE utf8_unicode_ci,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`ANNOUNCEMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_announcement`
--

LOCK TABLES `tran_announcement` WRITE;
/*!40000 ALTER TABLE `tran_announcement` DISABLE KEYS */;
INSERT INTO `tran_announcement` VALUES (4,65,'Announcement: New Faculty Members Hired','<p>Dear Academy Colleagues, Trustees, Families, and Students,</p>\r\n<p>It is with great pleasure that I announce the hiring of new faculty members who will join our Academy family next year. The process of meeting, interviewing, and vetting the candidates has been a wonderful one which involved current and rising administrators, current faculty, and students. These new faculty members will bring their own vibrancy to our small school, and have been attracted to The Academy by our rigorous and balanced academics, our commitment to the visual and performing arts, and our strong community.</p>\r\n<p>Elizabeth Falco will be joining us as a Humanities teacher. Ms. Falco comes to us via Greenfield High School where she taught English. She is a graduate of the Williston Northampton School and earned her B.A., in English from the University of Denver and her M. Ed. From the University of Massachusetts.&nbsp; Ms. Falco has also taught in the Boston public school district and has worked as a journalist for several newspapers and websites. Her passion for history and journalism will find a welcome home at The Academy.</p>\r\n<p>Sarah Goodreault will join the Math faculty.&nbsp; Ms. Goodreault comes to The Academy from Hampden Charter School of Science in Chicopee. She earned her B.S. in Mathematics as well as her M. Ed. From the University of New Hampshire, and has taught math in several schools in that state.&nbsp; Ms. Goodreault worked as a residential advisor for UNH Upward Bound and has interests in a capella and outdoor sports.</p>\r\n<p>Andrae Green will become our permanent Art teacher.&nbsp; Mr. Green has worked at The Academy for the last two years as a Studio Block teacher and took over as Art teacher this past semester on an interim basis. He is a highly accomplished artist in his own right (see the last issue of&nbsp;<em>Vox</em>&nbsp;for an article about his career and achievements), and his acclimation to teaching full-time at The Academy has opened doors for his students. Originally from Jamaica, Mr. Green attended the Edna Manley College for the Visual and Performing Arts in Kingston, and earned his M.F.A. at the New York Academy of Art in New York City.</p>\r\n<p>Jamison Isler will also join the Humanities faculty.&nbsp; Mr. Isler comes to The Academy from Amherst Regional Middle School where he has taught 7th and 8th grade English for the past 10 years. Before that he had several postings as a teacher of English in middle and high schools in Georgia and Oregon. He has a B.A. in African and African-American Studies from Emory University and earned his M.Ed. in English from the University of North Carolina, Chapel Hill.&nbsp; Mr. Isler also participated in the highly regarded&nbsp;Western Massachusetts Writing Project Summer Institute.</p>\r\n<p>These talented new teachers look forward to becoming part of our community and working with our students.&nbsp; We are delighted to welcome them to The Academy.</p>\r\n<p>Please feel free to contact me with any questions.</p>\r\n<p>Regards,</p>\r\n<p>Glen Olson<br />Head of School</p>',65,'2018-07-17 11:21:12',2,'2018-07-17 11:35:24',0);
/*!40000 ALTER TABLE `tran_announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_class`
--

DROP TABLE IF EXISTS `tran_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_class` (
  `CLASS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLASS_NAME` varchar(100) DEFAULT NULL,
  `DESCRIPTION` mediumtext,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`CLASS_ID`),
  UNIQUE KEY `CATEGORY` (`CLASS_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_class`
--

LOCK TABLES `tran_class` WRITE;
/*!40000 ALTER TABLE `tran_class` DISABLE KEYS */;
INSERT INTO `tran_class` VALUES (1,'World Literature','World literature is sometimes used to refer to the sum total of the world\'s national literature, but usually, it refers to the circulation of works into the wider world beyond their country of origin. Often used in the past primarily for masterpieces of Western European literature, world literature today is increasingly seen in global context. Readers today have access to an unprecedented range of works from around the world in excellent translations, and since the mid-1990s a lively debate has grown up concerning both the aesthetic and the political values and limitations of an emphasis on global processes over national traditions.',2,'2018-06-10 15:45:20',2,'2018-06-10 15:45:20',0),(2,'European Literature','European literature refers to the literature of Europe.\r\nEuropean literature includes literature in many languages; among the most important of the modern written works are those in English, Spanish, French, Dutch, Polish, German, Italian, Modern Greek, Czech, Russian, Bosnian and works by the Scandinavians and Irish.\r\nImportant classical and medieval traditions are those in Latin, Ancient Greek, Old Norse, Medieval French and the Italian Tuscan dialect of the renaissance.\r\nIn colloquial speech, European literature often is used as a synonym for Western literature.\r\nEuropean literature is a part of world literature. ',2,'2018-06-10 15:50:21',2,'2018-06-10 15:50:21',0),(3,'English Language','English is a West Germanic language that was first spoken in early medieval England and is now a global lingua franca. Named after the Angles, one of the Germanic tribes that migrated to England, it ultimately derives its name from the Anglia (Angeln) peninsula in the Baltic Sea. It is closely related to the Frisian languages, but its vocabulary has been significantly influenced by other Germanic languages, particularly Norse (a North Germanic language), as well as by Latin and French.',2,'2018-06-10 16:00:33',2,'2018-06-10 16:00:33',0),(4,'English Literature','This article is focused on English-language literature rather than the literature of England, so that it includes writers from Scotland, Wales, and the whole of Ireland, as well as literature in English from countries of the former British Empire, including the United States. However, until the early 19th century, it only deals with the literature of the United Kingdom and Ireland. It does not include literature written in the other languages of Britain.',2,'2018-06-10 16:35:55',2,'2018-06-10 16:35:55',0),(5,'World History','World history or global history (not to be confused with diplomatic, transnational or international history) is a field of historical study that emerged as a distinct academic field in the 1980s. It examines history from a global perspective. It is not to be confused with comparative history, which, like world history, deals with the history of multiple cultures and nations, but does not do so on a global scale. World history looks for common patterns that emerge across all cultures. World historians use a thematic approach, with two major focal points: integration (how processes of world history have drawn people of the world together) and difference (how patterns of world history reveal the diversity of the human experiences)',2,'2018-06-10 16:39:19',2,'2018-06-10 16:39:19',0),(6,'Human Geography','Human geography is the branch of geography that deals with the study of people and their communities, cultures, economies, and interactions with the environment by studying their relations with and across space and place. Human geography attends to human patterns of social interaction, as well as spatial level interdependencies, and how they influence or affect the earth\'s environment. As an intellectual discipline, geography is divided into the sub-fields of physical geography and human geography, the latter concentrating upon the study of human activities, by the application of qualitative and quantitative research methods.',2,'2018-06-10 16:44:11',2,'2018-06-10 16:44:11',0),(7,'Psychology','Psychology is the science of behavior and mind, including conscious and unconscious phenomena, as well as feeling and thought. It is an academic discipline of immense scope and diverse interests that, when taken together, seek an understanding of the emergent properties of brains, and all the variety of epiphenomena they manifest. As a social science, it aims to understand individuals and groups by establishing general principles and researching specific cases.',2,'2018-06-10 16:46:49',2,'2018-06-10 16:46:49',0),(8,'U.S. History','The history of the United States began with the settlement of Indigenous people before 10,000 BC. Numerous cultures formed. The arrival of Christopher Columbus in 1492 started the European colonization of the Americas. Most colonies formed after 1600. By the 1770s, thirteen British colonies contained 2.5 million people along the Atlantic coast east of the Appalachian Mountains. After defeating France, the British government imposed a series of new taxes after 1765, rejecting the colonists\' argument that new taxes needed their approval (see Stamp Act 1765). Tax resistance, especially the Boston Tea Party (1773), led to punitive laws by Parliament designed to end self-government in Massachusetts.',2,'2018-06-10 16:48:45',2,'2018-06-10 16:48:45',0),(9,'Chemistry','Chemistry is the scientific discipline involved with compounds composed of atoms, i.e. elements, and molecules, i.e. combinations of atoms: their composition, structure, properties, behavior and the changes they undergo during a reaction with other compounds. Chemistry addresses topics such as how atoms and molecules interact via chemical bonds to form new chemical compounds. There are four types of chemical bonds: covalent bonds, in which compounds share one or more electron(s); ionic bonds, in which a compound donates one or more electrons to another compound to produce ions (cations and anions); hydrogen bonds; and Van der Waals force bonds.',2,'2018-06-10 16:52:48',2,'2018-06-10 16:52:48',0),(10,'Biology','Biology is the natural science that studies life and living organisms, including their physical structure, chemical composition, function, development and evolution. Despite the complexity of the science, there are certain unifying concepts that consolidate it into a single, coherent field. Biology recognizes the cell as the basic unit of life, genes as the basic unit of heredity, and evolution as the engine that propels the creation and extinction of species. Living organisms are open systems that survive by transforming energy and decreasing their local entropy to maintain a stable and vital condition defined as homeostasis.',2,'2018-06-10 16:57:18',2,'2018-06-10 16:57:18',0),(11,'Anatomy','Anatomy (Greek  “dissection”) is the branch of biology concerned with the study of the structure of organisms and their parts. Anatomy is a branch of natural science dealing with the structural organization of living things. It is an old science, having its beginnings in prehistoric times. Anatomy is inherently tied to embryology, comparative anatomy, evolutionary biology, and phylogeny, as these are the processes by which anatomy is generated over immediate (embryology) and long (evolution) timescales. Human anatomy is one of the basic essential sciences of medicine. Anatomy and physiology, which study (respectively) the structure and function of organisms and their parts, make a natural pair of related disciplines, and they are often studied together.',2,'2018-06-10 17:10:19',2,'2018-06-10 17:10:19',0),(12,'Physiology','Physiology is the scientific study of normal mechanisms, and their interactions, which work within a living system. A sub-discipline of biology, its focus is in how organisms, organ systems, organs, cells, and bio-molecules carry out the chemical or physical functions that exist in a living system. Given the size of the field, it is divided into, among others, animal physiology (including that of humans), plant physiology, cellular physiology, microbial physiology (microbial metabolism), bacterial physiology, and viral physiology.',2,'2018-06-10 17:16:17',2,'2018-06-10 17:16:17',0),(13,'Physics','Physics, transit, lit. \'knowledge of nature\' is the natural science that studies the matter and its motion and behavior through space and time and that studies the related entities of energy and force. Physics is one of the most fundamental scientific disciplines, and its main goal is to understand how the universe behaves.',2,'2018-06-10 17:21:21',2,'2018-06-10 17:21:21',0),(14,'Algebra','Algebra is one of the broad parts of mathematics, together with number theory, geometry and analysis. In its most general form, algebra is the study of mathematical symbols and the rules for manipulating these symbols. it is a unifying thread of almost all of mathematics. As such, it includes everything from elementary equation solving to the study of abstractions such as groups, rings, and fields. The more basic parts of algebra are called elementary algebra; the more abstract parts are called abstract algebra or modern algebra. Elementary algebra is generally considered to be essential for any study of mathematics, science, or engineering, as well as such applications as medicine and economics. Abstract algebra is a major area in advanced mathematics, studied primarily by professional mathematicians.',2,'2018-06-10 17:28:38',2,'2018-06-10 17:28:38',0),(15,'Geometry','Geometry is a branch of mathematics concerned with questions of shape, size, the relative position of figures, and the properties of space. A mathematician who works in the field of geometry is called a geometer.',2,'2018-06-10 17:30:11',2,'2018-06-10 17:30:11',0),(16,'Calculus','Calculus (from Latin calculus, literally \'small pebble\', used for counting and calculations, as on an abacus), is the mathematical study of continuous change, in the same way, that geometry is the study of shape and algebra is the study of generalizations of arithmetic operations.',2,'2018-06-10 17:33:31',2,'2018-06-10 17:33:31',0),(17,'Statistics','Statistics is a branch of mathematics dealing with the collection, analysis, interpretation, presentation, and organization of data. In applying statistics to, for example, a scientific, industrial, or social problem, it is conventional to begin with a statistical population or a statistical model process to be studied. Populations can be diverse topics such as \"all people living in a country\" or \"every atom composing a crystal\". Statistics deals with all aspects of data including the planning of data collection in terms of the design of surveys and experiments. See glossary of probability and statistics.',2,'2018-06-10 17:37:04',2,'2018-06-10 17:37:04',0),(18,'French','French is a Romance language of the Indo-European family. It descended from the Vulgar Latin of the Roman Empire, as did all Romance languages. French has evolved from Gallo-Romance, spoken Latin in Gaul, and more specifically in Northern Gaul. Its closest relatives are the other languages d\'oïl—languages historically spoken in northern France and in southern Belgium, which French (Francien) has largely supplanted. French was also influenced by native Celtic languages of Northern Roman Gaul like Gallia Belgica and by the (Germanic) Frankish language of the post-Roman Frankish invaders. Today, owing to France\'s past overseas expansion, there are numerous French-based creole languages, most notably Haitian Creole. A French-speaking person or nation may be referred to as Francophone in both English and French.',2,'2018-06-10 17:54:54',2,'2018-06-10 17:54:54',0),(19,'Latin','Latin is a classical language belonging to the Italic branch of the Indo-European languages. The Latin alphabet is derived from the Etruscan and Greek alphabets, and ultimately from the Phoenician alphabet.',2,'2018-06-10 17:57:58',2,'2018-06-10 17:57:58',0),(20,'Spanish','Spanish is a Western Romance language that originated in the Castile region of Spain and today has hundreds of millions of native speakers in Latin America and Spain. It is usually considered the world\'s second-most spoken native language, after Mandarin Chinese.',2,'2018-06-10 18:01:59',2,'2018-06-10 18:01:59',0),(21,'Fine Arts','In European academic traditions, fine art is art developed primarily for aesthetics or beauty, distinguishing it from applied art, which also has to serve some practical function, such as pottery or most metalwork.',2,'2018-06-10 18:22:31',2,'2018-06-10 18:22:31',0),(23,'Physical Education','Physical Education',2,'2018-12-02 13:39:58',2,'2018-12-02 13:39:58',0);
/*!40000 ALTER TABLE `tran_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_comment`
--

DROP TABLE IF EXISTS `tran_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_comment` (
  `COMMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMENT_HTML` varchar(2000) COLLATE utf8_unicode_ci NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_VALUE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SUBSYSTEM_REFERENCE_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`COMMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_comment`
--

LOCK TABLES `tran_comment` WRITE;
/*!40000 ALTER TABLE `tran_comment` DISABLE KEYS */;
INSERT INTO `tran_comment` VALUES (1,'that just pulled everybody together',2,10,'QUES',19,2,'2018-11-25 09:27:55',2,'2018-11-25 09:27:55',0),(2,'this is a testing comment',2,10,'QUES',20,2,'2018-12-24 10:38:51',2,'2018-12-24 10:38:51',0);
/*!40000 ALTER TABLE `tran_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_feedback`
--

DROP TABLE IF EXISTS `tran_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_feedback` (
  `FEEDBACK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `FEEDBACK` varchar(500) NOT NULL,
  `IS_VERIFIED` varchar(10) DEFAULT NULL,
  `VALUE` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`FEEDBACK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_feedback`
--

LOCK TABLES `tran_feedback` WRITE;
/*!40000 ALTER TABLE `tran_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_notification`
--

DROP TABLE IF EXISTS `tran_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_notification` (
  `NOTIFICATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FROM_USER_ID` int(11) DEFAULT NULL,
  `TO_USER_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_VALUE` varchar(50) DEFAULT NULL,
  `SUBSYSTEM_REFERENCE_ID` int(11) DEFAULT NULL,
  `POINT_ID` int(11) DEFAULT NULL,
  `MESSAGE_ID` int(11) DEFAULT NULL,
  `IS_READ` varchar(5) DEFAULT NULL,
  `IS_EMAIL` varchar(5) DEFAULT NULL,
  `EMAIL_SENT_DATE` datetime DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`NOTIFICATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_notification`
--

LOCK TABLES `tran_notification` WRITE;
/*!40000 ALTER TABLE `tran_notification` DISABLE KEYS */;
INSERT INTO `tran_notification` VALUES (2,34,73,11,'ASKQ',3,0,0,'N','N',NULL,34,'2018-06-23 15:14:35',34,'2018-06-23 15:14:35',0),(3,35,74,11,'ASKQ',4,0,0,'N','N',NULL,35,'2018-06-23 15:23:50',35,'2018-06-23 15:23:50',0),(4,35,65,11,'ASKQ',5,0,0,'Y','N',NULL,35,'2018-06-23 15:25:29',35,'2018-06-23 15:25:29',0),(5,61,66,11,'ASKQ',6,0,0,'Y','N',NULL,61,'2018-06-23 15:30:03',61,'2018-06-23 15:30:03',0),(6,57,80,11,'ASKQ',10,0,0,'Y','N',NULL,57,'2018-06-24 20:35:35',57,'2018-06-24 20:35:35',0),(7,23,77,11,'ASKQ',13,0,0,'N','N',NULL,23,'2018-06-24 21:41:40',23,'2018-06-24 21:41:40',0),(8,65,35,11,'ANSR',1,0,0,'N','N',NULL,65,'2018-06-26 15:45:05',65,'2018-06-26 15:45:05',0),(9,80,57,11,'ANSR',3,0,0,'Y','N',NULL,80,'2018-06-26 15:56:24',80,'2018-06-26 15:56:24',0),(10,80,57,11,'UPVQ',10,0,0,'Y','N',NULL,80,'2018-06-26 15:56:53',80,'2018-06-26 15:56:53',0),(11,80,76,11,'UPVQ',12,0,0,'N','N',NULL,80,'2018-06-26 16:11:16',80,'2018-06-26 16:11:16',0),(12,80,76,11,'UPVA',2,0,0,'N','N',NULL,80,'2018-06-26 16:11:20',80,'2018-06-26 16:11:20',0),(13,66,61,11,'ANSR',4,0,0,'Y','N',NULL,66,'2018-06-26 16:19:15',66,'2018-06-26 16:19:15',0),(17,64,23,11,'ANSR',8,0,0,'N','N',NULL,64,'2018-07-10 17:29:08',64,'2018-07-10 17:29:08',0),(19,2,56,11,'ANSR',10,0,0,'N','N',NULL,2,'2018-07-10 17:32:20',2,'2018-07-10 17:32:20',0),(20,2,34,11,'ANSR',11,0,0,'N','N',NULL,2,'2018-07-10 17:35:54',2,'2018-07-10 17:35:54',0),(21,2,13,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(22,2,20,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(23,2,22,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(24,2,33,11,'ASKQ',19,0,0,'Y','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(25,2,35,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(26,2,44,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(27,2,48,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(28,2,50,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(29,2,62,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(30,2,12,11,'ASKQ',19,0,0,'Y','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(31,2,13,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(32,2,14,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(33,2,15,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(34,2,16,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(35,2,17,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(36,2,33,11,'ASKQ',19,0,0,'Y','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(37,2,34,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(38,2,35,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(39,2,36,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(40,2,37,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(41,2,38,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(42,2,39,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(43,2,29,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(44,2,30,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(45,2,31,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(46,2,32,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(47,2,56,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(48,2,57,11,'ASKQ',19,0,0,'Y','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(49,2,58,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(50,2,59,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(51,2,60,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(52,2,61,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(53,2,62,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(54,2,51,11,'ASKQ',19,0,0,'N','N',NULL,2,'2018-08-09 14:26:46',2,'2018-08-09 14:26:46',0),(55,2,13,11,'ASKQ',20,0,0,'N','N',NULL,2,'2018-08-09 14:36:26',2,'2018-08-09 14:36:26',0),(56,2,20,11,'ASKQ',20,0,0,'N','N',NULL,2,'2018-08-09 14:36:57',2,'2018-08-09 14:36:57',0),(57,2,13,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(58,2,20,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(59,2,22,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(60,2,33,11,'ASKQ',15,0,0,'Y','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(61,2,35,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(62,2,44,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(63,2,48,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(64,2,50,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(65,2,62,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(66,2,12,11,'ASKQ',15,0,0,'Y','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(67,2,14,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(68,2,15,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(69,2,16,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(70,2,17,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(71,2,34,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(72,2,36,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(73,2,37,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(74,2,38,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(75,2,39,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(76,2,29,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(77,2,30,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(78,2,31,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(79,2,32,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(80,2,56,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(81,2,57,11,'ASKQ',15,0,0,'Y','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(82,2,58,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(83,2,59,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(84,2,60,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(85,2,61,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(86,2,18,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(87,2,19,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(88,2,21,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(89,2,23,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(90,2,40,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(91,2,41,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(92,2,42,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(93,2,43,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(94,2,45,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(95,2,46,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(96,2,47,11,'ASKQ',15,0,0,'N','N',NULL,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(97,2,16,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(98,2,12,11,'MNQU',16,0,0,'Y','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(99,2,13,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(100,2,14,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(101,2,15,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(102,2,17,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(103,2,33,11,'MNQU',16,0,0,'Y','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(104,2,34,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(105,2,35,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(106,2,36,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(107,2,37,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(108,2,38,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(109,2,39,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(110,2,29,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(111,2,30,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(112,2,31,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(113,2,32,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(114,2,56,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(115,2,57,11,'MNQU',16,0,0,'Y','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(116,2,58,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(117,2,59,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(118,2,60,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(119,2,61,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(120,2,62,11,'MNQU',16,0,0,'N','N',NULL,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(121,2,29,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(122,2,30,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(123,2,31,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(124,2,32,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(125,2,56,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(126,2,57,11,'MNAN',7,0,0,'Y','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(127,2,58,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(128,2,59,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(129,2,60,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(130,2,61,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(131,2,62,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(132,2,16,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(133,2,12,11,'MNAN',7,0,0,'Y','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(134,2,13,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(135,2,14,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(136,2,15,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(137,2,17,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(138,2,33,11,'MNAN',7,0,0,'Y','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(139,2,34,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(140,2,35,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(141,2,36,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(142,2,37,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(143,2,38,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(144,2,39,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(145,2,18,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(146,2,19,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(147,2,20,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(148,2,21,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(149,2,22,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(150,2,23,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(151,2,40,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(152,2,41,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(153,2,42,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(154,2,43,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(155,2,44,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(156,2,45,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(157,2,46,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(158,2,47,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(159,2,24,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(160,2,25,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(161,2,26,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(162,2,27,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(163,2,28,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(164,2,48,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(165,2,49,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(166,2,50,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(167,2,51,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(168,2,52,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(169,2,53,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(170,2,54,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(171,2,55,11,'MNAN',7,0,0,'N','N',NULL,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(172,2,12,11,'MNQU',17,0,0,'Y','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(173,2,13,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(174,2,14,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(175,2,15,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(176,2,16,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(177,2,17,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(178,2,33,11,'MNQU',17,0,0,'Y','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(179,2,34,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(180,2,35,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(181,2,36,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(182,2,37,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(183,2,38,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(184,2,39,11,'MNQU',17,0,0,'N','N',NULL,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(185,33,63,11,'MNAN',8,0,0,'Y','N',NULL,33,'2018-08-11 13:52:21',33,'2018-08-11 13:52:21',0),(186,2,13,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(187,2,20,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(188,2,22,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(189,2,33,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(190,2,35,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(191,2,44,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(192,2,48,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(193,2,50,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(194,2,62,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(195,2,12,11,'MNQU',18,0,0,'Y','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(196,2,14,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(197,2,15,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(198,2,16,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(199,2,17,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(200,2,34,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(201,2,36,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(202,2,37,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(203,2,38,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(204,2,39,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(205,2,24,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(206,2,25,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(207,2,26,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(208,2,27,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(209,2,28,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(210,2,49,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(211,2,51,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(212,2,52,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(213,2,53,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(214,2,54,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(215,2,55,11,'MNQU',18,0,0,'N','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(216,2,63,11,'MNQU',18,0,0,'Y','N',NULL,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(217,2,13,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(218,2,20,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(219,2,22,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(220,2,33,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(221,2,35,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(222,2,44,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(223,2,48,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(224,2,50,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(225,2,62,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(226,2,51,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(227,2,12,11,'MNQU',19,0,0,'Y','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(228,2,29,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(229,2,30,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(230,2,31,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(231,2,32,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(232,2,56,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(233,2,57,11,'MNQU',19,0,0,'Y','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(234,2,58,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(235,2,59,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(236,2,60,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(237,2,61,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(238,2,16,11,'MNQU',19,0,0,'N','N',NULL,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(239,63,2,11,'ANSR',14,0,0,'Y','N',NULL,63,'2018-08-15 13:05:55',63,'2018-08-15 13:05:55',0),(240,2,16,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(241,2,13,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(242,2,20,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(243,2,22,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(244,2,33,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(245,2,35,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(246,2,44,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(247,2,48,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(248,2,50,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(249,2,62,11,'MNAN',9,0,0,'N','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(250,2,12,11,'MNAN',9,0,0,'Y','N',NULL,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(251,57,2,11,'UPVQ',21,0,0,'Y','N',NULL,57,'2018-11-21 11:23:59',57,'2018-11-21 11:23:59',0),(252,57,2,11,'UPVQ',19,0,0,'Y','N',NULL,57,'2018-11-21 11:28:29',57,'2018-11-21 11:28:29',0),(260,2,47,11,'DNVA',13,0,0,'N','N',NULL,2,'2018-11-24 13:14:10',2,'2018-11-24 13:14:10',0),(261,2,47,11,'UPVQ',14,0,0,'N','N',NULL,2,'2018-11-24 13:14:57',2,'2018-11-24 13:14:57',0),(264,2,13,11,'MNQU',20,0,0,'N','N',NULL,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(265,2,12,11,'MNQU',20,0,0,'Y','N',NULL,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(266,2,31,11,'MNQU',20,0,0,'N','N',NULL,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(267,2,46,11,'MNQU',20,0,0,'N','N',NULL,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(268,2,52,11,'MNQU',20,0,0,'N','N',NULL,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(269,2,78,11,'MNQU',20,0,0,'N','N',NULL,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(270,2,67,11,'MNQU',20,0,0,'N','N',NULL,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(271,2,23,11,'UPVQ',13,0,0,'N','N',NULL,2,'2018-12-24 10:39:42',2,'2018-12-24 10:39:42',0),(272,2,64,11,'UPVA',8,0,0,'N','N',NULL,2,'2018-12-24 10:39:47',2,'2018-12-24 10:39:47',0);
/*!40000 ALTER TABLE `tran_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_point`
--

DROP TABLE IF EXISTS `tran_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_point` (
  `POINT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_VALUE` varchar(10) DEFAULT NULL,
  `SUBSYSTEM_REFERENCE_ID` int(11) DEFAULT NULL,
  `POINTS_TYPE_ID` int(11) DEFAULT NULL,
  `POINTS_TYPE_VALUE` varchar(10) DEFAULT NULL,
  `POINTS` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`POINT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_point`
--

LOCK TABLES `tran_point` WRITE;
/*!40000 ALTER TABLE `tran_point` DISABLE KEYS */;
INSERT INTO `tran_point` VALUES (1,10,57,11,'UPVQ',10,12,'VOTE',5,80,'2018-06-26 15:56:53',80,'2018-06-26 15:56:53',0),(2,12,76,11,'UPVQ',12,12,'VOTE',5,80,'2018-06-26 16:11:16',80,'2018-06-26 16:11:16',0),(3,12,76,11,'UPVA',2,12,'VOTE',5,80,'2018-06-26 16:11:20',80,'2018-06-26 16:11:20',0),(4,21,2,11,'UPVQ',21,12,'VOTE',5,57,'2018-11-21 11:23:59',57,'2018-11-21 11:23:59',0),(5,19,2,11,'UPVQ',19,12,'VOTE',5,57,'2018-11-21 11:28:29',57,'2018-11-21 11:28:29',0),(13,14,47,11,'DNVA',13,12,'VOTE',-3,2,'2018-11-24 13:14:10',2,'2018-11-24 13:14:10',0),(14,14,47,11,'UPVQ',14,12,'VOTE',5,2,'2018-11-24 13:14:57',2,'2018-11-24 13:14:57',0),(17,13,23,11,'UPVQ',13,12,'VOTE',5,2,'2018-12-24 10:39:42',2,'2018-12-24 10:39:42',0),(18,13,64,11,'UPVA',8,12,'VOTE',5,2,'2018-12-24 10:39:47',2,'2018-12-24 10:39:47',0);
/*!40000 ALTER TABLE `tran_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_post_vote`
--

DROP TABLE IF EXISTS `tran_post_vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_post_vote` (
  `POST_VOTE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) DEFAULT NULL,
  `VOTE_ID` int(11) DEFAULT NULL,
  `VOTE_VALUE` varchar(50) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_VALUE` varchar(50) DEFAULT NULL,
  `SUBSYSTEM_REFERENCE_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  `SUBYSTEM_VALUE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`POST_VOTE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_post_vote`
--

LOCK TABLES `tran_post_vote` WRITE;
/*!40000 ALTER TABLE `tran_post_vote` DISABLE KEYS */;
INSERT INTO `tran_post_vote` VALUES (2,12,9,'UPVT',80,10,'QUES',12,80,'2018-06-26 16:11:16',80,'2018-06-26 16:11:16',0,NULL),(3,12,9,'UPVT',80,10,'ANSR',2,80,'2018-06-26 16:11:20',80,'2018-06-26 16:11:20',0,NULL),(5,19,9,'UPVT',57,10,'QUES',19,57,'2018-11-21 11:28:29',57,'2018-11-21 11:28:29',0,NULL),(14,14,9,'DNVT',2,10,'ANSR',13,2,'2018-11-24 13:14:10',2,'2018-11-24 13:14:10',0,NULL),(15,14,9,'UPVT',2,10,'QUES',14,2,'2018-11-24 13:14:57',2,'2018-11-24 13:14:57',0,NULL),(18,13,9,'UPVT',2,10,'QUES',13,2,'2018-12-24 10:39:42',2,'2018-12-24 10:39:42',0,NULL),(19,13,9,'UPVT',2,10,'ANSR',8,2,'2018-12-24 10:39:47',2,'2018-12-24 10:39:47',0,NULL);
/*!40000 ALTER TABLE `tran_post_vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question`
--

DROP TABLE IF EXISTS `tran_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question` (
  `QUESTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_TITLE` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `QUESTION_HTML` mediumtext COLLATE utf8_unicode_ci,
  `THREAD_ID` int(11) DEFAULT NULL,
  `IS_VALID` tinyint(1) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question`
--

LOCK TABLES `tran_question` WRITE;
/*!40000 ALTER TABLE `tran_question` DISABLE KEYS */;
INSERT INTO `tran_question` VALUES (3,'Which books should I read for my Advanced Physics class? ',NULL,1,0,34,'2018-06-23 15:14:35',34,'2018-06-23 15:14:35',0),(4,'How should I prepare for spring 2018 Algebra tests?',NULL,1,0,35,'2018-06-23 15:23:50',35,'2018-06-23 15:23:50',0),(5,'Which books should I read on English Literature this Summer?',NULL,1,0,35,'2018-06-23 15:25:29',35,'2018-06-24 14:11:31',0),(6,'What is the difference between Freemasons and Illuminati?',NULL,1,0,61,'2018-06-23 15:30:03',61,'2018-06-23 15:30:03',0),(9,'How can we have some Computer science related classes in school?',NULL,1,0,56,'2018-06-24 20:20:08',56,'2018-06-24 20:20:08',0),(12,'How to improve Calculus skills in High School?',NULL,1,0,76,'2018-06-24 21:18:07',76,'2018-06-24 21:18:07',0),(13,'How much should I score to get extra credits in Statistics class?',NULL,1,0,23,'2018-06-24 21:41:40',23,'2018-06-24 21:41:40',0),(14,'Are there any good videos online for understanding basics of drawing?',NULL,1,0,47,'2018-07-12 02:29:07',2,'2018-11-27 15:50:59',0),(19,'WHO WAS THE FIRST KING OF INDIA','<p>It is with great pleasure that I announce the hiring of new faculty members who will join our Academy family next year. The process of meeting, interviewing, and vetting the candidates has been a wonderful one which involved current and rising administrators, current faculty, and students. These new faculty members will bring their own vibrancy to our small school, and have been attracted to The Academy by our rigorous and balanced academics, our commitment to the visual and performing arts, and our strong community.</p>\r\n<p>Elizabeth Falco will be joining us as a Humanities teacher. Ms. Falco comes to us via Greenfield High School where she taught English. She is a graduate of the Williston Northampton School and earned her B.A., in English from the University of Denver and her M. Ed. From the University of Massachusetts.&nbsp; Ms. Falco has also taught in the Boston public school district and has worked as a journalist for several newspapers and websites. Her passion for history and journalism will find a welcome home at The Academy.</p>',1,0,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(20,'I am just testing the new inheritance on the business objects?','<p>I am just testing the new inheritance on the business objects?I am just testing the new inheritance on the business objects?I am just testing the new inheritance on the business objects?I am just testing the new inheritance on the business objects?</p>',1,0,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0);
/*!40000 ALTER TABLE `tran_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_answer`
--

DROP TABLE IF EXISTS `tran_question_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_answer` (
  `QUESTION_ANSWER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `ANSWER_HTML` mediumtext COLLATE utf8_unicode_ci,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_ANSWER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_answer`
--

LOCK TABLES `tran_question_answer` WRITE;
/*!40000 ALTER TABLE `tran_question_answer` DISABLE KEYS */;
INSERT INTO `tran_question_answer` VALUES (1,5,'<p>I would suggest below list for a freshman. Animal farm is my favorite one. Give it a to this list and let me know how you like it.</p>\r\n<ul>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/1885.Pride_and_Prejudice\">Pride and Prejudice</a></li>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/10210.Jane_Eyre\">Jane Eyre </a></li>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/6185.Wuthering_Heights\">Wuthering Heights </a></li>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/7613.Animal_Farm\">Animal Farm</a></li>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/5297.The_Picture_of_Dorian_Gray\">The Picture of Dorian Gray</a></li>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/35031085-frankenstein\">Frankenstein</a></li>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/7624.Lord_of_the_Flies\">Lord of the Flies</a></li>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/18135.Romeo_and_Juliet\">Romeo and Juliet</a></li>\r\n<li><a class=\"bookTitle\" href=\"https://www.goodreads.com/book/show/5129.Brave_New_World\">Brave New World</a></li>\r\n</ul>\r\n<p>I am sharing this question with your classmates too.</p>',65,'2018-06-26 15:45:05',65,'2018-06-26 15:45:05',0),(2,12,'<div class=\"wikiDescription\">You can use this article to find out what you need to do to pass your calculus class. Get tips for what you should do before class, during class and to study for exams.</div>\r\n<div id=\"articleMain\" class=\"wikiContent \">\r\n<h2 id=\"section---ReadYourSyllabus\">Read Your Syllabus</h2>\r\n<p>It\'s going to be much harder for you to pass your calculus course if you don\'t know details about the class. Make sure you pay attention to the syllabus provided by your instructor, especially if it contains information on how you will be graded, the percentage of your grade each exam is worth and attendance policies. If you\'re in a class where you\'re penalized for a certain amount of missed classes, you\'ll want to keep that in mind.</p>\r\n<h2 id=\"section---GetReadyToStudy\">Get Ready to Study</h2>\r\n<p>Effectively studying calculus can take a lot of time. You should be prepared to devote several hours every week to studying for your class. Try to spread this study time out so that you\'re studying every day, and be sure to regularly practice formulas and theorems. This will keep you familiar with the concepts and computations you need to know to succeed in calculus.</p>\r\n<p>Make sure that you finish all of the homework assigned by your instructor. This will give you the practice you need to get ready for tests. It may also be graded, in which case you want to make sure you\'re correctly completing your work and turning everything in on time.</p>\r\n<h2 id=\"section---WorkWithOtherStudents\">Work with Other Students</h2>\r\n<p>You should try to make use of study groups if you can. Communicate with your fellow students about any problems you\'re having trouble with, or to discuss the different strategies for solving calculus problems.</p>\r\n<h2 id=\"section---GiveYourselfTime\">Give Yourself Time</h2>\r\n<p>Make sure you give yourself enough time to study for your exams. Trying to study everything the night before the exam probably isn\'t going to work on a course this advanced. Instead, try to spread out your exam preparations over 5-6 class days. This gives you plenty of time to focus on different topics.</p>\r\n<h2 id=\"section---CompletePracticeProblems\">Complete Practice Problems</h2>\r\n<p>The more calculus problems you solve, the better at calculus you\'ll be. Work on all the problems your instructor assigns, as well as the extra problems provided in your textbook. You can even find out if your instructor offers copies of old exams and work on those.</p>\r\n<h2 id=\"section---UseOnlineResources\">Use Online Resources</h2>\r\n<p>Study.com offers study guides that can help you review the information covered by your calculus class. These courses include easy-to-follow instructions for solving calculus problems. They also provide you with interactive quizzes that allow you to test your ability to solve these problems. Check out study guides for:</p>\r\n<ul>\r\n<li><a class=\"external\" href=\"https://study.com/academy/course/ap-calculus.html\">AP Calculus AB &amp; BC</a></li>\r\n<li><a class=\"external\" href=\"https://study.com/academy/course/calculus.html\">College Calculus</a></li>\r\n<li><a class=\"external\" href=\"https://study.com/academy/topic/calculus-flashcards.html\">Calculus Flashcards</a></li>\r\n</ul>\r\n</div>',76,'2018-06-26 15:50:38',76,'2018-06-26 15:50:38',0),(4,6,'<p class=\"ui_qtext_para\">To answer that question, you need to understand what the two terms mean.</p>\r\n<p class=\"ui_qtext_para\"><strong>Freemason</strong></p>\r\n<p class=\"ui_qtext_para\">Freemasons are organized groups of private members who meet regularly to practice various ceremonies (interactive morality plays rather than religious or mystical ceremonies). These are called Lodges and are themselves part of Grand Lodges.</p>\r\n<p class=\"ui_qtext_para\">These Lodges and Grand Lodges are well documented with much of that documentation available, even if it is not public. They are not secret societies.</p>\r\n<p class=\"ui_qtext_para\"><strong>Illuminati</strong></p>\r\n<p class=\"ui_qtext_para\">This is much harder to define.</p>\r\n<p class=\"ui_qtext_para\">There was a secret society in 18th Century Bavaria by this name, but almost certainly extinct long since. It owed some of its ritual to Freemasonry, but that&rsquo;s the extent of the link.</p>\r\n<p class=\"ui_qtext_para\">However, when people in the 21st Century refer to the Illuminati, they generally refer to the conspiracy theory of a secret global organization that exerts clandestine control over politics and finance.</p>\r\n<p class=\"ui_qtext_para\">Personally, I believe this is simply a paranoid delusion, but do you seriously expect to get a definitive answer on Quora?</p>\r\n<p class=\"ui_qtext_para\">Finally, Illuminati literally means &lsquo;those who are enlightened&rsquo; so can refer to individuals who have achieved some kind of spiritual enlightenment, the kind Buddhists, yogi and other religious and mystics have sought for centuries.</p>\r\n<p class=\"ui_qtext_para\">In this sense, do we rub shoulders with Illuminati every day?</p>\r\n<p class=\"ui_qtext_para\">Shouldn&rsquo;t we all aspire to join the Illuminati?</p>',66,'2018-06-26 16:19:15',66,'2018-06-26 16:19:15',0),(8,13,'<p>There are three ways to give extra credit :</p>\r\n<p>Include scores for extra credit problems for an assignment.&nbsp;&nbsp;When added to the assignment score, total points scored may be greater than the possible points, resulting in a Total score greater than 100%.</p>\r\n<p><img src=\"https://www.teacherease.com/help/instrsec/hmfile_hash_3b2cee0b.png\" alt=\"extra credit 1\" width=\"577\" height=\"205\" /></p>\r\n<p>Points Scored = 10 +&nbsp;13&nbsp;+ 18 = 41<br />Total Possible = 10 +&nbsp;10&nbsp;+ 20 = 40<br />Total Average = Points Scored / Points Possible = 41 / 40 = 102.5%</p>\r\n<p>comment below if you have more questions.</p>',64,'2018-07-10 17:29:08',64,'2018-07-10 17:29:08',0),(10,9,'<p>The Association for Computing Machinery, Code.org, Computer Science Teachers Association, Cyber Innovation Center, and National Math and Science Initiative have collaborated with states, districts, and the computer science education community to develop conceptual guidelines for computer science education.<br />The K&ndash;12 Computer Science Framework comes at a time when our nation&rsquo;s education systems are adapting to a 21st century vision of students who are not just computer users but also computationally literate creators who are proficient in the concepts and practices of computer science. States, districts, and organizations can use the framework to inform the development of standards and curriculum, build capacity for teaching computer science, and implement computer science pathways.<br />The framework is designed to guide computer science from a subject for the fortunate few to an opportunity for all.</p>',2,'2018-07-10 17:32:20',2,'2018-07-10 17:32:20',0),(11,3,'<h2>Historical &amp; Casual Reads</h2>\r\n<ul>\r\n<li><strong>Great Physicists</strong>&nbsp;-&nbsp;<em>William H. Cropper</em></li>\r\n</ul>\r\n<p>I love this book. I take it to uni with me every term as it\'s great to just dip into. It covers nearly every possible area of physics in surprising detail. It even gives explanations of some advanced mathematical topics such as vector calculus. It\'s set out as a biography of around 30 key physicists, arranged by area of physics and discussing in depth the lives of these greats and the detail behind what they discovered. I highly recommend this one as an excellent mixture of physics and background interest.</p>\r\n<p>&nbsp;</p>\r\n<ul>\r\n<li><strong>Surely You\'re Joking Mr Feynman?</strong>&nbsp;-&nbsp;<em>Richard Feynman</em></li>\r\n</ul>\r\n<p>First things first, this book has little or nothing to do with physics and I believe you could quite easily read this with a GCSE knowledge of physics. This is not a book on physics, but a collection of extracts and anecdotes from one of the greats (and certainly one of the great characters), Richard Feynman. I love this book, the style is witty and it gives a real insight into the mind of a great man. He got up to a surprising amount, from safe cracking at Los Alamos to painting to time out in Brazil. Don\'t kid yourself that you\'ll gain physics knowledge from it, but as a stand alone entertaining read it\'s an awesome read.</p>\r\n<p>&nbsp;</p>\r\n<ul>\r\n<li><strong>The Pleasure of Finding Things Out</strong>&nbsp;-&nbsp;<em>Richard Feynman</em></li>\r\n</ul>\r\n<p>A book along the lines of \"Surely You\'re Joking\", but this time instead of being a compilation of conversations the great Feynman had with his friend Ralph Leighton, the book consists of talks and interviews that Feynman did during his life. From the famous television interview that the book took its name from, talks given in Japan about the future of computing, to why Feynman thinks Physics is the bees knees, this book both shares some interesting Physics with the reader and gives an insight into the mind of the incredible, bongo playing genious that is Richard Feynman.</p>',2,'2018-07-10 17:35:54',2,'2018-07-10 17:35:54',0),(13,14,'<p>Please follow this videos. They talk about Sketching basics.</p>\r\n<p><iframe src=\"//www.youtube.com/embed/ewMksAbgdBI\" width=\"560\" height=\"314\" allowfullscreen=\"allowfullscreen\"></iframe></p>',47,'2018-07-12 02:31:13',47,'2018-07-12 02:31:13',0),(14,19,'<p>It is with great pleasure that I announce the hiring of new faculty members who will join our Academy family next year. The process of meeting, interviewing, and vetting the candidates has been a wonderful one which involved current and rising administrators, current faculty, and students. These new faculty members will bring their own vibrancy to our small school, and have been attracted to The Academy by our rigorous and balanced academics, our commitment to the visual and performing arts, and our strong community.</p>\r\n<p>Elizabeth Falco will be joining us as a Humanities teacher. Ms. Falco comes to us via Greenfield High School where she taught English. She is a graduate of the Williston Northampton School and earned her B.A., in English from the University of Denver and her M. Ed. From the University of Massachusetts.&nbsp; Ms. Falco has also taught in the Boston public school district and has worked as a journalist for several newspapers and websites. Her passion for history and journalism will find a welcome home at The Academy.</p>',63,'2018-08-15 13:05:55',63,'2018-08-15 13:05:55',0),(15,19,'<p>It is with great pleasure that I announce the hiring of new faculty members who will join our Academy family next year. The process of meeting, interviewing, and vetting the candidates has been a wonderful one which involved current and rising administrators, current faculty, and students. These new faculty members will bring their own vibrancy to our small school, and have been attracted to The Academy by our rigorous and balanced academics, our commitment to the visual and performing arts, and our strong community.</p>\r\n<p>Elizabeth Falco will be joining us as a Humanities teacher. Ms. Falco comes to us via Greenfield High School where she taught English. She is a graduate of the Williston Northampton School and earned her B.A., in English from the University of Denver and her M. Ed. From the University of Massachusetts.&nbsp; Ms. Falco has also taught in the Boston public school district and has worked as a journalist for several newspapers and websites. Her passion for history and journalism will find a welcome home at The Academy.</p>',2,'2018-11-25 16:12:51',2,'2018-11-25 16:12:51',0),(17,20,'<div class=\"col-md-12 col-xs-12\">\r\n<div class=\"post-text\">\r\n<p>I am just testing the new inheritance on the business objects?I am just testing the new inheritance on the business objects?I am just testing the new inheritance on the business objects?I am just testing the new inheritance on the business objects?</p>\r\n</div>\r\n</div>',2,'2018-12-24 10:39:30',2,'2018-12-24 10:39:30',0);
/*!40000 ALTER TABLE `tran_question_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_answer_history`
--

DROP TABLE IF EXISTS `tran_question_answer_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_answer_history` (
  `QUESTION_ANSWER_HISTORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `ACTION_TYPE_ID` int(11) DEFAULT NULL,
  `ACTION_TYPE_VALUE` varchar(50) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_ANSWER_HISTORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_answer_history`
--

LOCK TABLES `tran_question_answer_history` WRITE;
/*!40000 ALTER TABLE `tran_question_answer_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_question_answer_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_class`
--

DROP TABLE IF EXISTS `tran_question_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_class` (
  `QUESTION_CLASS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `CLASS_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_CLASS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_class`
--

LOCK TABLES `tran_question_class` WRITE;
/*!40000 ALTER TABLE `tran_question_class` DISABLE KEYS */;
INSERT INTO `tran_question_class` VALUES (2,3,13,0,'2018-06-23 15:14:35',0,'2018-06-23 15:14:35',0),(3,4,14,0,'2018-06-23 15:23:50',0,'2018-06-23 15:23:50',0),(4,5,4,0,'2018-06-23 15:25:29',0,'2018-06-23 15:25:29',0),(5,6,5,0,'2018-06-23 15:30:03',0,'2018-06-23 15:30:03',0),(10,12,16,0,'2018-06-24 21:18:07',0,'2018-06-24 21:18:07',0),(11,13,17,0,'2018-06-24 21:41:40',0,'2018-06-24 21:41:40',0),(12,14,21,0,'2018-07-12 02:29:07',0,'2018-07-12 02:29:07',0),(13,19,5,0,'2018-08-15 12:58:40',0,'2018-08-15 12:58:40',0),(14,19,8,0,'2018-08-15 12:58:40',0,'2018-08-15 12:58:40',0),(15,20,2,0,'2018-12-24 10:38:04',0,'2018-12-24 10:38:04',0);
/*!40000 ALTER TABLE `tran_question_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_favorite`
--

DROP TABLE IF EXISTS `tran_question_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_favorite` (
  `QUESTION_FAVORITE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_FAVORITE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_favorite`
--

LOCK TABLES `tran_question_favorite` WRITE;
/*!40000 ALTER TABLE `tran_question_favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_question_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_history`
--

DROP TABLE IF EXISTS `tran_question_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_history` (
  `QUESTION_HISTORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `ACTION_TYPE_ID` int(11) DEFAULT NULL,
  `ACTION_TYPE_VALUE` varchar(50) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_HISTORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_history`
--

LOCK TABLES `tran_question_history` WRITE;
/*!40000 ALTER TABLE `tran_question_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_question_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_valid`
--

DROP TABLE IF EXISTS `tran_question_valid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_valid` (
  `QUESTION_VALID_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_VALID_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_valid`
--

LOCK TABLES `tran_question_valid` WRITE;
/*!40000 ALTER TABLE `tran_question_valid` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_question_valid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_view`
--

DROP TABLE IF EXISTS `tran_question_view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_view` (
  `QUESTION_VIEW_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `BROWSER` varchar(500) DEFAULT NULL,
  `IP_ADDRESS` varchar(500) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_VIEW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_view`
--

LOCK TABLES `tran_question_view` WRITE;
/*!40000 ALTER TABLE `tran_question_view` DISABLE KEYS */;
INSERT INTO `tran_question_view` VALUES (19,3,34,'Chrome-67.0','::1',0,'2018-06-23 15:14:36',0,'2018-06-23 15:14:36',0),(20,4,35,'Chrome-67.0','::1',0,'2018-06-23 15:23:51',0,'2018-06-23 15:23:51',0),(21,5,35,'Chrome-67.0','::1',0,'2018-06-23 15:25:29',0,'2018-06-23 15:25:29',0),(22,6,61,'Chrome-67.0','::1',0,'2018-06-23 15:30:03',0,'2018-06-23 15:30:03',0),(23,5,61,'Chrome-67.0','::1',0,'2018-06-23 15:36:23',0,'2018-06-23 15:36:23',0),(24,3,61,'Chrome-67.0','::1',0,'2018-06-23 15:36:41',0,'2018-06-23 15:36:41',0),(25,6,0,'Chrome-67.0','::1',0,'2018-06-24 13:42:19',0,'2018-06-24 13:42:19',0),(28,6,0,'Chrome-67.0','173.26.246.40',0,'2018-06-24 19:52:15',0,'2018-06-24 19:52:15',0),(29,5,0,'Chrome-67.0','173.26.246.40',0,'2018-06-24 19:52:23',0,'2018-06-24 19:52:23',0),(30,3,0,'Chrome-67.0','173.26.246.40',0,'2018-06-24 19:55:11',0,'2018-06-24 19:55:11',0),(31,9,56,'Chrome-67.0','173.26.246.40',0,'2018-06-24 20:20:09',0,'2018-06-24 20:20:09',0),(32,9,0,'Chrome-28.0','66.249.92.210',0,'2018-06-24 20:20:25',0,'2018-06-24 20:20:25',0),(33,9,0,'Chrome-66.0','66.249.88.84',0,'2018-06-24 20:20:29',0,'2018-06-24 20:20:29',0),(34,9,0,'InternetExplorer-11.0','66.102.6.18',0,'2018-06-24 20:20:31',0,'2018-06-24 20:20:31',0),(35,9,0,'Chrome-28.0','66.249.92.208',0,'2018-06-24 20:21:30',0,'2018-06-24 20:21:30',0),(36,9,0,'Chrome-28.0','66.249.92.212',0,'2018-06-24 20:22:29',0,'2018-06-24 20:22:29',0),(37,3,56,'Chrome-67.0','173.26.246.40',0,'2018-06-24 20:26:17',0,'2018-06-24 20:26:17',0),(44,6,57,'Chrome-67.0','173.26.246.40',0,'2018-06-24 20:37:47',0,'2018-06-24 20:37:47',0),(48,12,76,'Chrome-67.0','173.26.246.40',0,'2018-06-24 21:18:07',0,'2018-06-24 21:18:07',0),(49,12,0,'Chrome-28.0','66.249.92.210',0,'2018-06-24 21:18:19',0,'2018-06-24 21:18:19',0),(50,12,0,'Chrome-28.0','66.249.92.208',0,'2018-06-24 21:18:19',0,'2018-06-24 21:18:19',0),(51,5,0,'Mozilla-0.0','157.55.39.67',0,'2018-06-24 21:39:49',0,'2018-06-24 21:39:49',0),(52,13,23,'Chrome-67.0','173.26.246.40',0,'2018-06-24 21:41:40',0,'2018-06-24 21:41:40',0),(53,13,0,'Chrome-28.0','66.249.92.210',0,'2018-06-24 21:41:48',0,'2018-06-24 21:41:48',0),(54,13,0,'Chrome-28.0','66.249.92.212',0,'2018-06-24 21:41:49',0,'2018-06-24 21:41:49',0),(55,13,0,'Chrome-28.0','66.249.91.114',0,'2018-06-24 21:44:33',0,'2018-06-24 21:44:33',0),(56,12,0,'Chrome-67.0','162.245.107.237',0,'2018-06-25 14:43:27',0,'2018-06-25 14:43:27',0),(57,9,0,'Chrome-67.0','162.245.107.237',0,'2018-06-25 14:43:33',0,'2018-06-25 14:43:33',0),(59,3,0,'Chrome-67.0','162.245.107.237',0,'2018-06-25 15:21:37',0,'2018-06-25 15:21:37',0),(60,13,0,'Chrome-67.0','162.245.107.237',0,'2018-06-25 17:09:14',0,'2018-06-25 17:09:14',0),(61,6,0,'Chrome-67.0','162.245.107.237',0,'2018-06-25 17:26:16',0,'2018-06-25 17:26:16',0),(65,6,65,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:21:35',0,'2018-06-26 15:21:35',0),(66,12,2,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:28:19',0,'2018-06-26 15:28:19',0),(67,13,2,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:33:29',0,'2018-06-26 15:33:29',0),(68,5,2,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:38:58',0,'2018-06-26 15:38:58',0),(69,5,65,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:39:24',0,'2018-06-26 15:39:24',0),(70,12,65,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:45:36',0,'2018-06-26 15:45:36',0),(71,12,76,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:46:06',0,'2018-06-26 15:46:06',0),(72,5,76,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:46:21',0,'2018-06-26 15:46:21',0),(75,5,80,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:58:55',0,'2018-06-26 15:58:55',0),(76,12,80,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:59:04',0,'2018-06-26 15:59:04',0),(77,9,80,'Chrome-67.0','45.59.3.218',0,'2018-06-26 15:59:24',0,'2018-06-26 15:59:24',0),(78,13,80,'Chrome-67.0','45.59.3.218',0,'2018-06-26 16:14:56',0,'2018-06-26 16:14:56',0),(79,6,80,'Chrome-67.0','45.59.3.218',0,'2018-06-26 16:16:40',0,'2018-06-26 16:16:40',0),(80,6,66,'Chrome-67.0','45.59.3.218',0,'2018-06-26 16:17:51',0,'2018-06-26 16:17:51',0),(81,5,66,'Chrome-67.0','45.59.3.218',0,'2018-06-26 16:20:29',0,'2018-06-26 16:20:29',0),(82,12,66,'Chrome-67.0','45.59.3.218',0,'2018-06-26 16:20:43',0,'2018-06-26 16:20:43',0),(83,13,66,'Chrome-67.0','45.59.3.218',0,'2018-06-26 16:20:53',0,'2018-06-26 16:20:53',0),(84,4,66,'Chrome-67.0','45.59.3.218',0,'2018-06-26 16:21:25',0,'2018-06-26 16:21:25',0),(85,6,0,'Chrome-67.0','45.59.3.218',0,'2018-06-26 17:48:35',0,'2018-06-26 17:48:35',0),(86,4,0,'Chrome-67.0','45.59.3.218',0,'2018-06-26 17:48:52',0,'2018-06-26 17:48:52',0),(87,9,0,'Unknown-0.0','199.59.150.183',0,'2018-06-27 07:56:13',0,'2018-06-27 07:56:13',0),(88,13,0,'Chrome-67.0','45.59.3.218',0,'2018-06-27 15:27:30',0,'2018-06-27 15:27:30',0),(89,9,0,'Chrome-67.0','45.59.3.218',0,'2018-06-27 15:27:35',0,'2018-06-27 15:27:35',0),(90,9,2,'Chrome-67.0','45.59.3.218',0,'2018-06-27 15:49:26',0,'2018-06-27 15:49:26',0),(93,13,0,'Chrome-67.0','69.29.79.65',0,'2018-06-30 02:46:22',0,'2018-06-30 02:46:22',0),(95,5,2,'Chrome-67.0','173.26.246.40',0,'2018-07-08 18:57:18',0,'2018-07-08 18:57:18',0),(96,4,2,'Chrome-67.0','173.26.246.40',0,'2018-07-08 18:57:28',0,'2018-07-08 18:57:28',0),(98,12,2,'Chrome-67.0','173.26.246.40',0,'2018-07-08 18:59:50',0,'2018-07-08 18:59:50',0),(99,6,2,'Chrome-67.0','173.26.246.40',0,'2018-07-08 23:13:44',0,'2018-07-08 23:13:44',0),(101,13,2,'Chrome-67.0','162.245.107.237',0,'2018-07-09 14:09:02',0,'2018-07-09 14:09:02',0),(102,6,2,'Chrome-67.0','162.245.107.237',0,'2018-07-09 14:10:54',0,'2018-07-09 14:10:54',0),(103,6,61,'Chrome-67.0','162.245.107.237',0,'2018-07-09 16:09:48',0,'2018-07-09 16:09:48',0),(104,13,64,'Chrome-67.0','45.59.3.218',0,'2018-07-10 17:27:57',0,'2018-07-10 17:27:57',0),(105,12,64,'Chrome-67.0','45.59.3.218',0,'2018-07-10 17:29:50',0,'2018-07-10 17:29:50',0),(106,9,64,'Chrome-67.0','45.59.3.218',0,'2018-07-10 17:30:08',0,'2018-07-10 17:30:08',0),(107,6,2,'Chrome-67.0','45.59.3.218',0,'2018-07-10 17:32:35',0,'2018-07-10 17:32:35',0),(108,3,2,'Chrome-67.0','45.59.3.218',0,'2018-07-10 17:33:18',0,'2018-07-10 17:33:18',0),(110,4,2,'Chrome-67.0','45.59.3.218',0,'2018-07-10 17:40:25',0,'2018-07-10 17:40:25',0),(111,9,75,'Chrome-67.0','45.59.3.218',0,'2018-07-10 17:48:51',0,'2018-07-10 17:48:51',0),(112,14,47,'Chrome-67.0','173.26.246.40',0,'2018-07-12 02:29:07',0,'2018-07-12 02:29:07',0),(113,13,47,'Chrome-67.0','173.26.246.40',0,'2018-07-12 02:39:20',0,'2018-07-12 02:39:20',0),(114,13,2,'Chrome-67.0','::1',0,'2018-07-12 11:01:58',0,'2018-07-12 11:01:58',0),(115,14,2,'Chrome-67.0','::1',0,'2018-07-12 11:02:04',0,'2018-07-12 11:02:04',0),(116,14,2,'Safari-11.0','::1',0,'2018-07-12 11:02:15',0,'2018-07-12 11:02:15',0),(118,12,2,'Chrome-67.0','::1',0,'2018-07-15 00:40:47',0,'2018-07-15 00:40:47',0),(119,6,2,'Chrome-67.0','::1',0,'2018-07-15 00:41:10',0,'2018-07-15 00:41:10',0),(120,12,63,'Chrome-67.0','::1',0,'2018-07-29 19:39:00',0,'2018-07-29 19:39:00',0),(121,13,63,'Chrome-67.0','::1',0,'2018-07-29 19:39:04',0,'2018-07-29 19:39:04',0),(122,14,63,'Chrome-67.0','::1',0,'2018-07-29 19:39:09',0,'2018-07-29 19:39:09',0),(123,9,2,'Chrome-67.0','::1',0,'2018-07-30 13:48:44',0,'2018-07-30 13:48:44',0),(124,13,2,'Chrome-68.0','::1',0,'2018-08-08 15:41:41',0,'2018-08-08 15:41:41',0),(126,14,63,'Chrome-68.0','::1',0,'2018-08-11 13:20:43',0,'2018-08-11 13:20:43',0),(130,14,2,'Chrome-68.0','::1',0,'2018-08-13 10:40:15',0,'2018-08-13 10:40:15',0),(132,19,2,'Chrome-68.0','::1',0,'2018-08-15 12:58:40',0,'2018-08-15 12:58:40',0),(134,19,63,'Chrome-68.0','::1',0,'2018-08-15 13:05:25',0,'2018-08-15 13:05:25',0),(135,12,2,'Chrome-68.0','::1',0,'2018-08-16 14:48:56',0,'2018-08-16 14:48:56',0),(136,9,2,'Chrome-68.0','::1',0,'2018-09-07 09:59:53',0,'2018-09-07 09:59:53',0),(137,6,2,'Chrome-68.0','::1',0,'2018-09-07 10:03:45',0,'2018-09-07 10:03:45',0),(139,19,2,'Chrome-69.0','::1',0,'2018-09-13 14:56:42',0,'2018-09-13 14:56:42',0),(140,13,2,'Chrome-69.0','::1',0,'2018-09-15 14:06:47',0,'2018-09-15 14:06:47',0),(143,12,2,'Chrome-69.0','::1',0,'2018-09-18 13:59:24',0,'2018-09-18 13:59:24',0),(144,14,2,'Chrome-69.0','::1',0,'2018-09-18 15:37:22',0,'2018-09-18 15:37:22',0),(145,6,2,'Safari-11.0','::1',0,'2018-10-03 13:20:16',0,'2018-10-03 13:20:16',0),(147,19,57,'Chrome-70.0','::1',0,'2018-11-21 11:27:17',0,'2018-11-21 11:27:17',0),(149,14,2,'Chrome-70.0','::1',0,'2018-11-23 10:46:34',0,'2018-11-23 10:46:34',0),(151,19,2,'Chrome-70.0','::1',0,'2018-11-24 13:37:41',0,'2018-11-24 13:37:41',0),(152,13,2,'Chrome-70.0','::1',0,'2018-11-25 09:21:20',0,'2018-11-25 09:21:20',0),(153,9,2,'Chrome-70.0','::1',0,'2018-11-25 09:23:09',0,'2018-11-25 09:23:09',0),(154,12,2,'Chrome-70.0','::1',0,'2018-11-25 09:37:59',0,'2018-11-25 09:37:59',0),(155,3,2,'Chrome-70.0','::1',0,'2018-11-28 20:01:42',0,'2018-11-28 20:01:42',0),(156,6,2,'Chrome-70.0','::1',0,'2018-12-02 13:44:10',0,'2018-12-02 13:44:10',0),(157,20,2,'Chrome-71.0','::1',0,'2018-12-24 10:38:04',0,'2018-12-24 10:38:04',0),(158,13,2,'Chrome-71.0','::1',0,'2018-12-24 10:39:40',0,'2018-12-24 10:39:40',0),(159,12,2,'Chrome-71.0','::1',0,'2018-12-24 10:40:11',0,'2018-12-24 10:40:11',0),(160,19,2,'Chrome-71.0','::1',0,'2018-12-26 12:04:51',0,'2018-12-26 12:04:51',0),(161,20,101,'Chrome-71.0','::1',0,'2019-01-01 13:54:56',0,'2019-01-01 13:54:56',0);
/*!40000 ALTER TABLE `tran_question_view` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_report_abuse`
--

DROP TABLE IF EXISTS `tran_report_abuse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_report_abuse` (
  `REPORT_ABUSE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ABUSE_TYPE_ID` int(11) DEFAULT NULL,
  `ABUSE_TYPE_VALUE` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_ID` int(11) DEFAULT NULL,
  `SUSYSTEM_VALUE` varchar(50) DEFAULT NULL,
  `SUBSYSTEM_REFERENCE_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`REPORT_ABUSE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_report_abuse`
--

LOCK TABLES `tran_report_abuse` WRITE;
/*!40000 ALTER TABLE `tran_report_abuse` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_report_abuse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_tag`
--

DROP TABLE IF EXISTS `tran_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_tag` (
  `TAG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `USER_GROUP_TYPE_ID` int(11) DEFAULT NULL,
  `USER_GROUP_TYPE_VALUE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USER_GROUP_VALUE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SUBSYSTEM_ID` int(11) DEFAULT NULL,
  `SUBSYSTEM_VALUE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SUBSYSTEM_REFERENCE_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`TAG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_tag`
--

LOCK TABLES `tran_tag` WRITE;
/*!40000 ALTER TABLE `tran_tag` DISABLE KEYS */;
INSERT INTO `tran_tag` VALUES (1,2,17,'USGP','1',10,'QUES',15,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(2,2,17,'USGP','2',10,'QUES',15,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(3,2,17,'YEAR','FRSH',10,'QUES',15,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(4,2,17,'YEAR','SENR',10,'QUES',15,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(5,2,17,'INDV',NULL,10,'QUES',15,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(6,2,17,'USGP','1',10,'QUES',15,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(7,2,17,'USGP','3',10,'QUES',15,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(8,2,17,'YEAR','FRSH',10,'QUES',15,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(9,2,17,'YEAR','SPMR',10,'QUES',15,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(10,2,17,'USGP','1',10,'QUES',16,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(11,2,17,'USGP','3',10,'QUES',16,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(12,2,17,'YEAR','FRSH',10,'QUES',16,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(13,2,17,'YEAR','SENR',10,'QUES',16,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(14,2,17,'INDV',NULL,10,'QUES',16,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(15,2,17,'USGP','1',10,'ANNC',7,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(16,2,17,'YEAR','SENR',10,'ANNC',7,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(17,2,17,'USGP','3',10,'ANNC',7,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(18,2,17,'YEAR','FRSH',10,'ANNC',7,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(19,2,17,'YEAR','SPMR',10,'ANNC',7,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(20,2,17,'YEAR','JUNR',10,'ANNC',7,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(21,2,17,'YEAR','FRSH',10,'QUES',17,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(22,33,17,'INDV',NULL,10,'ANNC',8,33,'2018-08-11 13:52:21',33,'2018-08-11 13:52:21',0),(23,2,17,'USGP','1',10,'QUES',18,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(24,2,17,'USGP','2',10,'QUES',18,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(25,2,17,'YEAR','FRSH',10,'QUES',18,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(26,2,17,'YEAR','JUNR',10,'QUES',18,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(27,2,17,'INDV',NULL,10,'QUES',18,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(28,2,17,'INDV',NULL,10,'QUES',18,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(29,2,17,'USGP','1',10,'QUES',19,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(30,2,17,'USGP','2',10,'QUES',19,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(31,2,17,'INDV',NULL,10,'QUES',19,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(32,2,17,'INDV',NULL,10,'QUES',19,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(33,2,17,'YEAR','SENR',10,'QUES',19,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(34,2,17,'USGP','3',10,'QUES',19,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(35,2,17,'USGP','1',10,'ANNC',9,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(36,2,17,'USGP','3',10,'ANNC',9,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(37,2,17,'USGP','2',10,'ANNC',9,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(38,2,17,'INDV',NULL,10,'ANNC',9,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(39,2,17,'INDV',NULL,10,'QUES',20,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(40,2,17,'USGP','10',10,'QUES',20,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0);
/*!40000 ALTER TABLE `tran_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_tag_detail`
--

DROP TABLE IF EXISTS `tran_tag_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_tag_detail` (
  `TAG_DETAIL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TAG_ID` int(11) DEFAULT NULL,
  `TAGGED_USER_ID` int(11) NOT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`TAG_DETAIL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_tag_detail`
--

LOCK TABLES `tran_tag_detail` WRITE;
/*!40000 ALTER TABLE `tran_tag_detail` DISABLE KEYS */;
INSERT INTO `tran_tag_detail` VALUES (1,2,13,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(2,2,20,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(3,2,22,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(4,2,33,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(5,2,35,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(6,2,44,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(7,2,48,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(8,2,50,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(9,2,62,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(10,3,12,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(11,3,13,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(12,3,14,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(13,3,15,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(14,3,16,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(15,3,17,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(16,3,33,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(17,3,34,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(18,3,35,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(19,3,36,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(20,3,37,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(21,3,38,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(22,3,39,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(23,4,29,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(24,4,30,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(25,4,31,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(26,4,32,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(27,4,56,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(28,4,57,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(29,4,58,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(30,4,59,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(31,4,60,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(32,4,61,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(33,4,62,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(34,5,12,2,'2018-08-10 14:54:13',2,'2018-08-10 14:54:13',0),(35,7,16,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(36,8,12,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(37,8,13,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(38,8,14,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(39,8,15,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(40,8,16,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(41,8,17,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(42,8,33,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(43,8,34,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(44,8,35,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(45,8,36,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(46,8,37,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(47,8,38,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(48,8,39,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(49,9,18,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(50,9,19,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(51,9,20,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(52,9,21,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(53,9,22,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(54,9,23,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(55,9,40,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(56,9,41,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(57,9,42,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(58,9,43,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(59,9,44,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(60,9,45,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(61,9,46,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(62,9,47,2,'2018-08-11 11:31:42',2,'2018-08-11 11:31:42',0),(63,11,16,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(64,12,12,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(65,12,13,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(66,12,14,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(67,12,15,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(68,12,16,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(69,12,17,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(70,12,33,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(71,12,34,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(72,12,35,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(73,12,36,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(74,12,37,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(75,12,38,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(76,12,39,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(77,13,29,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(78,13,30,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(79,13,31,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(80,13,32,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(81,13,56,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(82,13,57,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(83,13,58,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(84,13,59,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(85,13,60,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(86,13,61,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(87,13,62,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(88,14,12,2,'2018-08-11 13:22:31',2,'2018-08-11 13:22:31',0),(89,16,29,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(90,16,30,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(91,16,31,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(92,16,32,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(93,16,56,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(94,16,57,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(95,16,58,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(96,16,59,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(97,16,60,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(98,16,61,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(99,16,62,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(100,17,16,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(101,18,12,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(102,18,13,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(103,18,14,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(104,18,15,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(105,18,16,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(106,18,17,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(107,18,33,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(108,18,34,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(109,18,35,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(110,18,36,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(111,18,37,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(112,18,38,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(113,18,39,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(114,19,18,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(115,19,19,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(116,19,20,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(117,19,21,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(118,19,22,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(119,19,23,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(120,19,40,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(121,19,41,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(122,19,42,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(123,19,43,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(124,19,44,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(125,19,45,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(126,19,46,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(127,19,47,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(128,20,24,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(129,20,25,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(130,20,26,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(131,20,27,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(132,20,28,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(133,20,48,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(134,20,49,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(135,20,50,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(136,20,51,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(137,20,52,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(138,20,53,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(139,20,54,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(140,20,55,2,'2018-08-11 13:29:49',2,'2018-08-11 13:29:49',0),(141,21,12,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(142,21,13,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(143,21,14,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(144,21,15,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(145,21,16,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(146,21,17,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(147,21,33,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(148,21,34,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(149,21,35,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(150,21,36,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(151,21,37,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(152,21,38,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(153,21,39,2,'2018-08-11 13:45:46',2,'2018-08-11 13:45:46',0),(154,22,63,33,'2018-08-11 13:52:21',33,'2018-08-11 13:52:21',0),(155,24,13,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(156,24,20,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(157,24,22,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(158,24,33,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(159,24,35,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(160,24,44,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(161,24,48,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(162,24,50,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(163,24,62,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(164,25,12,2,'2018-08-13 10:49:23',2,'2018-08-13 10:49:23',0),(165,25,13,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(166,25,14,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(167,25,15,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(168,25,16,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(169,25,17,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(170,25,33,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(171,25,34,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(172,25,35,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(173,25,36,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(174,25,37,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(175,25,38,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(176,25,39,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(177,26,24,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(178,26,25,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(179,26,26,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(180,26,27,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(181,26,28,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(182,26,48,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(183,26,49,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(184,26,50,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(185,26,51,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(186,26,52,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(187,26,53,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(188,26,54,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(189,26,55,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(190,27,51,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(191,28,63,2,'2018-08-13 10:49:24',2,'2018-08-13 10:49:24',0),(192,30,13,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(193,30,20,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(194,30,22,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(195,30,33,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(196,30,35,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(197,30,44,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(198,30,48,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(199,30,50,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(200,30,62,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(201,31,51,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(202,32,12,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(203,33,29,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(204,33,30,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(205,33,31,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(206,33,32,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(207,33,56,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(208,33,57,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(209,33,58,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(210,33,59,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(211,33,60,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(212,33,61,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(213,33,62,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(214,34,16,2,'2018-08-15 12:58:40',2,'2018-08-15 12:58:40',0),(215,36,16,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(216,37,13,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(217,37,20,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(218,37,22,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(219,37,33,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(220,37,35,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(221,37,44,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(222,37,48,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(223,37,50,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(224,37,62,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(225,38,12,2,'2018-08-16 14:45:26',2,'2018-08-16 14:45:26',0),(226,39,13,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(227,40,12,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(228,40,31,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(229,40,46,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(230,40,52,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(231,40,78,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0),(232,40,67,2,'2018-12-24 10:38:04',2,'2018-12-24 10:38:04',0);
/*!40000 ALTER TABLE `tran_tag_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_thread`
--

DROP TABLE IF EXISTS `tran_thread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_thread` (
  `THREAD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `THREAD` varchar(100) DEFAULT NULL,
  `THREAD_LINK` varchar(500) DEFAULT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `STATUS_ID` int(11) NOT NULL,
  `STATUS_VALUE` varchar(50) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`THREAD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_thread`
--

LOCK TABLES `tran_thread` WRITE;
/*!40000 ALTER TABLE `tran_thread` DISABLE KEYS */;
INSERT INTO `tran_thread` VALUES (1,'Cosmology','','the science of the origin and development of the universe. Modern astronomy is dominated by the Big Bang theory, \nwhich brings together observational astronomy and particle physics.',7,'APPR',1,'2017-03-23 19:03:14',1,'2017-03-23 19:03:14',0),(2,'Religion','','A religion is an organized collection of beliefs, cultural systems, and world views that relate humanity to an order of existence. Many religions have narratives, symbols, and sacred histories that \naim to explain the meaning of life, the origin of life, or the Universe',7,'APPR',1,'2017-03-23 19:03:14',1,'2017-03-23 19:03:14',0);
/*!40000 ALTER TABLE `tran_thread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_user_group`
--

DROP TABLE IF EXISTS `tran_user_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_user_group` (
  `USER_GROUP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `GROUP_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GROUP_DESCRIPTION` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GROUP_STATUS_ID` int(11) NOT NULL,
  `GROUP_STATUS_VALUE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_GROUP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_user_group`
--

LOCK TABLES `tran_user_group` WRITE;
/*!40000 ALTER TABLE `tran_user_group` DISABLE KEYS */;
INSERT INTO `tran_user_group` VALUES (1,'Admin Group','Admin Group',16,'ACTV',2,'2017-03-23 19:03:14',2,'2017-03-23 19:03:14',0),(2,'Politics','Politics',16,'ACTV',2,'2018-07-31 12:47:41',2,'2018-07-31 12:47:41',0),(3,'Seniors World History','this group is for seniors who are interested in World History',16,'ACTV',2,'2018-08-02 14:14:56',2,'2018-08-02 14:14:56',0),(4,'Test1','Testing User Groups',16,'ACTV',2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(5,'Computer Science','Creating this group for students who are interested in taking computer science classes.',16,'ACTV',2,'2018-09-13 14:44:55',2,'2018-09-13 14:54:24',0),(6,'Fine Arts','Group for students interested in Fine Arts',16,'ACTV',2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(7,'Test2','Test2',16,'ACTV',2,'2018-09-25 12:40:50',2,'2018-09-25 12:40:50',0),(10,'Wild Folks Groups','Wild Kids',16,'ACTV',2,'2018-11-30 14:25:40',2,'2018-11-30 14:25:55',0);
/*!40000 ALTER TABLE `tran_user_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_user_group_detail`
--

DROP TABLE IF EXISTS `tran_user_group_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_user_group_detail` (
  `USER_GROUP_DETAIL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_GROUP_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_GROUP_DETAIL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_user_group_detail`
--

LOCK TABLES `tran_user_group_detail` WRITE;
/*!40000 ALTER TABLE `tran_user_group_detail` DISABLE KEYS */;
INSERT INTO `tran_user_group_detail` VALUES (1,1,2,2,'2017-03-23 19:03:14',2,'2017-03-23 19:03:14',0),(2,2,13,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(3,2,20,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(4,2,22,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(5,2,33,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(6,2,35,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(7,2,44,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(8,2,48,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(9,2,50,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(10,2,62,2,'2018-07-31 12:47:42',2,'2018-07-31 12:47:42',0),(11,3,16,2,'2018-08-02 14:14:56',2,'2018-08-02 14:14:56',0),(12,4,13,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(13,4,32,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(14,4,34,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(15,4,42,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(16,4,54,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(17,4,12,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(18,4,16,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(19,4,38,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(20,4,53,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(21,4,14,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(22,4,19,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(23,4,23,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(24,4,29,2,'2018-09-07 10:05:57',2,'2018-09-07 10:05:57',0),(73,5,13,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(74,5,32,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(75,5,34,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(76,5,42,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(77,5,43,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(78,5,49,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(79,5,54,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(80,5,75,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(81,5,12,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(82,5,38,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(83,5,16,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(84,5,53,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(85,5,1,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(86,5,14,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(87,5,15,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(88,5,23,2,'2018-09-13 14:54:24',2,'2018-09-13 14:54:24',0),(89,6,13,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(90,6,14,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(91,6,15,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(92,6,18,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(93,6,19,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(94,6,20,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(95,6,21,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(96,6,23,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(97,6,24,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(98,6,26,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(99,6,29,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(100,6,31,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(101,6,32,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(102,6,33,2,'2018-09-13 14:55:31',2,'2018-09-13 14:55:31',0),(103,7,16,2,'2018-09-25 12:40:50',2,'2018-09-25 12:40:50',0),(104,7,22,2,'2018-09-25 12:40:50',2,'2018-09-25 12:40:50',0),(105,7,34,2,'2018-09-25 12:40:50',2,'2018-09-25 12:40:50',0),(106,7,13,2,'2018-09-25 12:40:50',2,'2018-09-25 12:40:50',0),(107,7,33,2,'2018-09-25 12:40:50',2,'2018-09-25 12:40:50',0),(108,7,24,2,'2018-09-25 12:40:50',2,'2018-09-25 12:40:50',0),(109,7,26,2,'2018-09-25 12:40:50',2,'2018-09-25 12:40:50',0),(115,10,12,2,'2018-11-30 14:25:56',2,'2018-11-30 14:25:56',0),(116,10,31,2,'2018-11-30 14:25:56',2,'2018-11-30 14:25:56',0),(117,10,46,2,'2018-11-30 14:25:56',2,'2018-11-30 14:25:56',0),(118,10,52,2,'2018-11-30 14:25:56',2,'2018-11-30 14:25:56',0),(119,10,78,2,'2018-11-30 14:25:56',2,'2018-11-30 14:25:56',0),(120,10,67,2,'2018-11-30 14:25:56',2,'2018-11-30 14:25:56',0);
/*!40000 ALTER TABLE `tran_user_group_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-02 13:38:22
