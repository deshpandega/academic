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
-- Table structure for table `procedures`
--

DROP TABLE IF EXISTS `procedures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procedures` (
  `procedure_id` int(11) NOT NULL,
  `procedure_date` datetime NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `performed_by` int(11) NOT NULL,
  `performed_on` int(11) NOT NULL,
  `procedure_bill` int(11) NOT NULL,
  PRIMARY KEY (`procedure_id`),
  KEY `performed_by_idx` (`performed_by`),
  KEY `performed_on_idx` (`performed_on`),
  CONSTRAINT `fk_pro_performed_by` FOREIGN KEY (`performed_by`) REFERENCES `staff` (`staff_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_pro_performed_on` FOREIGN KEY (`performed_on`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedures`
--

LOCK TABLES `procedures` WRITE;
/*!40000 ALTER TABLE `procedures` DISABLE KEYS */;
INSERT INTO `procedures` VALUES (1,'2016-08-15 00:00:00','blood test',3,1,90),(2,'2016-08-18 00:00:00','x ray scanning',9,1,150),(3,'2016-08-18 00:00:00','lab test',9,2,100),(4,'2016-09-02 00:00:00','blood test',5,3,90),(5,'2016-09-06 00:00:00','lab test',9,3,100),(6,'2016-09-06 00:00:00','blood test',8,4,90),(7,'2016-09-09 00:00:00','lab test',9,4,100),(8,'2016-11-24 00:00:00','x ray scanning',9,10,150),(9,'2016-09-15 00:00:00','CT scan',1,5,250),(10,'2016-10-21 00:00:00','lab test',9,8,100),(11,'2016-09-15 00:00:00','blood test',8,6,90),(12,'2016-09-18 00:00:00','blood test',9,6,90);
/*!40000 ALTER TABLE `procedures` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-11  6:11:56
