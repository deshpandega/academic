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
-- Table structure for table `medicine_prescription`
--

DROP TABLE IF EXISTS `medicine_prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine_prescription` (
  `medicine_id` int(11) NOT NULL,
  `prescription_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '0',
  KEY `medicine_id_idx` (`medicine_id`),
  KEY `prescription_id_idx` (`prescription_id`),
  CONSTRAINT `fk_medPr_medicine_id` FOREIGN KEY (`medicine_id`) REFERENCES `medicines` (`medicine_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_medPr_prescription_id` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`prescription_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine_prescription`
--

LOCK TABLES `medicine_prescription` WRITE;
/*!40000 ALTER TABLE `medicine_prescription` DISABLE KEYS */;
INSERT INTO `medicine_prescription` VALUES (1,1,2),(2,1,2),(3,1,3),(1,2,2),(5,2,3),(2,3,1),(3,3,2),(8,3,4),(14,3,1),(1,4,2),(15,4,3),(6,4,1),(8,5,2),(4,5,2),(1,6,1),(9,7,4),(11,7,2),(12,7,3),(4,8,1),(7,8,2),(2,9,3),(6,9,1),(14,9,4),(2,10,1),(1,10,2),(13,10,3),(12,10,1),(3,11,2),(4,11,1),(8,12,2),(6,12,2),(9,12,3),(15,12,3),(15,13,1),(1,13,2),(7,13,2),(5,14,1);
/*!40000 ALTER TABLE `medicine_prescription` ENABLE KEYS */;
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
