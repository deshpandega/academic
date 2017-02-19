/*!50003 DROP PROCEDURE IF EXISTS `calculate_bill_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calculate_bill_procedure`(In patient_id INT)
BEGIN
    SET @enabled = TRUE;
    #call debug_msg(@enabled, (SELECT concat_ws('', "patient ID - ",patient_id)));
	
	IF patient_id IN (SELECT patient_id FROM patient) THEN
		SELECT count(*)+1 INTO @bill_id FROM billing;
		
		SET @bill_date = NOW();
		SELECT billing_view.Procedure_Expense+billing_view.Surgery_Expense+billing_view.Appointment_Expense+billing_view.Prescription_Expense 
			INTO @bill_amount FROM billing_view WHERE billing_view.patient_id = patient_id;
		SELECT it.max_insurance_amount INTO @insurance_amount 
			FROM insurance_type it, insurance ins, person per, patient pat
			WHERE it.insurance_type_id = ins.insurance_type_id
			AND ins.insurance_number = per.insurance_number
			AND per.person_id = pat.person_id
			AND pat.patient_id = patient_id;
		
        IF @insurance_amount IS NULL THEN
			SET @insurance_amount = 0;
		END IF;
        
		IF @bill_amount > @insurance_amount THEN 
			SET @final_bill_amount = @bill_amount - @insurance_amount;
		ELSEIF @bill_amount <= @insurance_amount THEN
			SET @final_bill_amount = 0;
		END IF;
		SELECT patient.admission_date INTO @bill_start_date FROM patient WHERE patient.patient_id = patient_id;
        
        SELECT @bill_id, @bill_date, patient_id, @bill_amount, @insurance_amount, @final_bill_amount, @bill_start_date;
        
        IF patient_id NOT IN (SELECT b.patient_id FROM billing b) THEN
			call debug_msg(@enabled, (SELECT concat_ws('', "Bill ID 2 - ",@bill_id)));
			INSERT INTO `project`.`billing` (`bill_id`, `bill_date`, `patient_id`, `bill_amount`, `insurance_amount`, `final_bill_amount`, `bill_start_date`) 
				VALUES (@bill_id, @bill_date, patient_id, @bill_amount, @insurance_amount, @final_bill_amount, @bill_start_date);
		ELSE
			IF (SELECT patient.admission_date FROM patient WHERE patient.patient_id = patient_id) > (SELECT billing.bill_date FROM billing WHERE billing.patient_id = patient_id) THEN 
				INSERT INTO `project`.`billing` (`bill_id`, `bill_date`, `patient_id`, `bill_amount`, `insurance_amount`, `final_bill_amount`, `bill_start_date`) 
					VALUES (@bill_id, @bill_date, patient_id, @bill_amount, @insurance_amount, @final_bill_amount, @bill_start_date);
			END IF;
		END IF;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `debug_msg` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `debug_msg`(enabled INTEGER, msg VARCHAR(255))
BEGIN
	IF enabled THEN 
		BEGIN
			select concat("** ", msg) AS '** DEBUG:';
		END; 
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `populate_bills` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `populate_bills`(In patient_id INT)
BEGIN
	SET @pat_id = patient_id;
	population : LOOP
		IF @pat_id IN (SELECT patient_id FROM patient) THEN
			call debug_msg(@enabled, (SELECT concat_ws('', "patient ID - ",@pat_id)));
			CALL calculate_bill_procedure(@pat_id);
			SET @pat_id = @pat_id + 1;
            call debug_msg(@enabled, (SELECT concat_ws('', "patient ID after calculation- ",@pat_id)));
            ITERATE population;
		END IF;
        LEAVE population;
	END LOOP;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `billing_view`
--

/*!50001 DROP VIEW IF EXISTS `billing_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `billing_view` AS select `p`.`patient_id` AS `patient_id`,(case when isnull((select sum(`procedures`.`procedure_bill`) from `procedures` where ((`procedures`.`performed_on` = `p`.`patient_id`) and (`procedures`.`procedure_date` > `p`.`admission_date`)))) then 0 else (select sum(`procedures`.`procedure_bill`) from `procedures` where ((`procedures`.`performed_on` = `p`.`patient_id`) and (`procedures`.`procedure_date` > `p`.`admission_date`))) end) AS `Procedure_Expense`,(case when isnull((select sum(`surgery`.`surgery_bill`) from `surgery` where ((`surgery`.`performed_on` = `p`.`patient_id`) and (`surgery`.`surgery_date` > `p`.`admission_date`)))) then 0 else (select sum(`surgery`.`surgery_bill`) from `surgery` where ((`surgery`.`performed_on` = `p`.`patient_id`) and (`surgery`.`surgery_date` > `p`.`admission_date`))) end) AS `Surgery_Expense`,(case when isnull((select sum(`appointment`.`appointment_bill`) from `appointment` where ((`appointment`.`booked_by` = `p`.`patient_id`) and (`appointment`.`appointment_end_date_time` > `p`.`admission_date`)))) then 0 else (select sum(`appointment`.`appointment_bill`) from `appointment` where ((`appointment`.`booked_by` = `p`.`patient_id`) and (`appointment`.`appointment_end_date_time` > `p`.`admission_date`))) end) AS `Appointment_Expense`,(case when isnull((select sum(`prescription_bill_view`.`prescription_bill`) from (`prescription_bill_view` join `prescription`) where ((`prescription_bill_view`.`prescription_id` = `prescription`.`prescription_id`) and (`prescription`.`prescribed_to` = `p`.`patient_id`) and (`prescription`.`prescription_date` > `p`.`admission_date`)))) then 0 else (select sum(`prescription_bill_view`.`prescription_bill`) from (`prescription_bill_view` join `prescription`) where ((`prescription_bill_view`.`prescription_id` = `prescription`.`prescription_id`) and (`prescription`.`prescribed_to` = `p`.`patient_id`) and (`prescription`.`prescription_date` > `p`.`admission_date`))) end) AS `Prescription_Expense` from `patient` `p` group by `p`.`patient_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `prescription_bill_view`
--

/*!50001 DROP VIEW IF EXISTS `prescription_bill_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prescription_bill_view` AS select `p`.`prescribed_to` AS `patient_id`,`p`.`prescription_id` AS `prescription_id`,sum((`mp`.`quantity` * `m`.`price`)) AS `prescription_bill` from ((`prescription` `p` join `medicine_prescription` `mp` on((`p`.`prescription_id` = `mp`.`prescription_id`))) join `medicines` `m` on((`m`.`medicine_id` = `mp`.`medicine_id`))) group by `p`.`prescribed_to` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- ----------------------------------------------------------------------------
-- Trigger project.out_patient_next_checkin_date
-- ----------------------------------------------------------------------------

drop trigger out_patient_next_checkin_date;

DELIMITER $$
CREATE TRIGGER out_patient_next_checkin_date
  AFTER INSERT
  ON appointment
  FOR EACH ROW
BEGIN
  CASE
    WHEN (SELECT distinct patient.patient_type FROM patient WHERE NEW.booked_by = patient.patient_id) = 0 THEN
      UPDATE out_house_patient SET next_checkin_date = NEW.appointment_start_date_time WHERE patient_id = NEW.booked_by;
  END CASE;
END;
$$
##########################################################################################################################

-- ----------------------------------------------------------------------------
-- Trigger project.patient_accounting
-- ----------------------------------------------------------------------------

drop trigger patient_accounting;

DELIMITER $$
CREATE TRIGGER patient_accounting
  BEFORE UPDATE
  ON patient
  FOR EACH ROW
BEGIN
  INSERT INTO patient_backup(patient_id, role_id, person_id, admission_date, previous_stay_flag, reason, patient_type) 
    value (OLD.patient_id, OLD.role_id, OLD.person_id, OLD.admission_date, OLD.previous_stay_flag, OLD.reason, OLD.patient_type);
END;
$$
###########################################################################################################################

-- ----------------------------------------------------------------------------
-- Trigger project.validate_email
-- ----------------------------------------------------------------------------

drop trigger validate_email;

DELIMITER $$
CREATE TRIGGER validate_email
  BEFORE INSERT
  ON person
  FOR EACH ROW
BEGIN
  IF NEW.email_id NOT LIKE '%_@%_.__%' 
    THEN
    SIGNAL SQLSTATE VALUE '45000'
    SET MESSAGE_TEXT = 'email column is not valid';
  END IF;
END;
$$
##########################################################################################################################

-- ----------------------------------------------------------------------------
-- Trigger project.validate_contact_number
-- ----------------------------------------------------------------------------

drop trigger validate_contact_number;

DELIMITER $$
CREATE TRIGGER validate_contact_number
  BEFORE INSERT
  ON person
  FOR EACH ROW
BEGIN
  IF CHAR_LENGTH(NEW.contact_numnber) <> 10
    THEN
    SIGNAL SQLSTATE VALUE '45000'
    SET MESSAGE_TEXT = 'contact number is not valid';
  END IF;
END;
$$
############################################################################################################
DROP USER 'admin'@'localhost';
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON *.* to 'admin'@'localhost' with grant option;
SHOW GRANTS FOR 'admin'@'localhost';

SELECT user FROM mysql.user;

DROP USER 'anotheruser'@'localhost';
DROP USER 'adminuser'@'localhost';
DROP USER 'customuser'@'localhost';

DROP USER 'frontdesk'@'localhost';
CREATE USER 'frontdesk'@'localhost' IDENTIFIED BY 'frontdesk';
GRANT INSERT, SELECT, DELETE, UPDATE on project.patient to 'frontdesk'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.billing to 'frontdesk'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.person to 'frontdesk'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.address to 'frontdesk'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.in_house_patient to 'frontdesk'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.out_house_patient to 'frontdesk'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.previous_checkin_dates to 'frontdesk'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.department_patient_past to 'frontdesk'@'localhost';
GRANT SELECT on project.staff to 'frontdesk'@'localhost';
GRANT SELECT on project.surgery_assistance to 'frontdesk'@'localhost';
GRANT SELECT on project.insurance to 'frontdesk'@'localhost';
GRANT SELECT on project.surgery to 'frontdesk'@'localhost';
GRANT SELECT on project.procedures to 'frontdesk'@'localhost';
GRANT SELECT on project.prescription to 'frontdesk'@'localhost';
GRANT SELECT on project.medicines to 'frontdesk'@'localhost';
GRANT SELECT on project.medicine_prescription to 'frontdesk'@'localhost';
GRANT SELECT on project.appointment to 'frontdesk'@'localhost';
SHOW GRANTS FOR 'frontdesk'@'localhost';

DROP USER 'doctor'@'localhost';
CREATE USER 'doctor'@'localhost' IDENTIFIED BY 'doctor';
GRANT INSERT, SELECT, DELETE, UPDATE on project.surgery to 'doctor'@'localhost';
#REVOKE INSERT, DELETE, UPDATE on project.procedures FROM 'doctor'@'localhost';
GRANT SELECT on project.procedures to 'doctor'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.prescription to 'doctor'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.medicines to 'doctor'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.appointment to 'doctor'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.medicine_prescription to 'doctor'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.surgery_assistance to 'doctor'@'localhost';
GRANT SELECT on project.patient to 'doctor'@'localhost';
GRANT SELECT on project.in_house_patient to 'doctor'@'localhost';
GRANT SELECT on project.out_house_patient to 'doctor'@'localhost';
GRANT SELECT on project.previous_checkin_dates to 'doctor'@'localhost';
SHOW GRANTS FOR 'doctor'@'localhost';

DROP USER 'labassistance'@'localhost';
CREATE USER 'labassistance'@'localhost' IDENTIFIED BY 'labassistance';
GRANT SELECT on project.surgery to 'labassistance'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.procedures to 'labassistance'@'localhost';
GRANT SELECT on project.prescription to 'labassistance'@'localhost';
GRANT SELECT on project.medicines to 'labassistance'@'localhost';
GRANT INSERT, SELECT, DELETE, UPDATE on project.appointment to 'labassistance'@'localhost';
GRANT SELECT on project.medicine_prescription to 'labassistance'@'localhost';
GRANT SELECT on project.surgery_assistance to 'labassistance'@'localhost';
GRANT SELECT on project.patient to 'labassistance'@'localhost';
GRANT SELECT on project.in_house_patient to 'labassistance'@'localhost';
GRANT SELECT on project.out_house_patient to 'labassistance'@'localhost';
GRANT SELECT on project.previous_checkin_dates to 'labassistance'@'localhost';
SHOW GRANTS FOR 'labassistance'@'localhost';
-- Dump completed on 2016-12-11  13:24:38
