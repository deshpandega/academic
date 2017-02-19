-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: project_backup_12_11
-- Source Schemata: project
-- Created: Sun Dec 11 03:39:59 2016
-- Workbench Version: 6.3.6
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema project_backup_12_11
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `project_backup_12_11` ;
CREATE SCHEMA IF NOT EXISTS `project_backup_12_11` ;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.address
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`address` (
  `address_id` INT(11) NOT NULL,
  `address_line1` VARCHAR(45) NOT NULL,
  `address_line2` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(5) NOT NULL,
  `zip` VARCHAR(5) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`address_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.appointment
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`appointment` (
  `appointment_id` INT(11) NOT NULL,
  `appointment_start_date_time` DATETIME NOT NULL,
  `booked_by` INT(11) NOT NULL,
  `booked_for` INT(11) NOT NULL,
  `reason` VARCHAR(100) NULL DEFAULT NULL,
  `appointment_bill` INT(11) NOT NULL,
  `appointment_end_date_time` DATETIME NOT NULL,
  PRIMARY KEY (`appointment_id`),
  INDEX `booked_by_idx` (`booked_by` ASC),
  INDEX `booked_for_idx` (`booked_for` ASC),
  CONSTRAINT `fk_app_booked_by`
    FOREIGN KEY (`booked_by`)
    REFERENCES `project_backup_12_11`.`patient` (`patient_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_app_booked_for`
    FOREIGN KEY (`booked_for`)
    REFERENCES `project_backup_12_11`.`staff` (`staff_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.billing
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`billing` (
  `bill_id` INT(11) NOT NULL,
  `bill_date` DATETIME NOT NULL,
  `patient_id` INT(11) NOT NULL,
  `bill_amount` INT(11) NULL DEFAULT NULL,
  `insurance_amount` INT(11) NULL DEFAULT NULL,
  `final_bill_amount` INT(11) NULL DEFAULT NULL,
  `bill_start_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  INDEX `fk_bill_patient_id_idx` (`patient_id` ASC),
  CONSTRAINT `fk_bill_patient_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `project_backup_12_11`.`patient` (`patient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.department
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`department` (
  `department_id` INT(11) NOT NULL AUTO_INCREMENT,
  `department_name` VARCHAR(45) NOT NULL,
  `hospital_id` INT(11) NOT NULL,
  PRIMARY KEY (`department_id`),
  INDEX `hospital_id_idx` (`hospital_id` ASC),
  CONSTRAINT `fk_dep_hospital_id`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `project_backup_12_11`.`hospital` (`hospital_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.department_patient_past
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`department_patient_past` (
  `department_id` INT(11) NOT NULL,
  `patient_id` INT(11) NOT NULL,
  `current_department_flag` CHAR(5) NOT NULL,
  INDEX `department_id_idx` (`department_id` ASC),
  INDEX `patient_id_idx` (`patient_id` ASC),
  CONSTRAINT `fk_deppat_department_id`
    FOREIGN KEY (`department_id`)
    REFERENCES `project_backup_12_11`.`department` (`department_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_deppat_patient_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `project_backup_12_11`.`patient` (`patient_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.hospital
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`hospital` (
  `hospital_id` INT(11) NOT NULL AUTO_INCREMENT,
  `hospital_name` VARCHAR(45) NOT NULL,
  `contact_number` VARCHAR(45) NOT NULL,
  `address_id` INT(11) NOT NULL,
  PRIMARY KEY (`hospital_id`),
  INDEX `fk_Hospital_Address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_hosp_address_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `project_backup_12_11`.`address` (`address_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.in_house_patient
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`in_house_patient` (
  `patient_id` INT(11) NOT NULL,
  `bed_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`patient_id`),
  CONSTRAINT `fk_inpat_patient_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `project_backup_12_11`.`patient` (`patient_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.insurance
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`insurance` (
  `insurance_number` INT(11) NOT NULL,
  `insurance_type_id` INT(11) NOT NULL,
  `insurance_date` DATETIME NOT NULL,
  `expire_date` DATETIME NOT NULL,
  PRIMARY KEY (`insurance_number`),
  INDEX `insurance_type_id_idx` (`insurance_type_id` ASC),
  CONSTRAINT `fk_ins_insurance_type_id`
    FOREIGN KEY (`insurance_type_id`)
    REFERENCES `project_backup_12_11`.`insurance_type` (`insurance_type_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.insurance_type
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`insurance_type` (
  `insurance_type_id` INT(11) NOT NULL,
  `insurance_name` VARCHAR(45) NOT NULL,
  `max_insurance_amount` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`insurance_type_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.medicine_prescription
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`medicine_prescription` (
  `medicine_id` INT(11) NOT NULL,
  `prescription_id` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL DEFAULT '0',
  INDEX `medicine_id_idx` (`medicine_id` ASC),
  INDEX `prescription_id_idx` (`prescription_id` ASC),
  CONSTRAINT `fk_medPr_medicine_id`
    FOREIGN KEY (`medicine_id`)
    REFERENCES `project_backup_12_11`.`medicines` (`medicine_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_medPr_prescription_id`
    FOREIGN KEY (`prescription_id`)
    REFERENCES `project_backup_12_11`.`prescription` (`prescription_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.medicines
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`medicines` (
  `medicine_id` INT(11) NOT NULL,
  `medicine_name` VARCHAR(45) NOT NULL,
  `price` INT(11) NOT NULL,
  PRIMARY KEY (`medicine_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.out_house_patient
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`out_house_patient` (
  `patient_id` INT(11) NOT NULL,
  `next_checkin_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  CONSTRAINT `fk_outpat_patient_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `project_backup_12_11`.`patient` (`patient_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.patient
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`patient` (
  `patient_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  `person_id` INT(11) NOT NULL,
  `admission_date` DATETIME NULL DEFAULT NULL,
  `previous_stay_flag` CHAR(1) NOT NULL,
  `reason` VARCHAR(100) NULL DEFAULT NULL,
  `patient_type` INT(11) NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE INDEX `person_for_patient` (`person_id` ASC),
  INDEX `person_id_idx` (`person_id` ASC),
  INDEX `role_id_idx` (`role_id` ASC),
  CONSTRAINT `fk_pat_person_id`
    FOREIGN KEY (`person_id`)
    REFERENCES `project_backup_12_11`.`person` (`person_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pat_role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `project_backup_12_11`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.patient_backup
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`patient_backup` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NOT NULL,
  `role_id` INT(11) NULL DEFAULT NULL,
  `person_id` INT(11) NULL DEFAULT NULL,
  `admission_date` DATETIME NULL DEFAULT NULL,
  `previous_stay_flag` CHAR(1) NULL DEFAULT NULL,
  `reason` VARCHAR(100) NULL DEFAULT NULL,
  `patient_type` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.person
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`person` (
  `person_id` INT(11) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address_id` INT(11) NULL DEFAULT NULL,
  `email_id` VARCHAR(70) NULL DEFAULT NULL,
  `contact_numnber` VARCHAR(45) NULL DEFAULT NULL,
  `insurance_number` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  INDEX `address_id_idx` (`address_id` ASC),
  INDEX `insurance_number_idx` (`insurance_number` ASC),
  CONSTRAINT `fk_per_address_id`
    FOREIGN KEY (`address_id`)
    REFERENCES `project_backup_12_11`.`address` (`address_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_per_insurance_number`
    FOREIGN KEY (`insurance_number`)
    REFERENCES `project_backup_12_11`.`insurance` (`insurance_number`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.prescription
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`prescription` (
  `prescription_id` INT(11) NOT NULL,
  `prescription_date` DATETIME NOT NULL,
  `prescription_till` DATETIME NOT NULL,
  `dose_per_day` INT(11) NOT NULL,
  `prescribed_by` INT(11) NOT NULL,
  `prescribed_to` INT(11) NOT NULL,
  PRIMARY KEY (`prescription_id`),
  INDEX `prescribed_by_idx` (`prescribed_by` ASC),
  INDEX `prescribed_to_idx` (`prescribed_to` ASC),
  CONSTRAINT `fk_pre_prescribed_by`
    FOREIGN KEY (`prescribed_by`)
    REFERENCES `project_backup_12_11`.`staff` (`staff_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pre_prescribed_to`
    FOREIGN KEY (`prescribed_to`)
    REFERENCES `project_backup_12_11`.`patient` (`patient_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.previous_checkin_dates
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`previous_checkin_dates` (
  `id` INT(11) NOT NULL,
  `patient_id` INT(11) NOT NULL,
  `previous_checkin_dates` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `patient_id_idx` (`patient_id` ASC),
  CONSTRAINT `fk_prevch_patient_id`
    FOREIGN KEY (`patient_id`)
    REFERENCES `project_backup_12_11`.`out_house_patient` (`patient_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.procedures
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`procedures` (
  `procedure_id` INT(11) NOT NULL,
  `procedure_date` DATETIME NOT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  `performed_by` INT(11) NOT NULL,
  `performed_on` INT(11) NOT NULL,
  `procedure_bill` INT(11) NOT NULL,
  PRIMARY KEY (`procedure_id`),
  INDEX `performed_by_idx` (`performed_by` ASC),
  INDEX `performed_on_idx` (`performed_on` ASC),
  CONSTRAINT `fk_pro_performed_by`
    FOREIGN KEY (`performed_by`)
    REFERENCES `project_backup_12_11`.`staff` (`staff_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pro_performed_on`
    FOREIGN KEY (`performed_on`)
    REFERENCES `project_backup_12_11`.`patient` (`patient_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.role
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`role` (
  `role_id` INT(11) NOT NULL,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.staff
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`staff` (
  `staff_id` INT(11) NOT NULL AUTO_INCREMENT,
  `department_id` INT(11) NOT NULL,
  `designation` VARCHAR(45) NULL DEFAULT NULL,
  `role_id` INT(11) NOT NULL,
  `person_id` INT(11) NOT NULL,
  PRIMARY KEY (`staff_id`),
  UNIQUE INDEX `person_for_staff` (`person_id` ASC),
  INDEX `department_id_idx` (`department_id` ASC),
  INDEX `person_id_idx` (`person_id` ASC),
  INDEX `role_id_idx` (`role_id` ASC),
  CONSTRAINT `fk_st_department_id`
    FOREIGN KEY (`department_id`)
    REFERENCES `project_backup_12_11`.`department` (`department_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_st_person_id`
    FOREIGN KEY (`person_id`)
    REFERENCES `project_backup_12_11`.`person` (`person_id`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_st_role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `project_backup_12_11`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.surgery
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`surgery` (
  `surgery_id` INT(11) NOT NULL,
  `surgery_date` DATETIME NOT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  `performed_on` INT(11) NOT NULL,
  `surgery_bill` INT(11) NOT NULL,
  PRIMARY KEY (`surgery_id`),
  INDEX `performed_on_idx` (`performed_on` ASC),
  CONSTRAINT `fk_sur_performed_on`
    FOREIGN KEY (`performed_on`)
    REFERENCES `project_backup_12_11`.`patient` (`patient_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table project_backup_12_11.surgery_assistance
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `project_backup_12_11`.`surgery_assistance` (
  `surgery_id` INT(11) NOT NULL,
  `staff_id` INT(11) NOT NULL,
  INDEX `surgery_id_idx` (`surgery_id` ASC),
  INDEX `staff_id_idx` (`staff_id` ASC),
  CONSTRAINT `fk_sras_staff_id`
    FOREIGN KEY (`staff_id`)
    REFERENCES `project_backup_12_11`.`staff` (`staff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_suas_surgery_id`
    FOREIGN KEY (`surgery_id`)
    REFERENCES `project_backup_12_11`.`surgery` (`surgery_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- View project_backup_12_11.billing_view
-- ----------------------------------------------------------------------------
USE `project_backup_12_11`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `project`.`billing_view` AS select `p`.`patient_id` AS `patient_id`,(case when isnull((select sum(`project`.`procedures`.`procedure_bill`) from `project`.`procedures` where ((`project`.`procedures`.`performed_on` = `p`.`patient_id`) and (`project`.`procedures`.`procedure_date` > `p`.`admission_date`)))) then 0 else (select sum(`project`.`procedures`.`procedure_bill`) from `project`.`procedures` where ((`project`.`procedures`.`performed_on` = `p`.`patient_id`) and (`project`.`procedures`.`procedure_date` > `p`.`admission_date`))) end) AS `Procedure_Expense`,(case when isnull((select sum(`project`.`surgery`.`surgery_bill`) from `project`.`surgery` where ((`project`.`surgery`.`performed_on` = `p`.`patient_id`) and (`project`.`surgery`.`surgery_date` > `p`.`admission_date`)))) then 0 else (select sum(`project`.`surgery`.`surgery_bill`) from `project`.`surgery` where ((`project`.`surgery`.`performed_on` = `p`.`patient_id`) and (`project`.`surgery`.`surgery_date` > `p`.`admission_date`))) end) AS `Surgery_Expense`,(case when isnull((select sum(`project`.`appointment`.`appointment_bill`) from `project`.`appointment` where ((`project`.`appointment`.`booked_by` = `p`.`patient_id`) and (`project`.`appointment`.`appointment_end_date_time` > `p`.`admission_date`)))) then 0 else (select sum(`project`.`appointment`.`appointment_bill`) from `project`.`appointment` where ((`project`.`appointment`.`booked_by` = `p`.`patient_id`) and (`project`.`appointment`.`appointment_end_date_time` > `p`.`admission_date`))) end) AS `Appointment_Expense`,(case when isnull((select sum(`prescription_bill_view`.`prescription_bill`) from (`project`.`prescription_bill_view` join `project`.`prescription`) where ((`prescription_bill_view`.`prescription_id` = `project`.`prescription`.`prescription_id`) and (`project`.`prescription`.`prescribed_to` = `p`.`patient_id`) and (`project`.`prescription`.`prescription_date` > `p`.`admission_date`)))) then 0 else (select sum(`prescription_bill_view`.`prescription_bill`) from (`project`.`prescription_bill_view` join `project`.`prescription`) where ((`prescription_bill_view`.`prescription_id` = `project`.`prescription`.`prescription_id`) and (`project`.`prescription`.`prescribed_to` = `p`.`patient_id`) and (`project`.`prescription`.`prescription_date` > `p`.`admission_date`))) end) AS `Prescription_Expense` from `project`.`patient` `p` group by `p`.`patient_id`;

-- ----------------------------------------------------------------------------
-- View project_backup_12_11.prescription_bill_view
-- ----------------------------------------------------------------------------
USE `project_backup_12_11`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `project`.`prescription_bill_view` AS select `p`.`prescribed_to` AS `patient_id`,`p`.`prescription_id` AS `prescription_id`,sum((`mp`.`quantity` * `m`.`price`)) AS `prescription_bill` from ((`project`.`prescription` `p` join `project`.`medicine_prescription` `mp` on((`p`.`prescription_id` = `mp`.`prescription_id`))) join `project`.`medicines` `m` on((`m`.`medicine_id` = `mp`.`medicine_id`))) group by `p`.`prescribed_to`;

-- ----------------------------------------------------------------------------
-- Routine project_backup_12_11.calculate_bill_procedure
-- ----------------------------------------------------------------------------
DELIMITER $$

DELIMITER $$
USE `project_backup_12_11`$$
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
END$$

DELIMITER ;

-- ----------------------------------------------------------------------------
-- Routine project_backup_12_11.debug_msg
-- ----------------------------------------------------------------------------
DELIMITER $$

DELIMITER $$
USE `project_backup_12_11`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `debug_msg`(enabled INTEGER, msg VARCHAR(255))
BEGIN
	IF enabled THEN 
		BEGIN
			select concat("** ", msg) AS '** DEBUG:';
		END; 
    END IF;
END$$

DELIMITER ;

-- ----------------------------------------------------------------------------
-- Routine project_backup_12_11.populate_bills
-- ----------------------------------------------------------------------------
DELIMITER $$

DELIMITER $$
USE `project_backup_12_11`$$
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
END$$

DELIMITER ;

-- ----------------------------------------------------------------------------
-- Trigger project_backup_12_11.out_patient_next_checkin_date
-- ----------------------------------------------------------------------------
DELIMITER $$
USE `project_backup_12_11`$$
CREATE DEFINER=`admin`@`localhost` TRIGGER out_patient_next_checkin_date
	AFTER INSERT
	ON appointment
	FOR EACH ROW
BEGIN
	CASE
		WHEN (SELECT distinct patient.patient_type FROM patient WHERE NEW.booked_by = patient.patient_id) = 0 THEN
			UPDATE out_house_patient SET next_checkin_date = NEW.appointment_start_date_time WHERE patient_id = NEW.booked_by;
	END CASE;
END;

-- ----------------------------------------------------------------------------
-- Trigger project_backup_12_11.patient_accounting
-- ----------------------------------------------------------------------------
DELIMITER $$
USE `project_backup_12_11`$$
CREATE DEFINER=`admin`@`localhost` TRIGGER patient_accounting
	BEFORE UPDATE
	ON patient
	FOR EACH ROW
BEGIN
	INSERT INTO patient_backup(patient_id, role_id, person_id, admission_date, previous_stay_flag, reason, patient_type) value (OLD.patient_id, OLD.role_id, OLD.person_id, OLD.admission_date, OLD.previous_stay_flag, OLD.reason, OLD.patient_type);
END;

-- ----------------------------------------------------------------------------
-- Trigger project_backup_12_11.validate_email
-- ----------------------------------------------------------------------------
DELIMITER $$
USE `project_backup_12_11`$$
CREATE DEFINER=`admin`@`localhost` TRIGGER validate_email
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
SET FOREIGN_KEY_CHECKS = 1;
