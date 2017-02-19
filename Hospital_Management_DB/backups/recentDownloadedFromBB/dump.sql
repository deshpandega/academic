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
INSERT INTO `address` (`address_id`, `address_line1`, `address_line2`, `city`, `state`, `zip`, `country`) VALUES (1,'300 Longwood Ave','','Boston','MA','02115','USA'),(2,'60 St Germain Street','Apt 5','Boston','MA','02115','USA'),(3,'75 St Alphonsus Street','','Boston','MA','02120','USA'),(4,'15 Smith Street','B','Boston','MA','02120','USA'),(5,'30 Dalton Street','','Boston','MA','02115','USA'),(6,'40 St Alphonosus Street','C','Boston','MA','02120','USA'),(7,'28 St Alphonsus Street','B','Boston','MA','02120','USA'),(8,'Hyde Park Ave','1050','Boston','MA','02136','USA'),(9,'E Eighth St','671','Boston','MA','02127','USA'),(10,'Sanborn Ave','109','Boston','MA','02132','USA'),(11,'South St','5','Boston','MA','02135','USA'),(12,'Broadlawn Park','57','Boston','MA','02132','USA'),(13,'Paul Gore St','68','Boston','MA','02130','USA'),(14,'Florida St','90','Boston','MA','02124','USA'),(15,'E Eighth St','344','Boston','MA','02127','USA'),(16,'Middle St','42-44','Boston','MA','02127','USA'),(17,'Henry Sterling Sq','14','Boston','MA','02127','USA'),(18,'E Fourth St','905','Boston','MA','02127','USA'),(19,'Grew Ave','89A','Boston','MA','02131','USA'),(20,'Louder\'s Ln','21','Boston','MA','02130','USA'),(21,'Northdale Ter','10','Boston','MA','02132','USA'),(22,'Perkins St','111','Boston','MA','02130','USA'),(23,'Elmore St','35','Boston','MA','02119','USA'),(24,'Mountfort St','120','Boston','MA','02215','USA'),(25,'Beacon St','199','Boston','MA','02116','USA'),(26,'Tremont St','750','Boston','MA','02118','USA'),(27,'Washington St','1850','Boston','MA','02118','USA'),(28,'E Broadway','508','Boston','MA','02127','USA'),(29,'Huntington Ave','660','Boston','MA','02120','USA'),(30,'Folsom St','18','Boston','MA','02125','USA'),(31,'Lawley St','29','Boston','MA','02122','USA'),(32,'Adams St','596','Boston','MA','02122','USA'),(33,'Eliot Pl','7-8 ','Boston','MA','02130','USA'),(34,'330 Mount Auburn Street','','Cambridge','MA','02138','USA'),(35,'Boston Meducal Center Place','1','Boston','MA','02118','USA'),(36,'330 Brookline Avenue','','Boston','MA','02115','USA'),(37,'55 Fruit Street','','Boston','MA','02114','USA'),(38,'800 Washington Street','','Boston','MA','02111','USA');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `appointment` (`appointment_id`, `appointment_start_date_time`, `booked_by`, `booked_for`, `reason`, `appointment_bill`, `appointment_end_date_time`) VALUES (1,'2016-08-14 13:00:00',1,4,'regular checkup',50,'2016-08-14 13:30:00'),(2,'2016-10-19 14:00:00',8,4,'general checkup',50,'2016-10-19 14:30:00'),(3,'2016-08-31 12:00:00',1,4,'regular checkup',50,'2016-08-31 12:30:00'),(4,'2016-08-16 09:00:00',2,6,'general checkup',40,'2016-08-16 09:30:00'),(5,'2016-09-01 10:30:00',3,6,'general checkup',40,'2016-09-01 11:00:00'),(6,'2016-09-14 11:00:00',5,9,'regular checkup',40,'2016-09-14 11:30:00'),(7,'2016-08-25 09:00:00',2,2,'regular checkup',50,'2016-08-25 09:30:00'),(8,'2016-10-30 20:00:00',9,6,'general checkup',50,'2016-10-30 20:30:00'),(9,'2016-09-13 20:30:00',6,2,'regular checkup',40,'2016-09-13 21:00:00'),(10,'2016-09-14 12:00:00',5,7,'general checkup',40,'2016-09-14 12:30:00'),(11,'2016-09-26 09:00:00',7,7,'regular checkup',100,'2016-09-26 09:00:00'),(12,'2016-09-07 10:00:00',4,9,'regular checkup',40,'2016-09-07 10:30:00'),(13,'2016-09-10 12:00:00',4,1,'general checkup',40,'2016-09-10 12:00:00'),(14,'2016-11-22 08:00:00',10,4,'general checkup',50,'2016-11-22 08:30:00'),(15,'2016-11-24 09:00:00',11,2,'general checkup',80,'2016-11-24 09:30:00'),(16,'2016-12-11 11:00:00',3,6,'general checkup',40,'2016-12-11 11:30:00'),(17,'2016-12-12 09:00:00',5,7,'regular checkup',50,'2016-12-12 09:30:00');
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

--
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing` (
  `bill_id` int(11) NOT NULL,
  `bill_date` datetime NOT NULL,
  `patient_id` int(11) NOT NULL,
  `bill_amount` int(11) DEFAULT NULL,
  `insurance_amount` int(11) DEFAULT NULL,
  `final_bill_amount` int(11) DEFAULT NULL,
  `bill_start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `fk_bill_patient_id_idx` (`patient_id`),
  CONSTRAINT `fk_bill_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` (`bill_id`, `bill_date`, `patient_id`, `bill_amount`, `insurance_amount`, `final_bill_amount`, `bill_start_date`) VALUES (1,'2016-12-10 15:47:15',1,90340,150000,0,'2016-08-13 00:00:00'),(2,'2016-12-10 15:58:29',2,90190,150000,0,'2016-08-15 00:00:00'),(3,'2016-12-10 16:06:15',3,230,150000,0,'2016-08-31 00:00:00'),(4,'2016-12-10 16:33:58',4,270,150000,0,'2016-09-05 00:00:00'),(5,'2016-12-10 16:35:55',6,220,150000,0,'2016-09-13 00:00:00');
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `billing_view`
--

DROP TABLE IF EXISTS `billing_view`;
/*!50001 DROP VIEW IF EXISTS `billing_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `billing_view` AS SELECT 
 1 AS `patient_id`,
 1 AS `Procedure_Expense`,
 1 AS `Surgery_Expense`,
 1 AS `Appointment_Expense`,
 1 AS `Prescription_Expense`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(45) NOT NULL,
  `hospital_id` int(11) NOT NULL,
  PRIMARY KEY (`department_id`),
  KEY `hospital_id_idx` (`hospital_id`),
  CONSTRAINT `fk_dep_hospital_id` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`hospital_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`department_id`, `department_name`, `hospital_id`) VALUES (1,'Anaesthetics',1),(2,'Cardiology',1),(3,'Ear nose and throat',1),(4,'Gastroenterology',1),(5,'Gynaecology',1),(6,'General surgery',1),(7,'Neurology',1),(8,'Orthopaedics',1),(9,'Physiotherapy',1),(10,'Radiotherapy',1),(11,'HR',1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_patient_past`
--

DROP TABLE IF EXISTS `department_patient_past`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department_patient_past` (
  `department_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `current_department_flag` char(5) NOT NULL,
  KEY `department_id_idx` (`department_id`),
  KEY `patient_id_idx` (`patient_id`),
  CONSTRAINT `fk_deppat_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_deppat_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_patient_past`
--

LOCK TABLES `department_patient_past` WRITE;
/*!40000 ALTER TABLE `department_patient_past` DISABLE KEYS */;
INSERT INTO `department_patient_past` (`department_id`, `patient_id`, `current_department_flag`) VALUES (8,1,'Y'),(2,2,'N'),(5,2,'Y'),(10,3,'N'),(6,3,'Y'),(6,4,'Y'),(3,4,'N'),(4,4,'N'),(7,5,'Y'),(2,6,'Y'),(9,6,'N'),(2,7,'Y'),(6,7,'N'),(4,8,'Y'),(7,9,'N'),(2,9,'Y'),(2,10,'N'),(10,10,'Y'),(6,11,'Y'),(7,11,'N');
/*!40000 ALTER TABLE `department_patient_past` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `hospital_id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital_name` varchar(45) NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`hospital_id`),
  KEY `fk_Hospital_Address1_idx` (`address_id`),
  CONSTRAINT `fk_hosp_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` (`hospital_id`, `hospital_name`, `contact_number`, `address_id`) VALUES (1,'Boston Children Hospital','(617) 355-6000',1),(2,'Mount Auburn Hospital','(617) 492-3500',34),(3,'Boston Medical Center Corporation','(617) 638-8000',35),(4,'Beth Israel Deaconess Medical Center','(617) 667-7000',36),(5,'Massachusetts GeneralJHospital','(617) 726-2000',37),(6,'Tufts Medical Center','(617) 636-5000',38);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `in_house_patient`
--

DROP TABLE IF EXISTS `in_house_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `in_house_patient` (
  `patient_id` int(11) NOT NULL,
  `bed_number` varchar(45) NOT NULL,
  PRIMARY KEY (`patient_id`),
  CONSTRAINT `fk_inpat_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `in_house_patient`
--

LOCK TABLES `in_house_patient` WRITE;
/*!40000 ALTER TABLE `in_house_patient` DISABLE KEYS */;
INSERT INTO `in_house_patient` (`patient_id`, `bed_number`) VALUES (1,'B52'),(2,'A30'),(6,'C30'),(7,'D20'),(9,'B12'),(11,'A3');
/*!40000 ALTER TABLE `in_house_patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance` (
  `insurance_number` int(11) NOT NULL,
  `insurance_type_id` int(11) NOT NULL,
  `insurance_date` datetime NOT NULL,
  `expire_date` datetime NOT NULL,
  PRIMARY KEY (`insurance_number`),
  KEY `insurance_type_id_idx` (`insurance_type_id`),
  CONSTRAINT `fk_ins_insurance_type_id` FOREIGN KEY (`insurance_type_id`) REFERENCES `insurance_type` (`insurance_type_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` (`insurance_number`, `insurance_type_id`, `insurance_date`, `expire_date`) VALUES (1,1,'2012-12-03 00:00:00','2016-09-25 00:00:00'),(2,1,'2012-12-02 00:00:00','2016-10-19 00:00:00'),(3,2,'2013-01-18 00:00:00','2016-10-30 00:00:00'),(4,1,'2013-01-19 00:00:00','2016-11-21 00:00:00'),(5,2,'2013-04-06 00:00:00','2016-11-23 00:00:00'),(6,1,'2013-05-17 00:00:00','2017-01-05 00:00:00'),(7,2,'2013-06-03 00:00:00','2017-01-26 00:00:00'),(8,2,'2013-06-11 00:00:00','2017-02-16 00:00:00'),(9,1,'2013-07-22 00:00:00','2017-03-05 00:00:00'),(10,3,'2013-07-28 00:00:00','2017-03-21 00:00:00'),(11,5,'2013-08-07 00:00:00','2017-04-03 00:00:00'),(12,3,'2013-08-08 00:00:00','2017-05-06 00:00:00'),(13,4,'2013-09-10 00:00:00','2017-05-13 00:00:00'),(14,3,'2013-09-21 00:00:00','2017-07-01 00:00:00'),(15,5,'2013-10-04 00:00:00','2017-07-18 00:00:00'),(16,3,'2013-10-09 00:00:00','2017-08-01 00:00:00'),(17,4,'2013-10-15 00:00:00','2017-08-09 00:00:00'),(18,3,'2013-11-12 00:00:00','2017-09-11 00:00:00'),(19,2,'2013-11-16 00:00:00','2017-10-05 00:00:00'),(20,4,'2013-11-17 00:00:00','2017-10-21 00:00:00'),(21,1,'2013-11-21 00:00:00','2017-10-23 00:00:00'),(22,4,'2013-11-28 00:00:00','2017-11-13 00:00:00'),(23,1,'2013-12-05 00:00:00','2017-11-16 00:00:00');
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance_type`
--

DROP TABLE IF EXISTS `insurance_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insurance_type` (
  `insurance_type_id` int(11) NOT NULL,
  `insurance_name` varchar(45) NOT NULL,
  `max_insurance_amount` varchar(45) NOT NULL,
  PRIMARY KEY (`insurance_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_type`
--

LOCK TABLES `insurance_type` WRITE;
/*!40000 ALTER TABLE `insurance_type` DISABLE KEYS */;
INSERT INTO `insurance_type` (`insurance_type_id`, `insurance_name`, `max_insurance_amount`) VALUES (1,'Accidental','150000'),(2,'Acute Care','50000'),(3,'Dependent Coverage','100000'),(4,'Indemnity Plan','80000'),(5,'Long-Term Care','200000'),(6,'Medicare','60000'),(7,'Vision Care Coverage','10000');
/*!40000 ALTER TABLE `insurance_type` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `medicine_prescription` (`medicine_id`, `prescription_id`, `quantity`) VALUES (1,1,2),(2,1,2),(3,1,3),(1,2,2),(5,2,3),(2,3,1),(3,3,2),(8,3,4),(14,3,1),(1,4,2),(15,4,3),(6,4,1),(8,5,2),(4,5,2),(1,6,1),(9,7,4),(11,7,2),(12,7,3),(4,8,1),(7,8,2),(2,9,3),(6,9,1),(14,9,4),(2,10,1),(1,10,2),(13,10,3),(12,10,1),(3,11,2),(4,11,1),(8,12,2),(6,12,2),(9,12,3),(15,12,3),(15,13,1),(1,13,2),(7,13,2),(5,14,1);
/*!40000 ALTER TABLE `medicine_prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicines`
--

DROP TABLE IF EXISTS `medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicines` (
  `medicine_id` int(11) NOT NULL,
  `medicine_name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines`
--

LOCK TABLES `medicines` WRITE;
/*!40000 ALTER TABLE `medicines` DISABLE KEYS */;
INSERT INTO `medicines` (`medicine_id`, `medicine_name`, `price`) VALUES (1,'Aspirin',3),(2,'abacavir',6),(3,'Abenol',10),(4,'Acova',35),(5,'Caduet',15),(6,'Cycloset',20),(7,'Gabitril',5),(8,'Gynodiol',9),(9,'Ibudone',10),(10,'Macitentan',18),(11,'methadone',22),(12,'Pacerone',20),(13,'Phlemex',26),(14,'Sabril',5),(15,'Soma',30);
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `out_house_patient`
--

DROP TABLE IF EXISTS `out_house_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `out_house_patient` (
  `patient_id` int(11) NOT NULL,
  `next_checkin_date` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  CONSTRAINT `fk_outpat_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_house_patient`
--

LOCK TABLES `out_house_patient` WRITE;
/*!40000 ALTER TABLE `out_house_patient` DISABLE KEYS */;
INSERT INTO `out_house_patient` (`patient_id`, `next_checkin_date`) VALUES (3,'2016-12-11 11:00:00'),(4,'2016-09-15 00:00:00'),(5,'2016-12-12 09:00:00'),(8,'2016-10-29 00:00:00'),(10,'2016-11-29 00:00:00');
/*!40000 ALTER TABLE `out_house_patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `admission_date` datetime DEFAULT NULL,
  `previous_stay_flag` char(1) NOT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `patient_type` int(11) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `person_for_patient` (`person_id`),
  KEY `person_id_idx` (`person_id`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `fk_pat_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_pat_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`patient_id`, `role_id`, `person_id`, `admission_date`, `previous_stay_flag`, `reason`, `patient_type`) VALUES (1,1,1,'2016-08-13 00:00:00','N','surgery for broken leg',1),(2,1,5,'2016-08-15 00:00:00','Y','surgery for hernia',1),(3,1,6,'2016-08-31 00:00:00','Y','blood test',0),(4,1,7,'2016-09-05 00:00:00','Y','xray for ankle',0),(5,1,9,'2016-09-13 00:00:00','N','Pneumonia',0),(6,1,10,'2016-09-13 00:00:00','Y','Pulmonary heart disease',1),(7,1,11,'2016-09-25 00:00:00','N','Pulmonary heart disease',1),(8,1,12,'2016-10-19 00:00:00','N','Intestinal infection',0),(9,1,13,'2016-10-30 00:00:00','Y','Pulmonary heart disease',1),(10,1,14,'2016-11-21 00:00:00','Y','xray for little finger',0),(11,1,15,'2016-11-23 00:00:00','Y','surgery for neck',1);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`localhost`*/ /*!50003 TRIGGER patient_accounting
	BEFORE UPDATE
	ON patient
	FOR EACH ROW
BEGIN
	INSERT INTO patient_backup(patient_id, role_id, person_id, admission_date, previous_stay_flag, reason, patient_type) value (OLD.patient_id, OLD.role_id, OLD.person_id, OLD.admission_date, OLD.previous_stay_flag, OLD.reason, OLD.patient_type);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `patient_backup`
--

DROP TABLE IF EXISTS `patient_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_backup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  `admission_date` datetime DEFAULT NULL,
  `previous_stay_flag` char(1) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `patient_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_backup`
--

LOCK TABLES `patient_backup` WRITE;
/*!40000 ALTER TABLE `patient_backup` DISABLE KEYS */;
INSERT INTO `patient_backup` (`id`, `patient_id`, `role_id`, `person_id`, `admission_date`, `previous_stay_flag`, `reason`, `patient_type`) VALUES (1,11,1,15,'2016-11-23 00:00:00','Y','surgery for neck',1),(2,11,1,15,'2016-11-23 00:00:00','Y','surgery for neck',0),(3,11,1,15,'2016-11-23 00:00:00','Y','surgery for neck',1),(4,11,1,15,'2016-11-23 00:00:00','Y','surgery for neck',0);
/*!40000 ALTER TABLE `patient_backup` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `person` (`person_id`, `first_name`, `last_name`, `address_id`, `email_id`, `contact_numnber`, `insurance_number`) VALUES (1,'Gaurang','Deshpande',NULL,'gaurang.deshpande@gmail.com','4016631737',NULL),(2,'Shamal','Bhole',2,'shamal.bhole@gmail.com','4092814850',2),(3,'Vandana','Tiwari',3,'vandana.tiwari@gmail.com','4324058361',3),(4,'Vihar','Raul',4,'vihar.raul@gmail.com','3456783245',7),(5,'Amita','Murali',5,'amita.murali@gmail.com','7629274212',4),(6,'Rutika','Araokar',6,'rutika.araokar@gmail.com','5024591098',9),(7,'Bhavesh','Sachdev',7,'bhavesh.sachdev@gmail.com','6720018901',NULL),(8,'Shritu','Mehta',8,'shritu.mehta@gmail.com','2013948564',8),(9,'Sneha','Shetty',NULL,'sneha.shetty@gmail.com','9387120301',5),(10,'Manish','Patil',9,'manish.patil@gmail.com','3839205968',1),(11,'Shailesh','Hegde',10,'shailesh.hegde@gmail.com','3895048271',6),(12,'Antriksh','Sharma',NULL,'antriksh.sharma@gmail.com','2372335802',11),(13,'Avee','Arora',11,'avee.arora@gmail.com','5643567765',16),(14,'Ketki','Deshpande',12,'ketki.deshpande@gmail.com','9876523464',19),(15,'Neeraj','Rajput',NULL,'neeraj.rajput@gmail.com','3245677654',12),(16,'Saurabh','Rao',13,'saurabh.rao@gmail.com','3567876545',NULL),(17,'Pratiksha','Shetty',14,'pratiksha.shetty@gmail.com','8972439875',10),(18,'Suprita','Puned',15,'suprita.puned@gmail.com','8762376864',13),(19,'Shivam','Negi',NULL,'shivam.negi@gmail.com','9876132425',15),(20,'Shrikant','Mudholkar',16,'shrikant.mudholkar@gmail.com','3245678765',14),(21,'Sushrut','Tadwalkar',17,'sushrut.tadwalkar@gmail.com','4369876524',19),(22,'Kedar','Deshmukh',18,'kedar.deshmukh@gmail.com','4328762436',22),(23,'Rohan','Jahagirdar',NULL,'rohan.jahagirdar@gmail.com','9876543212',NULL),(24,'Lahari','Palle',19,'lahari.palle@gmail.com','2436776543',20),(25,'Akansha','Harshe',20,'akansha.harshe@gmail.com','3425678765',21),(26,'Shephali','Mahajan',21,'shephali.mahajan@gmail.com','4368756442',NULL),(27,'Priyal','Chaudhari',22,'priyal.chaudhari@gmail.com','5786435456',23);
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
INSERT INTO `prescription` (`prescription_id`, `prescription_date`, `prescription_till`, `dose_per_day`, `prescribed_by`, `prescribed_to`) VALUES (1,'2016-08-13 00:00:00','2016-08-28 00:00:00',2,4,1),(2,'2016-08-15 00:00:00','2016-08-31 00:00:00',2,5,2),(3,'2016-08-31 00:00:00','2016-09-21 00:00:00',3,6,3),(4,'2016-09-05 00:00:00','2016-09-24 00:00:00',2,6,4),(5,'2016-09-13 00:00:00','2016-09-29 00:00:00',3,7,5),(6,'2016-09-13 00:00:00','2016-09-23 00:00:00',3,2,6),(7,'2016-09-25 00:00:00','2016-10-05 00:00:00',2,2,7),(8,'2016-10-19 00:00:00','2016-11-09 00:00:00',1,5,8),(9,'2016-10-30 00:00:00','2016-11-15 00:00:00',2,2,9),(10,'2016-11-21 00:00:00','2016-12-21 00:00:00',1,4,10),(11,'2016-11-23 00:00:00','2016-12-23 00:00:00',1,6,11),(12,'2016-09-01 00:00:00','2016-09-21 00:00:00',3,5,2),(13,'2016-09-25 00:00:00','2016-10-15 00:00:00',2,1,4),(14,'2016-09-30 00:00:00','2016-10-20 00:00:00',2,7,5);
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `prescription_bill_view`
--

DROP TABLE IF EXISTS `prescription_bill_view`;
/*!50001 DROP VIEW IF EXISTS `prescription_bill_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `prescription_bill_view` AS SELECT 
 1 AS `patient_id`,
 1 AS `prescription_id`,
 1 AS `prescription_bill`*/;
SET character_set_client = @saved_cs_client;

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
INSERT INTO `previous_checkin_dates` (`id`, `patient_id`, `previous_checkin_dates`) VALUES (1,3,'2016-08-31 00:00:00'),(2,3,'2016-09-11 00:00:00'),(3,3,'2016-09-18 00:00:00'),(4,3,'2016-09-26 00:00:00'),(5,3,'2016-10-05 00:00:00'),(6,3,'2016-10-26 00:00:00'),(7,3,'2016-11-18 00:00:00'),(8,4,'2016-09-05 00:00:00'),(9,4,'2016-09-15 00:00:00'),(10,4,'2016-09-25 00:00:00'),(11,4,'2016-10-05 00:00:00'),(12,4,'2016-10-15 00:00:00'),(13,4,'2016-11-05 00:00:00'),(14,4,'2016-12-05 00:00:00'),(15,5,'2016-09-13 00:00:00'),(16,5,'2016-09-23 00:00:00'),(17,5,'2016-09-30 00:00:00'),(18,5,'2016-10-10 00:00:00'),(19,5,'2016-10-29 00:00:00'),(20,5,'2016-11-22 00:00:00'),(21,8,'2016-10-19 00:00:00'),(22,8,'2016-10-29 00:00:00'),(23,8,'2016-11-09 00:00:00'),(24,8,'2016-11-19 00:00:00'),(25,8,'2016-11-25 00:00:00'),(26,8,'2016-12-09 00:00:00'),(27,10,'2016-11-21 00:00:00'),(28,10,'2016-11-25 00:00:00'),(29,10,'2016-11-29 00:00:00'),(30,10,'2016-12-03 00:00:00'),(31,10,'2016-12-09 00:00:00');
/*!40000 ALTER TABLE `previous_checkin_dates` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `procedures` (`procedure_id`, `procedure_date`, `description`, `performed_by`, `performed_on`, `procedure_bill`) VALUES (1,'2016-08-15 00:00:00','blood test',3,1,90),(2,'2016-08-18 00:00:00','x ray scanning',9,1,150),(3,'2016-08-18 00:00:00','lab test',9,2,100),(4,'2016-09-02 00:00:00','blood test',5,3,90),(5,'2016-09-06 00:00:00','lab test',9,3,100),(6,'2016-09-06 00:00:00','blood test',8,4,90),(7,'2016-09-09 00:00:00','lab test',9,4,100),(8,'2016-11-24 00:00:00','x ray scanning',9,10,150),(9,'2016-09-15 00:00:00','CT scan',1,5,250),(10,'2016-10-21 00:00:00','lab test',9,8,100),(11,'2016-09-15 00:00:00','blood test',8,6,90),(12,'2016-09-18 00:00:00','blood test',9,6,90);
/*!40000 ALTER TABLE `procedures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`, `role_name`) VALUES (1,'patient'),(2,'doctor'),(3,'lab assistant'),(4,'front desk attendant'),(5,'hostAdmin'),(6,'nurse');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) NOT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`staff_id`),
  UNIQUE KEY `person_for_staff` (`person_id`),
  KEY `department_id_idx` (`department_id`),
  KEY `person_id_idx` (`person_id`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `fk_st_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_st_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_st_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` (`staff_id`, `department_id`, `designation`, `role_id`, `person_id`) VALUES (1,1,'MD',2,3),(2,2,'MS',2,2),(3,2,NULL,6,4),(4,5,'MBBS',2,8),(5,5,NULL,6,19),(6,6,'MBBS',2,21),(7,7,'MS',2,22),(8,10,NULL,6,18),(9,10,'BDS',3,17),(10,8,'MS',2,27),(11,6,'',6,26),(12,11,'Attendant',4,20);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surgery`
--

DROP TABLE IF EXISTS `surgery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `surgery` (
  `surgery_id` int(11) NOT NULL,
  `surgery_date` datetime NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `performed_on` int(11) NOT NULL,
  `surgery_bill` int(11) NOT NULL,
  PRIMARY KEY (`surgery_id`),
  KEY `performed_on_idx` (`performed_on`),
  CONSTRAINT `fk_sur_performed_on` FOREIGN KEY (`performed_on`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surgery`
--

LOCK TABLES `surgery` WRITE;
/*!40000 ALTER TABLE `surgery` DISABLE KEYS */;
INSERT INTO `surgery` (`surgery_id`, `surgery_date`, `description`, `performed_on`, `surgery_bill`) VALUES (1,'2016-09-13 00:00:00','aligning the broken bone',1,40000),(2,'2016-10-13 00:00:00','inserting the screws',1,50000),(3,'2016-09-10 00:00:00','normal hernia operation',2,90000),(4,'2016-11-30 00:00:00','surgery for vertibra alignment',11,10000),(5,'2016-12-02 00:00:00','surgery for inserting screws to fix the neck',11,50000),(6,'2016-12-10 00:00:00','surgery to remove the screws',11,60000);
/*!40000 ALTER TABLE `surgery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surgery_assistance`
--

DROP TABLE IF EXISTS `surgery_assistance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `surgery_assistance` (
  `surgery_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  KEY `surgery_id_idx` (`surgery_id`),
  KEY `staff_id_idx` (`staff_id`),
  CONSTRAINT `fk_sras_staff_id` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_suas_surgery_id` FOREIGN KEY (`surgery_id`) REFERENCES `surgery` (`surgery_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surgery_assistance`
--

LOCK TABLES `surgery_assistance` WRITE;
/*!40000 ALTER TABLE `surgery_assistance` DISABLE KEYS */;
INSERT INTO `surgery_assistance` (`surgery_id`, `staff_id`) VALUES (1,1),(1,10),(1,11),(2,1),(2,10),(2,11),(3,4),(3,5),(3,1),(4,1),(4,7),(4,4),(4,6),(4,11),(5,1),(5,7),(5,4),(5,6),(5,11),(6,1),(6,7),(6,4),(6,6),(6,11);
/*!40000 ALTER TABLE `surgery_assistance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'project'
--

--
-- Dumping routines for database 'project'
