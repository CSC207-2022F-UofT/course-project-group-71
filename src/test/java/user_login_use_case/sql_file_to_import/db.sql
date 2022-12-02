-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (arm64)
--
-- Host: 127.0.0.1    Database: db_Chris
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventfile` (
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `month` int DEFAULT NULL,
  `day` int DEFAULT NULL,
  `hour` int DEFAULT NULL,
  `minute` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventfile`
--

LOCK TABLES `eventfile` WRITE;
/*!40000 ALTER TABLE `eventfile` DISABLE KEYS */;
INSERT INTO `eventfile` VALUES ('A','2','44',33123,11,2,3,3),('B','3','22',3132,1,2,4,2),('C','5','A',2004,5,12,11,52),('D','5','A',2004,5,1,3,4),('E','5','A',2004,5,1,3,4),('F','2','2',4,2,5,44,33),('G','3','2',2,3,3,44,22),('H',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('I',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Edit','HH','Zoom',2024,4,2,9,9);
/*!40000 ALTER TABLE `eventfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_org_par`
--

DROP TABLE IF EXISTS `follow_org_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow_org_par` (
  `par_username` varchar(20) DEFAULT NULL,
  `org_username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_org_par`
--

LOCK TABLES `follow_org_par` WRITE;
/*!40000 ALTER TABLE `follow_org_par` DISABLE KEYS */;
INSERT INTO `follow_org_par` VALUES ('dg','as');
/*!40000 ALTER TABLE `follow_org_par` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orgfile`
--

DROP TABLE IF EXISTS `orgfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orgfile` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orgfile`
--

LOCK TABLES `orgfile` WRITE;
/*!40000 ALTER TABLE `orgfile` DISABLE KEYS */;
INSERT INTO `orgfile` VALUES ('123','123'),('444','444'),('as','124513'),('ben','123123'),('ben1','123123'),('cheng','1231'),('st','12453');
/*!40000 ALTER TABLE `orgfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `par_notification`
--

DROP TABLE IF EXISTS `par_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `par_notification` (
  `par_username` varchar(20) DEFAULT NULL,
  `notification` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_notification`
--

LOCK TABLES `par_notification` WRITE;
/*!40000 ALTER TABLE `par_notification` DISABLE KEYS */;
INSERT INTO `par_notification` VALUES ('chengben','\"sss\"'),('chengben','\"eeee\"');
/*!40000 ALTER TABLE `par_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parfile`
--

DROP TABLE IF EXISTS `parfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parfile` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `notification` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parfile`
--

LOCK TABLES `parfile` WRITE;
/*!40000 ALTER TABLE `parfile` DISABLE KEYS */;
INSERT INTO `parfile` VALUES ('chengben','123123',NULL),('dg','23545',NULL),('sy',NULL,NULL),('aas','114514',NULL);
/*!40000 ALTER TABLE `parfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `past_events_for_org`
--

DROP TABLE IF EXISTS `past_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `past_events_for_org` (
  `org_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `past_events_for_org`
--

LOCK TABLES `past_events_for_org` WRITE;
/*!40000 ALTER TABLE `past_events_for_org` DISABLE KEYS */;
INSERT INTO `past_events_for_org` VALUES ('st','A'),('st','B');
/*!40000 ALTER TABLE `past_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `past_events_for_par`
--

DROP TABLE IF EXISTS `past_events_for_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `past_events_for_par` (
  `par_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `past_events_for_par`
--

LOCK TABLES `past_events_for_par` WRITE;
/*!40000 ALTER TABLE `past_events_for_par` DISABLE KEYS */;
INSERT INTO `past_events_for_par` VALUES ('dg','A'),('dg','B');
/*!40000 ALTER TABLE `past_events_for_par` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unpublished_events_for_org`
--

DROP TABLE IF EXISTS `unpublished_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unpublished_events_for_org` (
  `org_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unpublished_events_for_org`
--

LOCK TABLES `unpublished_events_for_org` WRITE;
/*!40000 ALTER TABLE `unpublished_events_for_org` DISABLE KEYS */;
INSERT INTO `unpublished_events_for_org` VALUES ('as','A'),('st','B');
/*!40000 ALTER TABLE `unpublished_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upcoming_events_for_org`
--

DROP TABLE IF EXISTS `upcoming_events_for_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `upcoming_events_for_org` (
  `org_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upcoming_events_for_org`
--

LOCK TABLES `upcoming_events_for_org` WRITE;
/*!40000 ALTER TABLE `upcoming_events_for_org` DISABLE KEYS */;
INSERT INTO `upcoming_events_for_org` VALUES ('as','A'),('as','B'),('as','C'),('as','D'),('as','E'),('as','F'),('as','G'),('as','H'),('as','I');
/*!40000 ALTER TABLE `upcoming_events_for_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upcoming_events_for_par`
--

DROP TABLE IF EXISTS `upcoming_events_for_par`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `upcoming_events_for_par` (
  `par_username` varchar(20) DEFAULT NULL,
  `event_title` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
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

-- Dump completed on 2022-11-26 16:51:20
