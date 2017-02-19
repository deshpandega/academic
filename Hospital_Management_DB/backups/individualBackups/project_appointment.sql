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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appointment` (
  `appointment_id` int(11) NOT NULL,
  `appointment_start_date_time` datetime NOT NULL,
  `booked_by` int(11) NOT NULL,
  `booked_for` int(11) NOT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `appointment_bill` int(11) NOT NULL,
  `appointment_end_date_time` datetime NOT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `booked_by_idx` (`booked_by`),
  KEY `booked_for_idx` (`booked_for`),
  CONSTRAINT `fk_app_booked_by` FOREIGN KEY (`booked_by`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_app_booked_for` FOREIGN KEY (`booked_for`) REFERENCES `staff` (`staff_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'2016-08-14 13:00:00',1,4,'regular checkup',50,'2016-08-14 13:30:00'),(2,'2016-10-19 14:00:00',8,4,'general checkup',50,'2016-10-19 14:30:00'),(3,'2016-08-31 12:00:00',1,4,'regular checkup',50,'2016-08-31 12:30:00'),(4,'2016-08-16 09:00:00',2,6,'general checkup',40,'2016-08-16 09:30:00'),(5,'2016-09-01 10:30:00',3,6,'general checkup',40,'2016-09-01 11:00:00'),(6,'2016-09-14 11:00:00',5,9,'regular checkup',40,'2016-09-14 11:30:00'),(7,'2016-08-25 09:00:00',2,2,'regular checkup',50,'2016-08-25 09:30:00'),(8,'2016-10-30 20:00:00',9,6,'general checkup',50,'2016-10-30 20:30:00'),(9,'2016-09-13 20:30:00',6,2,'regular checkup',40,'2016-09-13 21:00:00'),(10,'2016-09-14 12:00:00',5,7,'general checkup',40,'2016-09-14 12:30:00'),(11,'2016-09-26 09:00:00',7,7,'regular checkup',100,'2016-09-26 09:00:00'),(12,'2016-09-07 10:00:00',4,9,'regular checkup',40,'2016-09-07 10:30:00'),(13,'2016-09-10 12:00:00',4,1,'general checkup',40,'2016-09-10 12:00:00'),(14,'2016-11-22 08:00:00',10,4,'general checkup',50,'2016-11-22 08:30:00'),(15,'2016-11-24 09:00:00',11,2,'general checkup',80,'2016-11-24 09:30:00'),(16,'2016-12-11 11:00:00',3,6,'general checkup',40,'2016-12-11 11:30:00');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`localhost`*/ /*!50003 TRIGGER out_patient_next_checkin_date
	AFTER INSERT
	ON appointment
	FOR EACH ROW
BEGIN
	CASE
		WHEN (SELECT distinct patient.patient_type FROM patient WHERE NEW.booked_by = patient.patient_id) = 0 THEN
			UPDATE out_house_patient SET next_checkin_date = NEW.appointment_start_date_time WHERE patient_id = NEW.booked_by;
	END CASE;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-11  6:11:55
