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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `address_line1` varchar(45) NOT NULL,
  `address_line2` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(5) NOT NULL,
  `zip` varchar(5) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'300 Longwood Ave','','Boston','MA','02115','USA'),(2,'60 St Germain Street','Apt 5','Boston','MA','02115','USA'),(3,'75 St Alphonsus Street','','Boston','MA','02120','USA'),(4,'15 Smith Street','B','Boston','MA','02120','USA'),(5,'30 Dalton Street','','Boston','MA','02115','USA'),(6,'40 St Alphonosus Street','C','Boston','MA','02120','USA'),(7,'28 St Alphonsus Street','B','Boston','MA','02120','USA'),(8,'Hyde Park Ave','1050','Boston','MA','02136','USA'),(9,'E Eighth St','671','Boston','MA','02127','USA'),(10,'Sanborn Ave','109','Boston','MA','02132','USA'),(11,'South St','5','Boston','MA','02135','USA'),(12,'Broadlawn Park','57','Boston','MA','02132','USA'),(13,'Paul Gore St','68','Boston','MA','02130','USA'),(14,'Florida St','90','Boston','MA','02124','USA'),(15,'E Eighth St','344','Boston','MA','02127','USA'),(16,'Middle St','42-44','Boston','MA','02127','USA'),(17,'Henry Sterling Sq','14','Boston','MA','02127','USA'),(18,'E Fourth St','905','Boston','MA','02127','USA'),(19,'Grew Ave','89A','Boston','MA','02131','USA'),(20,'Louder\'s Ln','21','Boston','MA','02130','USA'),(21,'Northdale Ter','10','Boston','MA','02132','USA'),(22,'Perkins St','111','Boston','MA','02130','USA'),(23,'Elmore St','35','Boston','MA','02119','USA'),(24,'Mountfort St','120','Boston','MA','02215','USA'),(25,'Beacon St','199','Boston','MA','02116','USA'),(26,'Tremont St','750','Boston','MA','02118','USA'),(27,'Washington St','1850','Boston','MA','02118','USA'),(28,'E Broadway','508','Boston','MA','02127','USA'),(29,'Huntington Ave','660','Boston','MA','02120','USA'),(30,'Folsom St','18','Boston','MA','02125','USA'),(31,'Lawley St','29','Boston','MA','02122','USA'),(32,'Adams St','596','Boston','MA','02122','USA'),(33,'Eliot Pl','7-8 ','Boston','MA','02130','USA'),(34,'330 Mount Auburn Street','','Cambridge','MA','02138','USA'),(35,'Boston Meducal Center Place','1','Boston','MA','02118','USA'),(36,'330 Brookline Avenue','','Boston','MA','02115','USA'),(37,'55 Fruit Street','','Boston','MA','02114','USA'),(38,'800 Washington Street','','Boston','MA','02111','USA');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
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
