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
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  `email_id` varchar(70) DEFAULT NULL,
  `contact_numnber` varchar(45) DEFAULT NULL,
  `insurance_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `address_id_idx` (`address_id`),
  KEY `insurance_number_idx` (`insurance_number`),
  CONSTRAINT `fk_per_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_per_insurance_number` FOREIGN KEY (`insurance_number`) REFERENCES `insurance` (`insurance_number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Gaurang','Deshpande',NULL,'gaurang.deshpande@gmail.com','4016631737',NULL),(2,'Shamal','Bhole',2,'shamal.bhole@gmail.com','4092814850',2),(3,'Vandana','Tiwari',3,'vandana.tiwari@gmail.com','4324058361',3),(4,'Vihar','Raul',4,'vihar.raul@gmail.com','3456783245',7),(5,'Amita','Murali',5,'amita.murali@gmail.com','7629274212',4),(6,'Rutika','Araokar',6,'rutika.araokar@gmail.com','5024591098',9),(7,'Bhavesh','Sachdev',7,'bhavesh.sachdev@gmail.com','6720018901',NULL),(8,'Shritu','Mehta',8,'shritu.mehta@gmail.com','2013948564',8),(9,'Sneha','Shetty',NULL,'sneha.shetty@gmail.com','9387120301',5),(10,'Manish','Patil',9,'manish.patil@gmail.com','3839205968',1),(11,'Shailesh','Hegde',10,'shailesh.hegde@gmail.com','3895048271',6),(12,'Antriksh','Sharma',NULL,'antriksh.sharma@gmail.com','2372335802',11),(13,'Avee','Arora',11,'avee.arora@gmail.com','5643567765',16),(14,'Ketki','Deshpande',12,'ketki.deshpande@gmail.com','9876523464',19),(15,'Neeraj','Rajput',NULL,'neeraj.rajput@gmail.com','3245677654',12),(16,'Saurabh','Rao',13,'saurabh.rao@gmail.com','3567876545',NULL),(17,'Pratiksha','Shetty',14,'pratiksha.shetty@gmail.com','8972439875',10),(18,'Suprita','Puned',15,'suprita.puned@gmail.com','8762376864',13),(19,'Shivam','Negi',NULL,'shivam.negi@gmail.com','9876132425',15),(20,'Shrikant','Mudholkar',16,'shrikant.mudholkar@gmail.com','3245678765',14),(21,'Sushrut','Tadwalkar',17,'sushrut.tadwalkar@gmail.com','4369876524',19),(22,'Kedar','Deshmukh',18,'kedar.deshmukh@gmail.com','4328762436',22),(23,'Rohan','Jahagirdar',NULL,'rohan.jahagirdar@gmail.com','9876543212',NULL),(24,'Lahari','Palle',19,'lahari.palle@gmail.com','2436776543',20),(25,'Akansha','Harshe',20,'akansha.harshe@gmail.com','3425678765',21),(26,'Shephali','Mahajan',21,'shephali.mahajan@gmail.com','4368756442',NULL),(27,'Priyal','Chaudhari',22,'priyal.chaudhari@gmail.com','5786435456',23);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`localhost`*/ /*!50003 TRIGGER validate_email
	BEFORE INSERT
	ON person
	FOR EACH ROW
BEGIN
	IF NEW.email_id NOT LIKE '%_@%_.__%' 
    THEN
		SIGNAL SQLSTATE VALUE '45000'
		SET MESSAGE_TEXT = 'email column is not valid';
	END IF;
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

-- Dump completed on 2016-12-11  6:11:57
