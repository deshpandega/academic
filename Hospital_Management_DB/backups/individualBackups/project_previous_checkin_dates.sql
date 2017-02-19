CREATE DATABASE  IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `project`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: project
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `previous_checkin_dates`
--

DROP TABLE IF EXISTS `previous_checkin_dates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `previous_checkin_dates` (
  `id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `previous_checkin_dates` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id_idx` (`patient_id`),
  CONSTRAINT `fk_prevch_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `out_house_patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `previous_checkin_dates`
--

LOCK TABLES `previous_checkin_dates` WRITE;
/*!40000 ALTER TABLE `previous_checkin_dates` DISABLE KEYS */;
INSERT INTO `previous_checkin_dates` VALUES (1,3,'2016-08-31 00:00:00'),(2,3,'2016-09-11 00:00:00'),(3,3,'2016-09-18 00:00:00'),(4,3,'2016-09-26 00:00:00'),(5,3,'2016-10-05 00:00:00'),(6,3,'2016-10-26 00:00:00'),(7,3,'2016-11-18 00:00:00'),(8,4,'2016-09-05 00:00:00'),(9,4,'2016-09-15 00:00:00'),(10,4,'2016-09-25 00:00:00'),(11,4,'2016-10-05 00:00:00'),(12,4,'2016-10-15 00:00:00'),(13,4,'2016-11-05 00:00:00'),(14,4,'2016-12-05 00:00:00'),(15,5,'2016-09-13 00:00:00'),(16,5,'2016-09-23 00:00:00'),(17,5,'2016-09-30 00:00:00'),(18,5,'2016-10-10 00:00:00'),(19,5,'2016-10-29 00:00:00'),(20,5,'2016-11-22 00:00:00'),(21,8,'2016-10-19 00:00:00'),(22,8,'2016-10-29 00:00:00'),(23,8,'2016-11-09 00:00:00'),(24,8,'2016-11-19 00:00:00'),(25,8,'2016-11-25 00:00:00'),(26,8,'2016-12-09 00:00:00'),(27,10,'2016-11-21 00:00:00'),(28,10,'2016-11-25 00:00:00'),(29,10,'2016-11-29 00:00:00'),(30,10,'2016-12-03 00:00:00'),(31,10,'2016-12-09 00:00:00');
/*!40000 ALTER TABLE `previous_checkin_dates` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-11  6:11:55
