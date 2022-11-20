-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testing_db
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
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `minute` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventfile`
--

LOCK TABLES `eventfile` WRITE;
/*!40000 ALTER TABLE `eventfile` DISABLE KEYS */;
INSERT INTO `eventfile` (`title`, `description`, `location`, `year`, `month`, `day`, `hour`, `minute`) VALUES ('E1','Testing unpublished','zoom1',2024,1,1,1,1),('E2','Testing upcoming','zoom2',2026,2,2,2,2),('E3','Testing past','zoom3',2000,3,3,3,3),('E4','Testing Participants Upcoming','zoom4',2024,4,4,4,4),('E5','Testing Participants Past','zoom5',2000,5,5,5,5),('E6','Testing Leave',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `eventfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_org_par`
--

DROP TABLE IF EXISTS `follow_org_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `follow_org_par` (
  `par_username` varchar(20) DEFAULT NULL,
  `org_username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_org_par`
--

LOCK TABLES `follow_org_par` WRITE;
/*!40000 ALTER TABLE `follow_org_par` DISABLE KEYS */;
INSERT INTO `follow_org_par` (`par_username`, `org_username`) VALUES ('P1','O2'),('P2','O2'),('P3','O2'),('P4','O2'),('P5','O2');
/*!40000 ALTER TABLE `follow_org_par` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orgfile`
--

DROP TABLE IF EXISTS `orgfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orgfile` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orgfile`
--

LOCK TABLES `orgfile` WRITE;
/*!40000 ALTER TABLE `orgfile` DISABLE KEYS */;
INSERT INTO `orgfile` (`username`, `password`) VALUES ('O1','O1password'),('O2','O2password'),('O3','O3password');
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
  `notification` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_notification`
--

LOCK TABLES `par_notification` WRITE;
/*!40000 ALTER TABLE `par_notification` DISABLE KEYS */;
INSERT INTO `par_notification` (`par_username`, `notification`) VALUES ('P1','Note1 for P1'),('P1','Note2 for P1'),('P1','Note3 for P1'),('P1','Note4 for P1');
/*!40000 ALTER TABLE `par_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parfile`
--

DROP TABLE IF EXISTS `parfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parfile` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parfile`
--

LOCK TABLES `parfile` WRITE;
/*!40000 ALTER TABLE `parfile` DISABLE KEYS */;
INSERT INTO `parfile` (`username`, `password`) VALUES ('P1','O1password'),('P2','p2'),('P3','p3'),('P4','p4'),('P5','p5'),('P6','p6'),('P7','p7'),('P8','p8'),('P9','p9'),('P10','p10');
/*!40000 ALTER TABLE `parfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `past_events_for_org`
--

DROP TABLE IF EXISTS `past_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `past_events_for_org` (
  `org_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `past_events_for_org`
--

LOCK TABLES `past_events_for_org` WRITE;
/*!40000 ALTER TABLE `past_events_for_org` DISABLE KEYS */;
INSERT INTO `past_events_for_org` (`org_username`, `event_title`) VALUES ('O1','E3');
/*!40000 ALTER TABLE `past_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `past_events_for_par`
--

DROP TABLE IF EXISTS `past_events_for_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `past_events_for_par` (
  `par_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `past_events_for_par`
--

LOCK TABLES `past_events_for_par` WRITE;
/*!40000 ALTER TABLE `past_events_for_par` DISABLE KEYS */;
INSERT INTO `past_events_for_par` (`par_username`, `event_title`) VALUES ('P6','E5'),('P7','E5'),('P8','E5'),('P9','E5'),('P10','E5');
/*!40000 ALTER TABLE `past_events_for_par` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unpublished_events_for_org`
--

DROP TABLE IF EXISTS `unpublished_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unpublished_events_for_org` (
  `org_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unpublished_events_for_org`
--

LOCK TABLES `unpublished_events_for_org` WRITE;
/*!40000 ALTER TABLE `unpublished_events_for_org` DISABLE KEYS */;
INSERT INTO `unpublished_events_for_org` (`org_username`, `event_title`) VALUES ('O1','E1');
/*!40000 ALTER TABLE `unpublished_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upcoming_events_for_org`
--

DROP TABLE IF EXISTS `upcoming_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upcoming_events_for_org` (
  `org_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upcoming_events_for_org`
--

LOCK TABLES `upcoming_events_for_org` WRITE;
/*!40000 ALTER TABLE `upcoming_events_for_org` DISABLE KEYS */;
INSERT INTO `upcoming_events_for_org` (`org_username`, `event_title`) VALUES ('O1','E2'),('O1','E4');
/*!40000 ALTER TABLE `upcoming_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upcoming_events_for_par`
--

DROP TABLE IF EXISTS `upcoming_events_for_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upcoming_events_for_par` (
  `par_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upcoming_events_for_par`
--

LOCK TABLES `upcoming_events_for_par` WRITE;
/*!40000 ALTER TABLE `upcoming_events_for_par` DISABLE KEYS */;
INSERT INTO `upcoming_events_for_par` (`par_username`, `event_title`) VALUES ('P1','E4'),('P2','E4'),('P3','E4'),('P4','E4'),('P5','E4'),('P6','E4'),('P10','E6');
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

-- Dump completed on 2022-11-19 21:06:59
