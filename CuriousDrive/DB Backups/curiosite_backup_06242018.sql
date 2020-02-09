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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_code`
--

LOCK TABLES `sys_code` WRITE;
/*!40000 ALTER TABLE `sys_code` DISABLE KEYS */;
INSERT INTO `sys_code` VALUES (1,'Network Type',NULL,NULL,NULL,NULL,NULL,NULL,'This code id holds data for different types of net',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(2,'Gender',NULL,NULL,NULL,NULL,NULL,NULL,'Gender Values',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(3,'Constants',NULL,NULL,NULL,NULL,NULL,NULL,'Costant Values',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(4,'Region',NULL,NULL,NULL,NULL,NULL,NULL,'System Region',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(5,'Message Type',NULL,NULL,NULL,NULL,NULL,NULL,'Message Types',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(6,'Category Status',NULL,NULL,NULL,NULL,NULL,NULL,'Category Statuses',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(7,'Thread Status',NULL,NULL,NULL,NULL,NULL,NULL,'Thread Statuses',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(8,'Post Comment Types',NULL,NULL,NULL,NULL,NULL,NULL,'Post Comment Types',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(9,'Vote Types',NULL,NULL,NULL,NULL,NULL,NULL,'Vote Types',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(10,'Post Vote Types',NULL,NULL,NULL,NULL,NULL,NULL,'Post Vote Types',1,'2017-03-23 18:50:53',1,'2017-03-23 18:50:53',0),(11,'Action Types',NULL,NULL,NULL,NULL,NULL,NULL,'Action Types',1,'2017-11-15 02:46:53',1,'2017-11-15 02:46:53',0),(12,'Point Types',NULL,NULL,NULL,NULL,NULL,NULL,'Point Types',1,'2017-11-15 02:47:17',1,'2017-11-15 02:47:17',0),(14,'Roles',NULL,NULL,NULL,NULL,NULL,NULL,'Roles',1,'2018-06-17 12:11:52',1,'2018-06-17 12:11:52',0),(15,'User Groups',NULL,NULL,NULL,NULL,NULL,NULL,'User Groups',1,'2018-06-17 12:11:52',1,'2018-06-17 12:11:52',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_code_value`
--

LOCK TABLES `sys_code_value` WRITE;
/*!40000 ALTER TABLE `sys_code_value` DISABLE KEYS */;
INSERT INTO `sys_code_value` VALUES (1,1,'FACE','Facebook Network',NULL,NULL,NULL,'Facebook Network',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(2,1,'GOOG','Google Network',NULL,NULL,NULL,'Google Network',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(3,1,'APPC','Application Network',NULL,NULL,NULL,'Application Network',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(4,2,'MALE','Gender Male',NULL,NULL,NULL,'Gender Male',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(5,2,'FEML','Gender Female',NULL,NULL,NULL,'Gender Female',1,'2017-03-23 19:03:02',1,'2017-03-23 19:03:02',0),(6,3,'GCIU','Google Client Id UAT','140500360968-gl23jgs6b5e9b0n052a417g66ter4e60.apps.googleusercontent.com',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(7,3,'GCIS','Google Client Id SYS','140500360968-f8t3e7pmt1e09knbdsq2jjjrr5fi4b3e.apps.googleusercontent.com',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(8,3,'GCIL','Google Client Id LOC','140500360968-qjbi53f7ie19ef4ufor51nqp6i4vt83m.apps.googleusercontent.com',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(9,3,'GAKU','Google API Key UAT','AIzaSyBnRA2rwLNKqPgdWuuPOXTR3UTaCJe9hH4',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(10,3,'GAKS','Google API Key SYS','AIzaSyDyxvLMSvnr1nfnXl_TuSvryixhJibK3Hg',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(11,3,'GAKL','Google API Key LOC','AIzaSyCp2Jq9z9MeCQEz3F0Q_mnvX13ngZu1jEI',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(12,3,'FCIU','Facebook Client Id UAT','768654456560330',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(13,3,'FCIS','Facebook Client Id SYS','764678906943496',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(14,3,'FCIL','Facebook Client Id LOC','801162613266480',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(15,3,'RDUU','Redirect URL UAT','http://www.curiositebox.com/siteAero/index.html',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(16,3,'RDUS','Redirect URL SYS','http://localhost/serviceAero/vAero/',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(17,3,'RDUL','Redirect URL LOC','http://localhost:8080/siteAero/index.html',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(18,3,'RSUU','Rest Service URL UAT','http://www.curiositebox.com/serviceAero/vAero/',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(19,3,'RSUS','Rest Service URL SYS','http://localhost/serviceAero/vAero/',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(20,3,'RSUL','Rest Service URL LOC','http://localhost:8080/api/vAero/',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(21,4,'REGN','System Region Values','LOC',NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(22,5,'ERRR','Error Message',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(23,6,'CATA','Category Status Approved',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(24,6,'CATP','Category Status Pending For Approval',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(25,7,'THRA','Thread Status Approved',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(26,7,'THRP','Thread Status Pending For Approval',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(31,10,'QUES','Post Type Question',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(32,10,'ANSR','Post Type Answer',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(33,10,'CMNT','Post Type Comment',NULL,NULL,NULL,'',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(34,11,'UPVQ','Action Type - Up Vote Question',NULL,NULL,NULL,'',1,'2017-11-15 02:47:47',1,'2017-11-15 02:47:47',0),(35,11,'DNVQ','Action Type - Down Vote Question',NULL,NULL,NULL,'',1,'2017-11-15 02:48:07',1,'2017-11-15 02:48:07',0),(36,11,'UPVA','Action Type - Up Vote Answer',NULL,NULL,NULL,'',1,'2017-11-15 02:48:18',1,'2017-11-15 02:48:18',0),(37,11,'DNVA','Action Type - Down Vote Answer',NULL,NULL,NULL,'',1,'2017-11-15 02:48:31',1,'2017-11-15 02:48:31',0),(38,11,'UPVC','Action Type - Up Vote Comment',NULL,NULL,NULL,'',1,'2017-11-15 02:49:05',1,'2017-11-15 02:49:05',0),(39,11,'DNVC','Action Type - Down Vote Comment',NULL,NULL,NULL,'',1,'2017-11-15 02:49:05',1,'2017-11-15 02:49:05',0),(40,12,'VOTE','Vote Point',NULL,NULL,NULL,'',1,'2017-11-15 02:49:05',1,'2017-11-15 02:49:05',0),(41,12,'BONS','Bonus Point',NULL,NULL,NULL,'',1,'2017-11-15 02:49:05',1,'2017-11-15 02:49:05',0),(42,9,'UPVT','Vote Type Up',NULL,NULL,NULL,'',1,'2017-11-15 02:50:31',1,'2017-11-15 02:50:31',0),(43,9,'DNVT','Vote Type Down',NULL,NULL,NULL,'',1,'2017-11-15 02:50:31',1,'2017-11-15 02:50:31',0),(44,5,'INFO','Information Message',NULL,NULL,NULL,'',1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(54,11,'ANSR','Action Type - Answer',NULL,NULL,NULL,'',1,'2018-05-08 14:13:58',1,'2018-05-08 14:13:58',0),(56,11,'ASKQ','Action Type - Ask Question',NULL,NULL,NULL,'',1,'2018-05-08 14:13:58',1,'2018-05-08 14:13:58',0),(57,1,'TWIT','Twitter Network',NULL,NULL,NULL,'Twitter Network',1,'2018-05-08 14:17:17',1,'2018-05-08 14:17:17',0),(58,3,'REGN','System Envirionment','DEV',NULL,NULL,'',1,'2018-05-08 14:17:17',1,'2018-05-08 14:17:17',0),(59,11,'CMTQ','Action Type - Comment on Question',NULL,NULL,NULL,'',1,'2018-05-15 14:12:28',1,'2018-05-15 14:12:28',0),(60,11,'CMTA','Action Type - Comment on Answer',NULL,NULL,NULL,'',1,'2018-05-15 14:12:28',1,'2018-05-15 14:12:28',0),(61,14,'GNRL','General',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(62,14,'STUD','Student',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(63,14,'MDTR','Moderator',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(64,14,'TCHR','Teacher',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(65,14,'ADMN','Admin',NULL,NULL,NULL,'',1,'2018-06-17 12:25:06',1,'2018-06-17 12:25:06',0),(66,15,'FRSH','Freshman',NULL,NULL,NULL,'',1,'2018-06-17 12:40:13',1,'2018-06-17 12:40:13',0),(67,15,'SPMR','Sophomore',NULL,NULL,NULL,'',1,'2018-06-17 12:40:13',1,'2018-06-17 12:40:13',0),(68,15,'JUNR','Junior',NULL,NULL,NULL,'',1,'2018-06-17 12:40:13',1,'2018-06-17 12:40:13',0),(69,15,'SENR','Senior',NULL,NULL,NULL,'',1,'2018-06-17 12:40:13',1,'2018-06-17 12:40:13',0),(70,15,'GNRL','General',NULL,NULL,NULL,'',1,'2018-06-21 15:59:34',1,'2018-06-21 15:59:34',0),(71,15,'WOLI','World Literature Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:00:24',1,'2018-06-21 16:00:24',0),(72,15,'EULI','European Literature Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:01:06',1,'2018-06-21 16:01:06',0),(73,8,'ANSR','Comment Type Answer',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(74,8,'QUES','Comment Type Question',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(76,15,'ENLA','English Language Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(77,15,'ENLI','English Literature Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(78,15,'WOHI','World History Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(79,15,'HUGP','Human Geography Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(80,15,'PCLG','Psychology Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(81,15,'USHI','U.S. History Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(82,15,'CMST','Chemistry Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(83,15,'ANTM','Anatomy Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(84,15,'PSLG','Physiology Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(85,15,'PHSC','Physics Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(86,15,'ALGB','Algebra Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(87,15,'GMTR','Geometry Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(88,15,'CALS','Calculus Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(89,15,'STAT','Statistics Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(90,15,'FRCH','French Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(91,15,'LATN','Latin Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(92,15,'SPNS','Spanish Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(93,15,'FNAT','Fine Arts Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0),(94,15,'PHED','Physical Education Teacher',NULL,NULL,NULL,'',1,'2018-06-21 16:12:59',1,'2018-06-21 16:12:59',0);
/*!40000 ALTER TABLE `sys_code_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_levels`
--

DROP TABLE IF EXISTS `sys_levels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_levels` (
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
-- Dumping data for table `sys_levels`
--

LOCK TABLES `sys_levels` WRITE;
/*!40000 ALTER TABLE `sys_levels` DISABLE KEYS */;
INSERT INTO `sys_levels` VALUES (1,1,'Beginner',0,'',1,'2018-03-31 12:48:03',1,'2018-03-31 12:48:03',0),(2,2,'Intermediate',100,'',1,'2018-03-31 12:58:55',1,'2018-03-31 12:58:55',0),(3,3,'Semi-professional',250,'',1,'2018-03-31 12:58:55',1,'2018-03-31 12:58:55',0),(4,4,'Professional',1000,'',1,'2018-03-31 12:58:55',1,'2018-03-31 12:58:55',0),(5,5,'World Class',2500,'',1,'2018-03-31 12:58:56',1,'2018-03-31 12:58:56',0),(6,6,'Legendary',10000,'',1,'2018-03-31 12:58:56',1,'2018-03-31 12:58:56',0);
/*!40000 ALTER TABLE `sys_levels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_messages`
--

DROP TABLE IF EXISTS `sys_messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_messages` (
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
-- Dumping data for table `sys_messages`
--

LOCK TABLES `sys_messages` WRITE;
/*!40000 ALTER TABLE `sys_messages` DISABLE KEYS */;
INSERT INTO `sys_messages` VALUES (1,'Please enter your first and last name','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(2,'Looks like you have already signed up with us. Please click on forgot password if you want to reset your password','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(3,'Please enter email address, password and retype your password','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(4,'Your	 password and retyped password does not match','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(5,'Your password should be longer than at least 6 characters','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(6,'Please enter your email address and password to login','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(7,'Either your email address or password does not match with our system. Please enter valid email address and password','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(8,'Please enter valid email address…','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(9,'Your email address does not match with our system. Please enter valid email address.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(10,'Please enter question title…duh.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(11,'Your question might already exists in the system. Please search for it before asking the question','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(12,'Question description is not descriptive. Please make it at least 100 characters','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(13,'Question title should be at least 20 characters','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(14,'Please login to perform this operation...','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(15,'Answer should be very descriptive and at least 100 characters long.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(16,'You have already voted for this post','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(17,'You cannot vote for your own post.','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(18,'Please enter the comment','5','ERRR',NULL,NULL,1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0),(19,'Tag name or tag decription cannot be empty.','5','ERRR',NULL,NULL,1,'2017-12-07 21:14:30',1,'2017-12-07 21:14:30',0),(20,'Nothing was entered in the feedback box!!','5','ERRR',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(21,'Your feedback has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(22,'Your tag has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(23,'This tag already exists in the system.','5','ERRR',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(24,'Your vote has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(25,'Your comment has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(26,'Your answer has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0),(27,'Your question has been saved successfully.','5','INFO',NULL,NULL,1,'2017-11-30 20:55:22',1,'2017-11-30 20:55:22',0);
/*!40000 ALTER TABLE `sys_messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_roles`
--

DROP TABLE IF EXISTS `sys_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_roles` (
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
-- Dumping data for table `sys_roles`
--

LOCK TABLES `sys_roles` WRITE;
/*!40000 ALTER TABLE `sys_roles` DISABLE KEYS */;
INSERT INTO `sys_roles` VALUES (1,'General','General','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0),(2,'Students','Students','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0),(3,'Moderators','Moderators','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0),(4,'Teachers','Teachers','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0),(5,'Admins','Admins','2018-04-23 21:05:32',1,'2018-04-23 21:05:32',1,0);
/*!40000 ALTER TABLE `sys_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_roles`
--

DROP TABLE IF EXISTS `sys_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_roles` (
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
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_roles`
--

LOCK TABLES `sys_user_roles` WRITE;
/*!40000 ALTER TABLE `sys_user_roles` DISABLE KEYS */;
INSERT INTO `sys_user_roles` VALUES (1,1,14,'ADMN',15,NULL,1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(2,2,14,'ADMN',15,NULL,1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(12,12,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(13,13,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(14,14,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(15,15,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(16,16,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(17,17,14,'MDTR',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(18,18,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(19,19,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(20,20,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(21,21,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(22,22,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(23,23,14,'MDTR',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(24,24,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(25,25,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(26,26,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(27,27,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(28,28,14,'MDTR',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(29,29,14,'MDTR',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(30,30,14,'MDTR',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(31,31,14,'MDTR',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(32,32,14,'MDTR',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(33,33,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(34,34,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(35,35,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(36,36,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(37,37,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(38,38,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(39,39,14,'STUD',15,'FRSH',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(40,40,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(41,41,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(42,42,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(43,43,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(44,44,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(45,45,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(46,46,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(47,47,14,'STUD',15,'SPMR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(48,48,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(49,49,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(50,50,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(51,51,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(52,52,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(53,53,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(54,54,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(55,55,14,'STUD',15,'JUNR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(56,56,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(57,57,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(58,58,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(59,59,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(60,60,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(61,61,14,'STUD',15,'SENR',1,'2018-04-23 21:33:22',1,'2018-04-23 21:33:22',0),(62,62,14,'STUD',15,'SENR',0,'2018-04-27 11:20:34',0,'2018-04-27 11:20:34',0),(63,63,14,'TCHR',15,'EULI',1,'2018-04-27 11:24:02',1,'2018-04-27 11:24:02',0),(64,64,14,'TCHR',15,'ENLA',1,'2018-06-21 13:49:42',1,'2018-06-21 13:49:42',0),(65,65,14,'TCHR',15,'ENLI',1,'2018-06-21 15:56:54',1,'2018-06-21 15:56:54',0),(66,66,14,'TCHR',15,'WOHI',1,'2018-06-22 13:59:00',1,'2018-06-22 13:59:00',0),(67,67,14,'TCHR',15,'HUGP',1,'2018-06-22 13:59:46',1,'2018-06-22 13:59:46',0),(68,68,14,'TCHR',15,'PCLG',1,'2018-06-22 14:00:52',1,'2018-06-22 14:00:52',0),(69,69,14,'TCHR',15,'USHI',1,'2018-06-22 14:01:32',1,'2018-06-22 14:01:32',0),(70,70,14,'TCHR',15,'CMST',1,'2018-06-22 14:02:15',1,'2018-06-22 14:02:15',0),(71,71,14,'TCHR',15,'ANTM',1,'2018-06-22 14:02:57',1,'2018-06-22 14:02:57',0),(72,72,14,'TCHR',15,'PSLG',1,'2018-06-22 14:03:35',1,'2018-06-22 14:03:35',0),(73,73,14,'TCHR',15,'PHSC',1,'2018-06-22 14:04:27',1,'2018-06-22 14:04:27',0),(74,74,14,'TCHR',15,'ALGB',1,'2018-06-22 14:05:17',1,'2018-06-22 14:05:17',0),(75,75,14,'TCHR',15,'GMTR',1,'2018-06-22 14:10:41',1,'2018-06-22 14:10:41',0),(76,76,14,'TCHR',15,'CALS',1,'2018-06-22 14:13:19',1,'2018-06-22 14:13:19',0),(77,77,14,'TCHR',15,'STAT',1,'2018-06-22 14:14:45',1,'2018-06-22 14:14:45',0),(78,78,14,'TCHR',15,'FRCH',1,'2018-06-22 14:21:07',1,'2018-06-22 14:21:07',0),(79,79,14,'TCHR',15,'LATN',1,'2018-06-22 14:22:14',1,'2018-06-22 14:22:14',0),(80,80,14,'TCHR',15,'SPNS',1,'2018-06-22 14:22:56',1,'2018-06-22 14:22:56',0),(81,81,14,'TCHR',15,'FNAT',1,'2018-06-22 14:23:36',1,'2018-06-22 14:23:36',0);
/*!40000 ALTER TABLE `sys_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_users`
--

DROP TABLE IF EXISTS `sys_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL_ADDRESS` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
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
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  `OCCUPATION` varchar(2048) DEFAULT '',
  `INTERESTS` varchar(2048) DEFAULT '',
  `ABOUT_ME` varchar(10000) DEFAULT '',
  `WEBSITE_URL` varchar(2048) DEFAULT '',
  `TWITTER_URL` varchar(2048) DEFAULT '',
  `FACEBOOK_URL` varchar(2048) DEFAULT '',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_users`
--

LOCK TABLES `sys_users` WRITE;
/*!40000 ALTER TABLE `sys_users` DISABLE KEYS */;
INSERT INTO `sys_users` VALUES (1,'useradmin@gmail.com','e6e061838856bf47e1de730719fb2609','User Admin','User','Admin','',1,'APPC','useradmin@gmail.com','0000-00-00 00:00:00',2,'MALE','785-969-9492',1,'2017-03-23 19:03:03',1,'2017-03-23 19:03:03',0,'','','','','',''),(2,'community.user@gmail.com','25d55ad283aa400af464c76d713c07ad','Community User','Community','User','\\ProfilePictures\\pp_2.jpg',1,'APPC','community.user@gmail.com',NULL,0,NULL,NULL,1,'2017-03-27 16:27:04',1,'2017-03-27 16:27:04',0,NULL,NULL,NULL,NULL,NULL,NULL),(12,'florence.butler68@curiousdrive.com','a5e89ea03e68fd6b0ecdd77b3e04d00c','Florence Butler','Florence','Butler','\\ProfilePictures\\pp_12.jpg',1,'APPC','florence.butler68@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:46:28',1,'2018-02-27 10:46:28',0,NULL,NULL,NULL,NULL,NULL,NULL),(13,'matthew.brooks21@curiousdrive.com','8dbe630d355a9db36f590d8656892171','Matthew Brooks','Matthew','Brooks','\\ProfilePictures\\pp_13.jpg',1,'APPC','matthew.brooks21@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:48:00',1,'2018-02-27 10:48:00',0,NULL,NULL,NULL,NULL,NULL,NULL),(14,'patsy.harris30@curiousdrive.com','2a13ea5e71a1f269f041de3bba896a87','Patsy Harris','Patsy','Harris','\\ProfilePictures\\pp_14.jpg',1,'APPC','patsy.harris30@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:48:51',1,'2018-02-27 10:48:51',0,NULL,NULL,NULL,NULL,NULL,NULL),(15,'noah.peters58@curiousdrive.com','59cb0e4019d519386ef88731c5e38908','Noah Peters','Noah','Peters','\\ProfilePictures\\pp_15.jpg',1,'APPC','noah.peters58@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:49:35',1,'2018-02-27 10:49:35',0,NULL,NULL,NULL,NULL,NULL,NULL),(16,'ritthy.fox48@curiousdrive.com','3436b49ed28e51b509b9ad5f3b85f6e0','Ritthy Fox','Ritthy','Fox','\\ProfilePictures\\pp_16.jpg',1,'APPC','ritthy.fox48@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:49:58',1,'2018-02-27 10:49:58',0,NULL,NULL,NULL,NULL,NULL,NULL),(17,'gertrude.morris19@curiousdrive.com','0a2ec6df59c5aec1b208599113216d6d','Gertrude Morris','Gertrude','Morris','\\ProfilePictures\\pp_17.jpg',1,'APPC','gertrude.morris19@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:50:33',1,'2018-02-27 10:50:33',0,NULL,NULL,NULL,NULL,NULL,NULL),(18,'ralph.wagner50@curiousdrive.com','50c3b8e520e2856a5865169f1282e67d','Ralph Wagner','Ralph','Wagner','\\ProfilePictures\\pp_18.jpg',1,'APPC','ralph.wagner50@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:50:56',1,'2018-02-27 10:50:56',0,NULL,NULL,NULL,NULL,NULL,NULL),(19,'leona.perez44@curiousdrive.com','06b50f8773bc35aa8ad9f1f3a061a052','Leona Perez','Leona','Perez','\\ProfilePictures\\pp_19.jpg',1,'APPC','leona.perez44@curiousdrive.com',NULL,0,NULL,'999-999-9999',1,'2018-02-27 00:00:00',0,'2018-03-11 14:13:10',0,NULL,NULL,NULL,NULL,NULL,NULL),(20,'arron.cox92@curiousdrive.com','ca83539b6e432c00632d6fecf348a620','Arron Cox','Arron','Cox','\\ProfilePictures\\pp_20.jpg',1,'APPC','arron.cox92@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:51:46',1,'2018-02-27 10:51:46',0,NULL,NULL,NULL,NULL,NULL,NULL),(21,'liam.bradley28@curiousdrive.com','e03870968d12cba3a1ed28932cdd3ff8','Liam Bradley','Liam','Bradley','\\ProfilePictures\\pp_21.jpg',1,'APPC','liam.bradley28@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:52:06',1,'2018-02-27 10:52:06',0,NULL,NULL,NULL,NULL,NULL,NULL),(22,'hunter.rodriquez23@curiousdrive.com','c7242f0aff597508c966af11876db01e','Hunter Rodriquez','Hunter','Rodriquez','\\ProfilePictures\\pp_22.jpg',1,'APPC','hunter.rodriquez23@curiousdrive.com',NULL,0,NULL,'7859699492',1,'2018-02-27 00:00:00',0,'2018-03-22 13:26:29',0,NULL,NULL,NULL,NULL,NULL,NULL),(23,'jimmy.carr41@curiousdrive.com','5b1a64b4201d6b32cb14ef698a7a96fe','Jimmy Carr','Jimmy','Carr','\\ProfilePictures\\pp_23.jpg',1,'APPC','jimmy.carr41@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:52:53',1,'2018-02-27 10:52:53',0,NULL,NULL,NULL,NULL,NULL,NULL),(24,'sarah.horton16@curiousdrive.com','d544a1865ffdc5f8c0a463f5448884a6','Sarah Horton','Sarah','Horton','\\ProfilePictures\\pp_24.jpg',1,'APPC','sarah.horton16@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:53:18',1,'2018-02-27 10:53:18',0,NULL,NULL,NULL,NULL,NULL,NULL),(25,'riley.powell33@curiousdrive.com','f5c26deb1bb78db09cff5690f94baa04','Riley Powell','Riley','Powell',NULL,1,'APPC','riley.powell33@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:53:39',1,'2018-02-27 10:53:39',0,NULL,NULL,NULL,NULL,NULL,NULL),(26,'beatrice.harrison19@curiousdrive.com','75e189f3a1aa1350fc76cd71190497fa','Beatrice Harrison','Beatrice','Harrison','\\ProfilePictures\\pp_26.jpg',1,'APPC','beatrice.harrison19@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:54:06',1,'2018-02-27 10:54:06',0,NULL,NULL,NULL,NULL,NULL,NULL),(27,'kylie.kelley38@curiousdrive.com','1cc70dc39f44bb167f2a31140f2b25fa','Kylie Kelley','Kylie','Kelley','\\ProfilePictures\\pp_27.jpg',1,'APPC','kylie.kelley38@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:54:30',1,'2018-02-27 10:54:30',0,NULL,NULL,NULL,NULL,NULL,NULL),(28,'leo.cole59@curiousdrive.com','a7f61fa9b013e583b20ac58d2546b908','Leo Cole','Leo','Cole','\\ProfilePictures\\pp_28.jpg',1,'APPC','leo.cole59@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 10:54:58',1,'2018-02-27 10:54:58',0,NULL,NULL,NULL,NULL,NULL,NULL),(29,'gail.baker76@curiousdrive.com','7ee683e9c07adaa1f46e4ec52cfd123f','Gail Baker','Gail','Baker','\\ProfilePictures\\pp_29.jpg',1,'APPC','gail.baker76@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:17:20',1,'2018-02-27 11:17:20',0,NULL,NULL,NULL,NULL,NULL,NULL),(30,'ritthy.reid40@curiousdrive.com','c945f422b0626f5412c7b494384e4575','Ritthy Reid','Ritthy','Reid','\\ProfilePictures\\pp_30.jpg',1,'APPC','ritthy.reid40@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:17:44',1,'2018-02-27 11:17:44',0,NULL,NULL,NULL,NULL,NULL,NULL),(31,'suzanne.king32@curiousdrive.com','9ca152e80a889309e43135aa262723d2','Suzanne King','Suzanne','King','\\ProfilePictures\\pp_31.jpg',1,'APPC','suzanne.king32@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:18:08',1,'2018-02-27 11:18:08',0,NULL,NULL,NULL,NULL,NULL,NULL),(32,'marie.cox79@curiousdrive.com','751bdebc6ae05d1971ded794e13835a1','Marie Cox','Marie','Cox',NULL,1,'APPC','marie.cox79@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:18:33',1,'2018-02-27 11:18:33',0,NULL,NULL,NULL,NULL,NULL,NULL),(33,'carlos.castro48@curiousdrive.com','9e5dc17bbb9cc1847b31b7ebced3ae93','Carlos Castro','Carlos','Castro','\\ProfilePictures\\pp_33.jpg',1,'APPC','carlos.castro48@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:19:02',1,'2018-02-27 11:19:02',0,NULL,NULL,NULL,NULL,NULL,NULL),(34,'max.reid75@curiousdrive.com','5da2777dc2f3732552734d4d632f06bd','Max Reid','Max','Reid','\\ProfilePictures\\pp_34.jpg',1,'APPC','max.reid75@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:19:26',1,'2018-02-27 11:19:26',0,NULL,NULL,NULL,NULL,NULL,NULL),(35,'ronald.welch47@curiousdrive.com','b6c5a14b79d0a8569a8f4c8af1869577','Ronald Welch','Ronald','Welch','\\ProfilePictures\\pp_35.jpg',1,'APPC','ronald.welch47@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:19:57',1,'2018-02-27 11:19:57',0,NULL,NULL,NULL,NULL,NULL,NULL),(36,'kevin.collins34@curiousdrive.com','ec175d9189cd9f839e23436c06744917','Kevin Collins','Kevin','Collins','\\ProfilePictures\\pp_36.jpg',1,'APPC','kevin.collins34@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:20:16',1,'2018-02-27 11:20:16',0,NULL,NULL,NULL,NULL,NULL,NULL),(37,'jacqueline.spencer16@curiousdrive.com','2bb9d42df8058ef15bc21f79b8c88e04','Jacqueline Spencer','Jacqueline','Spencer','\\ProfilePictures\\pp_37.jpg',1,'APPC','jacqueline.spencer16@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:20:39',1,'2018-02-27 11:20:39',0,NULL,NULL,NULL,NULL,NULL,NULL),(38,'catherine.griffin61@curiousdrive.com','8d3ef748dfd2d361a541addbf302343e','catherine griffin','catherine','griffin','\\ProfilePictures\\pp_38.jpg',1,'APPC','catherine.griffin61@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:21:06',1,'2018-02-27 11:21:06',0,NULL,NULL,NULL,NULL,NULL,NULL),(39,'william.curtis71@curiousdrive.com','03da89a95de9801ff34d3202beee841a','William Curtis','William','Curtis',NULL,1,'APPC','william.curtis71@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:21:47',1,'2018-02-27 11:21:47',0,NULL,NULL,NULL,NULL,NULL,NULL),(40,'kenzi.richardson26@curiousdrive.com','0f2360e58ce8cbda5dca06dc6fc36894','Kenzi Richardson','Kenzi','Richardson','\\ProfilePictures\\pp_40.jpg',1,'APPC','kenzi.richardson26@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:30:51',1,'2018-02-27 11:30:51',0,NULL,NULL,NULL,NULL,NULL,NULL),(41,'jack.phillips72@curiousdrive.com','2c2194ca07a09576d92a3ddc7995db87','Jack Phillips','Jack','Phillips','\\ProfilePictures\\pp_41.jpg',1,'APPC','jack.phillips72@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:31:16',1,'2018-02-27 11:31:16',0,NULL,NULL,NULL,NULL,NULL,NULL),(42,'victor.marshall94@curiousdrive.com','73d309fbbcbe36e11485c55d42fd1be3','Victor Marshall','Victor','Marshall','\\ProfilePictures\\pp_42.jpg',1,'APPC','victor.marshall94@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:31:38',1,'2018-02-27 11:31:38',0,NULL,NULL,NULL,NULL,NULL,NULL),(43,'marian.burns62@curiousdrive.com','aadae78bb16b08904adbb5ab5f001363','Marian Burns','Marian','Burns','\\ProfilePictures\\pp_43.jpg',1,'APPC','marian.burns62@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:32:00',1,'2018-02-27 11:32:00',0,NULL,NULL,NULL,NULL,NULL,NULL),(44,'ronald.peters56@curiousdrive.com','c5265d3cf4c80fd1c9557621f2992c06','Ronald Peters','Ronald','Peters','\\ProfilePictures\\pp_44.jpg',1,'APPC','ronald.peters56@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:32:25',1,'2018-02-27 11:32:25',0,NULL,NULL,NULL,NULL,NULL,NULL),(45,'erin.morris25@curiousdrive.com','c7816be64d4e6dfb71148b7cfd9eb84a','Erin Morris','Erin','Morris','\\ProfilePictures\\pp_45.jpg',1,'APPC','erin.morris25@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:32:49',1,'2018-02-27 11:32:49',0,NULL,NULL,NULL,NULL,NULL,NULL),(46,'juan.holt10@curiousdrive.com','e704cc6cd67306aa5e497312d4442ffb','Juan Holt','Juan','Holt','\\ProfilePictures\\pp_46.jpg',1,'APPC','juan.holt10@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:33:09',1,'2018-02-27 11:33:09',0,NULL,NULL,NULL,NULL,NULL,NULL),(47,'joe.watson17@curiousdrive.com','1dce5367839e4be63d03b6dee6107edc','Joe Watson','Joe','Watson','\\ProfilePictures\\pp_47.jpg',1,'APPC','joe.watson17@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:33:30',1,'2018-02-27 11:33:30',0,NULL,NULL,NULL,NULL,NULL,NULL),(48,'shane.castro24@curiousdrive.com','61f3ff4b4b8bd1360107fc8df3cfa69c','Shane Castro','Shane','Castro','\\ProfilePictures\\pp_48.jpg',1,'APPC','shane.castro24@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:34:39',1,'2018-02-27 11:34:39',0,NULL,NULL,NULL,NULL,NULL,NULL),(49,'madison.hunter48@curiousdrive.com','c445e21f5cc6b3d589b813ea653b807d','Madison Hunter','Madison','Hunter','\\ProfilePictures\\pp_49.jpg',1,'APPC','madison.hunter48@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:35:13',1,'2018-02-27 11:35:13',0,NULL,NULL,NULL,NULL,NULL,NULL),(50,'robin.alexander58@curiousdrive.com','9e79a82b87aedf77759d10e5a1bb4616','Robin Alexander','Robin','Alexander','\\ProfilePictures\\pp_50.jpg',1,'APPC','robin.alexander58@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:35:37',1,'2018-02-27 11:35:37',0,NULL,NULL,NULL,NULL,NULL,NULL),(51,'darryl.montgomery88@curiousdrive.com','2d037a24edc984c79af0684f494cee66','Darryl Montgomery','Darryl','Montgomery','\\ProfilePictures\\pp_51.jpg',1,'APPC','darryl.montgomery88@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:35:57',1,'2018-02-27 11:35:57',0,NULL,NULL,NULL,NULL,NULL,NULL),(52,'holly.holland76@curiousdrive.com','317bbd000c516ee9739d2dd8bf458e85','Holly Holland','Holly','Holland','\\ProfilePictures\\pp_52.jpg',1,'APPC','holly.holland76@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:36:20',1,'2018-02-27 11:36:20',0,NULL,NULL,NULL,NULL,NULL,NULL),(53,'ruben.flores63@curiousdrive.com','22ec96c1d14fd0b31d4bb611a073dd2e','Ruben Flores','Ruben','Flores','\\ProfilePictures\\pp_53.jpg',1,'APPC','ruben.flores63@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:36:41',1,'2018-02-27 11:36:41',0,NULL,NULL,NULL,NULL,NULL,NULL),(54,'billy.martinez67@curiousdrive.com','ab8a1d975d27f8123b3fdb0668365d54','Billy Martinez','Billy','Martinez','\\ProfilePictures\\pp_54.jpg',1,'APPC','billy.martinez67@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:37:31',1,'2018-02-27 11:37:31',0,NULL,NULL,NULL,NULL,NULL,NULL),(55,'valerie.patterson64@curiousdrive.com','c5961fad099e00b21206bc9aa4229695','Valerie Patterson','Valerie','Patterson','\\ProfilePictures\\pp_55.jpg',1,'APPC','valerie.patterson64@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:38:25',1,'2018-02-27 11:38:25',0,NULL,NULL,NULL,NULL,NULL,NULL),(56,'tanya.montgomery52@curiousdrive.com','692630084f35548528893d678d93be43','Tanya Montgomery','Tanya','Montgomery','\\ProfilePictures\\pp_56.jpg',1,'APPC','tanya.montgomery52@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:38:49',1,'2018-02-27 11:38:49',0,NULL,NULL,NULL,NULL,NULL,NULL),(57,'pearl.alvarez10@curiousdrive.com','49ed5f46724998a5505700ce64c9d5a6','Pearl Alvarez','Pearl','Alvarez','\\ProfilePictures\\pp_57.jpg',1,'APPC','pearl.alvarez10@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:39:12',1,'2018-02-27 11:39:12',0,NULL,NULL,NULL,NULL,NULL,NULL),(58,'melinda.wood68@curiousdrive.com','58ebd88ba00d367611ef289540e80ff1','Melinda Wood','Melinda','Wood','\\ProfilePictures\\pp_58.jpg',1,'APPC','melinda.wood68@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:39:37',1,'2018-02-27 11:39:37',0,NULL,NULL,NULL,NULL,NULL,NULL),(59,'rachel.elliott81@curiousdrive.com','2aa7daf2d1524f7923dbaec5d5afaf12','Rachel Elliott','Rachel','Elliott','\\ProfilePictures\\pp_59.jpg',1,'APPC','rachel.elliott81@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:40:36',1,'2018-02-27 11:40:36',0,NULL,NULL,NULL,NULL,NULL,NULL),(60,'emily.mills97@curiousdrive.com','9d95e3d9689ec9524dcd1793d0eb3ef1','Emily Mills','Emily','Mills','',1,'APPC','emily.mills97@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-02-27 11:40:57',1,'2018-02-27 11:40:57',0,NULL,NULL,NULL,NULL,NULL,NULL),(61,'esther.kelly25@curiousdrive.com','6189730f513eea875d21a23dfc710d0a','Esther Kelly','Esther','Kelly',NULL,1,'APPC','esther.kelly25@example.com',NULL,0,NULL,NULL,1,'2018-04-22 20:53:42',1,'2018-04-22 20:53:42',0,NULL,NULL,NULL,NULL,NULL,NULL),(62,'steve.rogers43@curiousdrive.com','b395da97665b8ab5b020f4ca915332e6','Steve Rogers','Steve','Rogers',NULL,1,'APPC','steve.rogers43@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-04-27 11:20:34',1,'2018-04-27 11:20:34',0,NULL,NULL,NULL,NULL,NULL,NULL),(63,'erin.elliott54@curiousdrive.com','9568ca058348f32c16e3dd4529783b0d','Erin Elliott','Erin','Elliott',NULL,1,'APPC','erin.elliott54@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-04-27 11:24:02',1,'2018-04-27 11:24:02',0,NULL,NULL,NULL,NULL,NULL,NULL),(64,'vincent.berry99@curiousdrive.com','de530f9b2f0f86d3f6939b6b7f64c16d','Vincent  Berry','Vincent ','Berry',NULL,1,'APPC','vincent.berry99@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-21 13:49:42',1,'2018-06-21 13:49:42',0,NULL,NULL,NULL,NULL,NULL,NULL),(65,'glen.olson28@curiousdrive.com','a4e47c271c3fea1d78b9fc74c2682469','Glen  Olson','Glen ','Olson',NULL,1,'APPC','glen.olson28@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-21 15:56:54',1,'2018-06-21 15:56:54',0,NULL,NULL,NULL,NULL,NULL,NULL),(66,'shelly.powell99@curiousdrive.com','da5d8cecea56ae4a1f0c2ec450e28236','Shelly  Powell','Shelly ','Powell',NULL,1,'APPC','shelly.powell99@curious.com',NULL,0,NULL,NULL,1,'2018-06-22 13:59:00',1,'2018-06-22 13:59:00',0,NULL,NULL,NULL,NULL,NULL,NULL),(67,'don.carpenter59@curiousdrive.com','9d646b1b4e85e391a319f5c03ec8dc80','Don  Carpenter','Don ','Carpenter',NULL,1,'APPC','don.carpenter59@curious.com',NULL,0,NULL,NULL,1,'2018-06-22 13:59:46',1,'2018-06-22 13:59:46',0,NULL,NULL,NULL,NULL,NULL,NULL),(68,' lena.hudson17@curiousdrive.com','5c5046f676f3dfcebb293b675004d7af','Lena  Hudson','Lena ','Hudson',NULL,1,'APPC',' lena.hudson17@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:00:52',1,'2018-06-22 14:00:52',0,NULL,NULL,NULL,NULL,NULL,NULL),(69,'patrick.gilbert19@curiousdrive.com','04e2a8bd96679e29a61cd259e0155847','Patrick  Gilbert','Patrick ','Gilbert',NULL,1,'APPC','patrick.gilbert19@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:01:32',1,'2018-06-22 14:01:32',0,NULL,NULL,NULL,NULL,NULL,NULL),(70,'wallace.turner61@curiousdrive.com','f9741dc5efe1951806e7cf1206ea8adb','Wallace  Turner','Wallace ','Turner',NULL,1,'APPC','wallace.turner61@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:02:15',1,'2018-06-22 14:02:15',0,NULL,NULL,NULL,NULL,NULL,NULL),(71,'alexander.mckinney73@curiousdrive.com','a703b978ca17f4a52cb5198fb6bf5d75','Alexander  Mckinney','Alexander ','Mckinney',NULL,1,'APPC','alexander.mckinney73@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:02:57',1,'2018-06-22 14:02:57',0,NULL,NULL,NULL,NULL,NULL,NULL),(72,'tanya.holmes27@curiousdrive.com','9159af1b603a813ca8b0732d660cd7c0','Tanya  Holmes','Tanya ','Holmes',NULL,1,'APPC','tanya.holmes27@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:03:35',1,'2018-06-22 14:03:35',0,NULL,NULL,NULL,NULL,NULL,NULL),(73,'bruce.stevens37@curiousdrive.com','4d41d5fa5cfb7edee62347d0a345b3a2','Bruce  Stevens','Bruce ','Stevens',NULL,1,'APPC','bruce.stevens37@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:04:27',1,'2018-06-22 14:04:27',0,NULL,NULL,NULL,NULL,NULL,NULL),(74,'billy.sullivan19@curiousdrive.com','841c5ce631bdfef7b922d3f6ac6e166b','Billy  Sullivan','Billy ','Sullivan',NULL,1,'APPC','billy.sullivan19@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:05:17',1,'2018-06-22 14:05:17',0,NULL,NULL,NULL,NULL,NULL,NULL),(75,'marsha.phillips32@curiousdrive.com','e2ce665cef65921ee9c3ac70a03a1a95','Marsha  Phillips','Marsha ','Phillips',NULL,1,'APPC','marsha.phillips32@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:10:41',1,'2018-06-22 14:10:41',0,NULL,NULL,NULL,NULL,NULL,NULL),(76,'kristina.bennett19@curiousdrive.com','446161dea948b7b3cf76a19becba1e88','Kristina  Bennett','Kristina ','Bennett',NULL,1,'APPC','kristina.bennett19@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:13:19',1,'2018-06-22 14:13:19',0,NULL,NULL,NULL,NULL,NULL,NULL),(77,'charlotte.mitchelle14@curiousdrive.com','220f837e7b3be6216d8169976341265d','Charlotte  Mitchelle','Charlotte ','Mitchelle',NULL,1,'APPC','charlotte.mitchelle14@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:14:45',1,'2018-06-22 14:14:45',0,NULL,NULL,NULL,NULL,NULL,NULL),(78,'jessie.ryan92@curiousdrive.com','acf6bad758acf7d3ff49b6118f8cdf80','Jessie  Ryan','Jessie ','Ryan',NULL,1,'APPC','jessie.ryan92@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:21:07',1,'2018-06-22 14:21:07',0,NULL,NULL,NULL,NULL,NULL,NULL),(79,'andy.knight41@curiousdrive.com','abb688e3c6101023dd4e4fcace06fe80','Andy  Knight','Andy ','Knight',NULL,1,'APPC','andy.knight41@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:22:14',1,'2018-06-22 14:22:14',0,NULL,NULL,NULL,NULL,NULL,NULL),(80,'javier.hughes51@curiousdrive.com','1091cac92e5bb0ac8225331691f42407','Javier Hughes','Javier','Hughes',NULL,1,'APPC','javier.hughes51@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:22:56',1,'2018-06-22 14:22:56',0,NULL,NULL,NULL,NULL,NULL,NULL),(81,'meghan.cruz92@curiousdrive.com','813a3967e1a52ffa02002e341532647c','Meghan  Cruz','Meghan ','Cruz',NULL,1,'APPC','meghan.cruz92@curiousdrive.com',NULL,0,NULL,NULL,1,'2018-06-22 14:23:36',1,'2018-06-22 14:23:36',0,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_categories`
--

DROP TABLE IF EXISTS `tran_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_categories` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY` varchar(100) DEFAULT NULL,
  `DESCRIPTION` mediumtext,
  `THREAD_ID` int(11) DEFAULT NULL,
  `STATUS_ID` int(11) NOT NULL,
  `STATUS_VALUE` varchar(50) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`),
  UNIQUE KEY `CATEGORY` (`CATEGORY`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_categories`
--

LOCK TABLES `tran_categories` WRITE;
/*!40000 ALTER TABLE `tran_categories` DISABLE KEYS */;
INSERT INTO `tran_categories` VALUES (1,'World Literature','World literature is sometimes used to refer to the sum total of the world\'s national literature, but usually, it refers to the circulation of works into the wider world beyond their country of origin. Often used in the past primarily for masterpieces of Western European literature, world literature today is increasingly seen in global context. Readers today have access to an unprecedented range of works from around the world in excellent translations, and since the mid-1990s a lively debate has grown up concerning both the aesthetic and the political values and limitations of an emphasis on global processes over national traditions.',1,6,'CATA',2,'2018-06-10 15:45:20',2,'2018-06-10 15:45:20',0),(2,'European Literature','European literature refers to the literature of Europe.\r\nEuropean literature includes literature in many languages; among the most important of the modern written works are those in English, Spanish, French, Dutch, Polish, German, Italian, Modern Greek, Czech, Russian, Bosnian and works by the Scandinavians and Irish.\r\nImportant classical and medieval traditions are those in Latin, Ancient Greek, Old Norse, Medieval French and the Italian Tuscan dialect of the renaissance.\r\nIn colloquial speech, European literature often is used as a synonym for Western literature.\r\nEuropean literature is a part of world literature. ',1,6,'CATA',2,'2018-06-10 15:50:21',2,'2018-06-10 15:50:21',0),(3,'English Language','English is a West Germanic language that was first spoken in early medieval England and is now a global lingua franca. Named after the Angles, one of the Germanic tribes that migrated to England, it ultimately derives its name from the Anglia (Angeln) peninsula in the Baltic Sea. It is closely related to the Frisian languages, but its vocabulary has been significantly influenced by other Germanic languages, particularly Norse (a North Germanic language), as well as by Latin and French.',1,6,'CATA',2,'2018-06-10 16:00:33',2,'2018-06-10 16:00:33',0),(4,'English Literature','This article is focused on English-language literature rather than the literature of England, so that it includes writers from Scotland, Wales, and the whole of Ireland, as well as literature in English from countries of the former British Empire, including the United States. However, until the early 19th century, it only deals with the literature of the United Kingdom and Ireland. It does not include literature written in the other languages of Britain.',1,6,'CATA',2,'2018-06-10 16:35:55',2,'2018-06-10 16:35:55',0),(5,'World History','World history or global history (not to be confused with diplomatic, transnational or international history) is a field of historical study that emerged as a distinct academic field in the 1980s. It examines history from a global perspective. It is not to be confused with comparative history, which, like world history, deals with the history of multiple cultures and nations, but does not do so on a global scale. World history looks for common patterns that emerge across all cultures. World historians use a thematic approach, with two major focal points: integration (how processes of world history have drawn people of the world together) and difference (how patterns of world history reveal the diversity of the human experiences)',1,6,'CATA',2,'2018-06-10 16:39:19',2,'2018-06-10 16:39:19',0),(6,'Human Geography','Human geography is the branch of geography that deals with the study of people and their communities, cultures, economies, and interactions with the environment by studying their relations with and across space and place. Human geography attends to human patterns of social interaction, as well as spatial level interdependencies, and how they influence or affect the earth\'s environment. As an intellectual discipline, geography is divided into the sub-fields of physical geography and human geography, the latter concentrating upon the study of human activities, by the application of qualitative and quantitative research methods.',1,6,'CATA',2,'2018-06-10 16:44:11',2,'2018-06-10 16:44:11',0),(7,'Psychology','Psychology is the science of behavior and mind, including conscious and unconscious phenomena, as well as feeling and thought. It is an academic discipline of immense scope and diverse interests that, when taken together, seek an understanding of the emergent properties of brains, and all the variety of epiphenomena they manifest. As a social science, it aims to understand individuals and groups by establishing general principles and researching specific cases.',1,6,'CATA',2,'2018-06-10 16:46:49',2,'2018-06-10 16:46:49',0),(8,'U.S. History','The history of the United States began with the settlement of Indigenous people before 10,000 BC. Numerous cultures formed. The arrival of Christopher Columbus in 1492 started the European colonization of the Americas. Most colonies formed after 1600. By the 1770s, thirteen British colonies contained 2.5 million people along the Atlantic coast east of the Appalachian Mountains. After defeating France, the British government imposed a series of new taxes after 1765, rejecting the colonists\' argument that new taxes needed their approval (see Stamp Act 1765). Tax resistance, especially the Boston Tea Party (1773), led to punitive laws by Parliament designed to end self-government in Massachusetts.',1,6,'CATA',2,'2018-06-10 16:48:45',2,'2018-06-10 16:48:45',0),(9,'Chemistry','Chemistry is the scientific discipline involved with compounds composed of atoms, i.e. elements, and molecules, i.e. combinations of atoms: their composition, structure, properties, behavior and the changes they undergo during a reaction with other compounds. Chemistry addresses topics such as how atoms and molecules interact via chemical bonds to form new chemical compounds. There are four types of chemical bonds: covalent bonds, in which compounds share one or more electron(s); ionic bonds, in which a compound donates one or more electrons to another compound to produce ions (cations and anions); hydrogen bonds; and Van der Waals force bonds.',1,6,'CATA',2,'2018-06-10 16:52:48',2,'2018-06-10 16:52:48',0),(10,'Biology','Biology is the natural science that studies life and living organisms, including their physical structure, chemical composition, function, development and evolution. Despite the complexity of the science, there are certain unifying concepts that consolidate it into a single, coherent field. Biology recognizes the cell as the basic unit of life, genes as the basic unit of heredity, and evolution as the engine that propels the creation and extinction of species. Living organisms are open systems that survive by transforming energy and decreasing their local entropy to maintain a stable and vital condition defined as homeostasis.',1,6,'CATA',2,'2018-06-10 16:57:18',2,'2018-06-10 16:57:18',0),(11,'Anatomy','Anatomy (Greek  “dissection”) is the branch of biology concerned with the study of the structure of organisms and their parts. Anatomy is a branch of natural science dealing with the structural organization of living things. It is an old science, having its beginnings in prehistoric times. Anatomy is inherently tied to embryology, comparative anatomy, evolutionary biology, and phylogeny, as these are the processes by which anatomy is generated over immediate (embryology) and long (evolution) timescales. Human anatomy is one of the basic essential sciences of medicine. Anatomy and physiology, which study (respectively) the structure and function of organisms and their parts, make a natural pair of related disciplines, and they are often studied together.',1,6,'CATA',2,'2018-06-10 17:10:19',2,'2018-06-10 17:10:19',0),(12,'Physiology','Physiology is the scientific study of normal mechanisms, and their interactions, which work within a living system. A sub-discipline of biology, its focus is in how organisms, organ systems, organs, cells, and bio-molecules carry out the chemical or physical functions that exist in a living system. Given the size of the field, it is divided into, among others, animal physiology (including that of humans), plant physiology, cellular physiology, microbial physiology (microbial metabolism), bacterial physiology, and viral physiology.',1,6,'CATA',2,'2018-06-10 17:16:17',2,'2018-06-10 17:16:17',0),(13,'Physics','Physics, transit, lit. \'knowledge of nature\' is the natural science that studies the matter and its motion and behavior through space and time and that studies the related entities of energy and force. Physics is one of the most fundamental scientific disciplines, and its main goal is to understand how the universe behaves.',1,6,'CATA',2,'2018-06-10 17:21:21',2,'2018-06-10 17:21:21',0),(14,'Algebra','Algebra is one of the broad parts of mathematics, together with number theory, geometry and analysis. In its most general form, algebra is the study of mathematical symbols and the rules for manipulating these symbols. it is a unifying thread of almost all of mathematics. As such, it includes everything from elementary equation solving to the study of abstractions such as groups, rings, and fields. The more basic parts of algebra are called elementary algebra; the more abstract parts are called abstract algebra or modern algebra. Elementary algebra is generally considered to be essential for any study of mathematics, science, or engineering, as well as such applications as medicine and economics. Abstract algebra is a major area in advanced mathematics, studied primarily by professional mathematicians.',1,6,'CATA',2,'2018-06-10 17:28:38',2,'2018-06-10 17:28:38',0),(15,'Geometry','Geometry is a branch of mathematics concerned with questions of shape, size, the relative position of figures, and the properties of space. A mathematician who works in the field of geometry is called a geometer.',1,6,'CATA',2,'2018-06-10 17:30:11',2,'2018-06-10 17:30:11',0),(16,'Calculus','Calculus (from Latin calculus, literally \'small pebble\', used for counting and calculations, as on an abacus), is the mathematical study of continuous change, in the same way, that geometry is the study of shape and algebra is the study of generalizations of arithmetic operations.',1,6,'CATA',2,'2018-06-10 17:33:31',2,'2018-06-10 17:33:31',0),(17,'Statistics','Statistics is a branch of mathematics dealing with the collection, analysis, interpretation, presentation, and organization of data. In applying statistics to, for example, a scientific, industrial, or social problem, it is conventional to begin with a statistical population or a statistical model process to be studied. Populations can be diverse topics such as \"all people living in a country\" or \"every atom composing a crystal\". Statistics deals with all aspects of data including the planning of data collection in terms of the design of surveys and experiments. See glossary of probability and statistics.',1,6,'CATA',2,'2018-06-10 17:37:04',2,'2018-06-10 17:37:04',0),(18,'French','French is a Romance language of the Indo-European family. It descended from the Vulgar Latin of the Roman Empire, as did all Romance languages. French has evolved from Gallo-Romance, spoken Latin in Gaul, and more specifically in Northern Gaul. Its closest relatives are the other languages d\'oïl—languages historically spoken in northern France and in southern Belgium, which French (Francien) has largely supplanted. French was also influenced by native Celtic languages of Northern Roman Gaul like Gallia Belgica and by the (Germanic) Frankish language of the post-Roman Frankish invaders. Today, owing to France\'s past overseas expansion, there are numerous French-based creole languages, most notably Haitian Creole. A French-speaking person or nation may be referred to as Francophone in both English and French.',1,6,'CATA',2,'2018-06-10 17:54:54',2,'2018-06-10 17:54:54',0),(19,'Latin','Latin is a classical language belonging to the Italic branch of the Indo-European languages. The Latin alphabet is derived from the Etruscan and Greek alphabets, and ultimately from the Phoenician alphabet.',1,6,'CATA',2,'2018-06-10 17:57:58',2,'2018-06-10 17:57:58',0),(20,'Spanish','Spanish is a Western Romance language that originated in the Castile region of Spain and today has hundreds of millions of native speakers in Latin America and Spain. It is usually considered the world\'s second-most spoken native language, after Mandarin Chinese.',1,6,'CATA',2,'2018-06-10 18:01:59',2,'2018-06-10 18:01:59',0),(21,'Fine Arts','In European academic traditions, fine art is art developed primarily for aesthetics or beauty, distinguishing it from applied art, which also has to serve some practical function, such as pottery or most metalwork.',1,6,'CATA',2,'2018-06-10 18:22:31',2,'2018-06-10 18:22:31',0),(22,'Physical Education','Physical education, also known as Phys Ed., PE, Gym, or Gym class, and known in many Commonwealth countries as physical training or PT is an educational course related of maintaining the human body through physical exercises (i.e. calisthenics). It is taken during primary and secondary education and encourages psychomotor learning in a play or movement exploration setting to promote health.',1,6,'CATA',2,'2018-06-10 18:25:11',2,'2018-06-10 18:25:11',0);
/*!40000 ALTER TABLE `tran_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_comments`
--

DROP TABLE IF EXISTS `tran_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_comments` (
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
  `QUESTION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`COMMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_comments`
--

LOCK TABLES `tran_comments` WRITE;
/*!40000 ALTER TABLE `tran_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_comments` ENABLE KEYS */;
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
-- Table structure for table `tran_notifications`
--

DROP TABLE IF EXISTS `tran_notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_notifications` (
  `NOTIFICATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_notifications`
--

LOCK TABLES `tran_notifications` WRITE;
/*!40000 ALTER TABLE `tran_notifications` DISABLE KEYS */;
INSERT INTO `tran_notifications` VALUES (2,3,34,73,11,'ASKQ',3,0,0,'N','N',NULL,34,'2018-06-23 15:14:35',34,'2018-06-23 15:14:35',0),(3,4,35,74,11,'ASKQ',4,0,0,'N','N',NULL,35,'2018-06-23 15:23:50',35,'2018-06-23 15:23:50',0),(4,5,35,65,11,'ASKQ',5,0,0,'N','N',NULL,35,'2018-06-23 15:25:29',35,'2018-06-23 15:25:29',0),(5,6,61,66,11,'ASKQ',6,0,0,'N','N',NULL,61,'2018-06-23 15:30:03',61,'2018-06-23 15:30:03',0);
/*!40000 ALTER TABLE `tran_notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_points`
--

DROP TABLE IF EXISTS `tran_points`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_points` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_points`
--

LOCK TABLES `tran_points` WRITE;
/*!40000 ALTER TABLE `tran_points` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_points` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_post_votes`
--

DROP TABLE IF EXISTS `tran_post_votes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_post_votes` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_post_votes`
--

LOCK TABLES `tran_post_votes` WRITE;
/*!40000 ALTER TABLE `tran_post_votes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_post_votes` ENABLE KEYS */;
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
-- Table structure for table `tran_question_answers`
--

DROP TABLE IF EXISTS `tran_question_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_answers` (
  `QUESTION_ANSWER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `ANSWER_HTML` mediumtext COLLATE utf8_unicode_ci,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_ANSWER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_answers`
--

LOCK TABLES `tran_question_answers` WRITE;
/*!40000 ALTER TABLE `tran_question_answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_question_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_categories`
--

DROP TABLE IF EXISTS `tran_question_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_categories` (
  `QUESTION_CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` int(11) NOT NULL,
  `CATEGORY_ID` int(11) DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `UPDATE_SEQ` int(11) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_categories`
--

LOCK TABLES `tran_question_categories` WRITE;
/*!40000 ALTER TABLE `tran_question_categories` DISABLE KEYS */;
INSERT INTO `tran_question_categories` VALUES (2,3,13,0,'2018-06-23 15:14:35',0,'2018-06-23 15:14:35',0),(3,4,14,0,'2018-06-23 15:23:50',0,'2018-06-23 15:23:50',0),(4,5,4,0,'2018-06-23 15:25:29',0,'2018-06-23 15:25:29',0),(5,6,5,0,'2018-06-23 15:30:03',0,'2018-06-23 15:30:03',0);
/*!40000 ALTER TABLE `tran_question_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_favorites`
--

DROP TABLE IF EXISTS `tran_question_favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_favorites` (
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
-- Dumping data for table `tran_question_favorites`
--

LOCK TABLES `tran_question_favorites` WRITE;
/*!40000 ALTER TABLE `tran_question_favorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_question_favorites` ENABLE KEYS */;
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
-- Table structure for table `tran_question_valids`
--

DROP TABLE IF EXISTS `tran_question_valids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_valids` (
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
-- Dumping data for table `tran_question_valids`
--

LOCK TABLES `tran_question_valids` WRITE;
/*!40000 ALTER TABLE `tran_question_valids` DISABLE KEYS */;
/*!40000 ALTER TABLE `tran_question_valids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_question_views`
--

DROP TABLE IF EXISTS `tran_question_views`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_question_views` (
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_question_views`
--

LOCK TABLES `tran_question_views` WRITE;
/*!40000 ALTER TABLE `tran_question_views` DISABLE KEYS */;
INSERT INTO `tran_question_views` VALUES (19,3,34,'Chrome-67.0','::1',0,'2018-06-23 15:14:36',0,'2018-06-23 15:14:36',0),(20,4,35,'Chrome-67.0','::1',0,'2018-06-23 15:23:51',0,'2018-06-23 15:23:51',0),(21,5,35,'Chrome-67.0','::1',0,'2018-06-23 15:25:29',0,'2018-06-23 15:25:29',0),(22,6,61,'Chrome-67.0','::1',0,'2018-06-23 15:30:03',0,'2018-06-23 15:30:03',0),(23,5,61,'Chrome-67.0','::1',0,'2018-06-23 15:36:23',0,'2018-06-23 15:36:23',0),(24,3,61,'Chrome-67.0','::1',0,'2018-06-23 15:36:41',0,'2018-06-23 15:36:41',0),(25,6,0,'Chrome-67.0','::1',0,'2018-06-24 13:42:19',0,'2018-06-24 13:42:19',0);
/*!40000 ALTER TABLE `tran_question_views` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tran_questions`
--

DROP TABLE IF EXISTS `tran_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_questions` (
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tran_questions`
--

LOCK TABLES `tran_questions` WRITE;
/*!40000 ALTER TABLE `tran_questions` DISABLE KEYS */;
INSERT INTO `tran_questions` VALUES (3,'Which books should I read for my Advanced Physics class? ',NULL,1,0,34,'2018-06-23 15:14:35',34,'2018-06-23 15:14:35',0),(4,'How should I prepare for spring 2018 Algebra tests?',NULL,1,0,35,'2018-06-23 15:23:50',35,'2018-06-23 15:23:50',0),(5,'Which books should I read on English Literature this Summer?',NULL,1,0,35,'2018-06-23 15:25:29',35,'2018-06-24 14:11:31',0),(6,'What is the difference between Freemasons and Illuminati?',NULL,1,0,61,'2018-06-23 15:30:03',61,'2018-06-23 15:30:03',0);
/*!40000 ALTER TABLE `tran_questions` ENABLE KEYS */;
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
-- Table structure for table `tran_threads`
--

DROP TABLE IF EXISTS `tran_threads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tran_threads` (
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
-- Dumping data for table `tran_threads`
--

LOCK TABLES `tran_threads` WRITE;
/*!40000 ALTER TABLE `tran_threads` DISABLE KEYS */;
INSERT INTO `tran_threads` VALUES (1,'Cosmology','','the science of the origin and development of the universe. Modern astronomy is dominated by the Big Bang theory, \nwhich brings together observational astronomy and particle physics.',7,'APPR',1,'2017-03-23 19:03:14',1,'2017-03-23 19:03:14',0),(2,'Religion','','A religion is an organized collection of beliefs, cultural systems, and world views that relate humanity to an order of existence. Many religions have narratives, symbols, and sacred histories that \naim to explain the meaning of life, the origin of life, or the Universe',7,'APPR',1,'2017-03-23 19:03:14',1,'2017-03-23 19:03:14',0);
/*!40000 ALTER TABLE `tran_threads` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-24 14:27:07
