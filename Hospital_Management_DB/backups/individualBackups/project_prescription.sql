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
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescription` (
  `prescription_id` int(11) NOT NULL,
  `prescription_date` datetime NOT NULL,
  `prescription_till` datetime NOT NULL,
  `dose_per_day` int(11) NOT NULL,
  `prescribed_by` int(11) NOT NULL,
  `prescribed_to` int(11) NOT NULL,
  PRIMARY KEY (`prescription_id`),
  KEY `prescribed_by_idx` (`prescribed_by`),
  KEY `prescribed_to_idx` (`prescribed_to`),
  CONSTRAINT `fk_pre_prescribed_by` FOREIGN KEY (`prescribed_by`) REFERENCES `staff` (`staff_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_pre_prescribed_to` FOREIGN KEY (`prescribed_to`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'2016-08-13 00:00:00','2016-08-28 00:00:00',2,4,1),(2,'2016-08-15 00:00:00','2016-08-31 00:00:00',2,5,2),(3,'2016-08-31 00:00:00','2016-09-21 00:00:00',3,6,3),(4,'2016-09-05 00:00:00','2016-09-24 00:00:00',2,6,4),(5,'2016-09-13 00:00:00','2016-09-29 00:00:00',3,7,5),(6,'2016-09-13 00:00:00','2016-09-23 00:00:00',3,2,6),(7,'2016-09-25 00:00:00','2016-10-05 00:00:00',2,2,7),(8,'2016-10-19 00:00:00','2016-11-09 00:00:00',1,5,8),(9,'2016-10-30 00:00:00','2016-11-15 00:00:00',2,2,9),(10,'2016-11-21 00:00:00','2016-12-21 00:00:00',1,4,10),(11,'2016-11-23 00:00:00','2016-12-23 00:00:00',1,6,11),(12,'2016-09-01 00:00:00','2016-09-21 00:00:00',3,5,2),(13,'2016-09-25 00:00:00','2016-10-15 00:00:00',2,1,4),(14,'2016-09-30 00:00:00','2016-10-20 00:00:00',2,7,5);
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-11  6:11:57
