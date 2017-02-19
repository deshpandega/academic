CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON *.* to 'admin'@'localhost' with grant option;
SHOW GRANTS FOR 'admin'@'localhost';

SELECT user FROM mysql.user;

DROP USER 'anotheruser'@'localhost';
DROP USER 'adminuser'@'localhost';
DROP USER 'customuser'@'localhost';

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