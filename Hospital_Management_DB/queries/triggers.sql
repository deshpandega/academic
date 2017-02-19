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
##########################################################################################################################


#Won't work
#Because modifying or trying to update one or more different rows in the same table as the trigger, that is not allowed.
drop trigger patient_department_past_modification;

DELIMITER $$
CREATE TRIGGER patient_department_past_modification
	BEFORE INSERT
	ON department_patient_past
	FOR EACH ROW
BEGIN
	UPDATE department_patient_past SET department_patient_past.current_department_flag = 'N' WHERE NEW.patient_id = NEW.patient_id;
END;
$$