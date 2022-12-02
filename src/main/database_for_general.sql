-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db2_new
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `eventfile`
--

DROP TABLE IF EXISTS `eventfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventfile` (
  `title` varchar(20) NOT NULL DEFAULT 'null',
  `description` varchar(200) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `minute` int(11) DEFAULT NULL,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventfile`
--

LOCK TABLES `eventfile` WRITE;
/*!40000 ALTER TABLE `eventfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_org_par`
--

DROP TABLE IF EXISTS `follow_org_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `follow_org_par` (
  `par_username` varchar(20) NOT NULL,
  `org_username` varchar(20) NOT NULL,
  PRIMARY KEY (`par_username`,`org_username`),
  KEY `follow_org_par_orgfile_null_fk` (`org_username`),
  CONSTRAINT `follow_org_par_orgfile_null_fk` FOREIGN KEY (`org_username`) REFERENCES `orgfile` (`username`),
  CONSTRAINT `follow_org_par_parfile_null_fk` FOREIGN KEY (`par_username`) REFERENCES `parfile` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_org_par`
--

LOCK TABLES `follow_org_par` WRITE;
/*!40000 ALTER TABLE `follow_org_par` DISABLE KEYS */;
/*!40000 ALTER TABLE `follow_org_par` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orgfile`
--

DROP TABLE IF EXISTS `orgfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orgfile` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orgfile`
--

LOCK TABLES `orgfile` WRITE;
/*!40000 ALTER TABLE `orgfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `orgfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `par_notification`
--

DROP TABLE IF EXISTS `par_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `par_notification` (
  `par_username` varchar(20) DEFAULT NULL,
  `notification` varchar(50) DEFAULT NULL,
  KEY `par_notification_parfile_null_fk` (`par_username`),
  CONSTRAINT `par_notification_parfile_null_fk` FOREIGN KEY (`par_username`) REFERENCES `parfile` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_notification`
--

LOCK TABLES `par_notification` WRITE;
/*!40000 ALTER TABLE `par_notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `par_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parfile`
--

DROP TABLE IF EXISTS `parfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parfile` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parfile`
--

LOCK TABLES `parfile` WRITE;
/*!40000 ALTER TABLE `parfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `parfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `past_events_for_org`
--

DROP TABLE IF EXISTS `past_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `past_events_for_org` (
  `org_username` varchar(20) NOT NULL,
  `event_title` varchar(20) NOT NULL,
  PRIMARY KEY (`event_title`,`org_username`),
  KEY `past_event_for_org_orgfile_null_fk` (`org_username`),
  CONSTRAINT `past_event_for_org_eventfile_null_fk` FOREIGN KEY (`event_title`) REFERENCES `eventfile` (`title`),
  CONSTRAINT `past_event_for_org_orgfile_null_fk` FOREIGN KEY (`org_username`) REFERENCES `orgfile` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `past_events_for_org`
--

LOCK TABLES `past_events_for_org` WRITE;
/*!40000 ALTER TABLE `past_events_for_org` DISABLE KEYS */;
/*!40000 ALTER TABLE `past_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `past_events_for_par`
--

DROP TABLE IF EXISTS `past_events_for_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `past_events_for_par` (
  `par_username` varchar(20) NOT NULL,
  `event_title` varchar(20) NOT NULL,
  PRIMARY KEY (`event_title`,`par_username`),
  KEY `past_events_for_par_parfile_null_fk` (`par_username`),
  CONSTRAINT `past_events_for_par_eventfile_null_fk` FOREIGN KEY (`event_title`) REFERENCES `eventfile` (`title`),
  CONSTRAINT `past_events_for_par_parfile_null_fk` FOREIGN KEY (`par_username`) REFERENCES `parfile` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `past_events_for_par`
--

LOCK TABLES `past_events_for_par` WRITE;
/*!40000 ALTER TABLE `past_events_for_par` DISABLE KEYS */;
/*!40000 ALTER TABLE `past_events_for_par` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unpublished_events_for_org`
--

DROP TABLE IF EXISTS `unpublished_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unpublished_events_for_org` (
  `org_username` varchar(20) NOT NULL,
  `event_title` varchar(20) NOT NULL,
  PRIMARY KEY (`org_username`,`event_title`),
  KEY `unpublished_event_for_org_eventfile_null_fk` (`event_title`),
  CONSTRAINT `unpublished_event_for_org_eventfile_null_fk` FOREIGN KEY (`event_title`) REFERENCES `eventfile` (`title`),
  CONSTRAINT `unpublished_event_for_org_orgfile_null_fk` FOREIGN KEY (`org_username`) REFERENCES `orgfile` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unpublished_events_for_org`
--

LOCK TABLES `unpublished_events_for_org` WRITE;
/*!40000 ALTER TABLE `unpublished_events_for_org` DISABLE KEYS */;
/*!40000 ALTER TABLE `unpublished_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upcoming_events_for_org`
--

DROP TABLE IF EXISTS `upcoming_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upcoming_events_for_org` (
  `org_username` varchar(20) NOT NULL,
  `event_title` varchar(20) NOT NULL,
  PRIMARY KEY (`org_username`,`event_title`),
  KEY `upcoming_events_for_org_eventfile_null_fk` (`event_title`),
  CONSTRAINT `upcoming_events_for_org_eventfile_null_fk` FOREIGN KEY (`event_title`) REFERENCES `eventfile` (`title`),
  CONSTRAINT `upcoming_events_for_org_orgfile_null_fk` FOREIGN KEY (`org_username`) REFERENCES `orgfile` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upcoming_events_for_org`
--

LOCK TABLES `upcoming_events_for_org` WRITE;
/*!40000 ALTER TABLE `upcoming_events_for_org` DISABLE KEYS */;
/*!40000 ALTER TABLE `upcoming_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upcoming_events_for_par`
--

DROP TABLE IF EXISTS `upcoming_events_for_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upcoming_events_for_par` (
  `par_username` varchar(20) NOT NULL,
  `event_title` varchar(20) NOT NULL,
  PRIMARY KEY (`event_title`,`par_username`),
  KEY `upcoming_events_for_par_parfile_null_fk` (`par_username`),
  CONSTRAINT `upcoming_events_for_par_eventfile_null_fk` FOREIGN KEY (`event_title`) REFERENCES `eventfile` (`title`),
  CONSTRAINT `upcoming_events_for_par_parfile_null_fk` FOREIGN KEY (`par_username`) REFERENCES `parfile` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upcoming_events_for_par`
--

LOCK TABLES `upcoming_events_for_par` WRITE;
/*!40000 ALTER TABLE `upcoming_events_for_par` DISABLE KEYS */;
/*!40000 ALTER TABLE `upcoming_events_for_par` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-27 18:15:24
