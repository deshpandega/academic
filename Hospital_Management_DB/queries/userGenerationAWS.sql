
CREATE USER 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON project.* to 'admin'@'%' with grant option;
SHOW GRANTS FOR 'admin'@'%';

SELECT user FROM mysql.user;

DROP USER 'admin'@'%';
DROP USER 'doctor'@'%';
DROP USER 'frontdesk'@'%';
DROP USER 'labassistance'@'%';

CREATE USER 'frontdesk'@'%' IDENTIFIED BY 'frontdesk';
GRANT INSERT, SELECT, DELETE, UPDATE on project.patient to 'frontdesk'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.billing to 'frontdesk'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.person to 'frontdesk'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.address to 'frontdesk'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.in_house_patient to 'frontdesk'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.out_house_patient to 'frontdesk'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.previous_checkin_dates to 'frontdesk'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.department_patient_past to 'frontdesk'@'%';
GRANT SELECT on project.staff to 'frontdesk'@'%';
GRANT SELECT on project.surgery_assistance to 'frontdesk'@'%';
GRANT SELECT on project.insurance to 'frontdesk'@'%';
GRANT SELECT on project.surgery to 'frontdesk'@'%';
GRANT SELECT on project.procedures to 'frontdesk'@'%';
GRANT SELECT on project.prescription to 'frontdesk'@'%';
GRANT SELECT on project.medicines to 'frontdesk'@'%';
GRANT SELECT on project.medicine_prescription to 'frontdesk'@'%';
GRANT SELECT on project.appointment to 'frontdesk'@'%';
SHOW GRANTS FOR 'frontdesk'@'%';

CREATE USER 'doctor'@'%' IDENTIFIED BY 'doctor';
GRANT INSERT, SELECT, DELETE, UPDATE on project.surgery to 'doctor'@'%';
#REVOKE INSERT, DELETE, UPDATE on project.procedures FROM 'doctor'@'localhost';
GRANT SELECT on project.procedures to 'doctor'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.prescription to 'doctor'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.medicines to 'doctor'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.appointment to 'doctor'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.medicine_prescription to 'doctor'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.surgery_assistance to 'doctor'@'%';
GRANT SELECT on project.patient to 'doctor'@'%';
GRANT SELECT on project.in_house_patient to 'doctor'@'%';
GRANT SELECT on project.out_house_patient to 'doctor'@'%';
GRANT SELECT on project.previous_checkin_dates to 'doctor'@'%';
SHOW GRANTS FOR 'doctor'@'%';

CREATE USER 'labassistance'@'%' IDENTIFIED BY 'labassistance';
GRANT SELECT on project.surgery to 'labassistance'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.procedures to 'labassistance'@'%';
GRANT SELECT on project.prescription to 'labassistance'@'%';
GRANT SELECT on project.medicines to 'labassistance'@'%';
GRANT INSERT, SELECT, DELETE, UPDATE on project.appointment to 'labassistance'@'%';
GRANT SELECT on project.medicine_prescription to 'labassistance'@'%';
GRANT SELECT on project.surgery_assistance to 'labassistance'@'%';
GRANT SELECT on project.patient to 'labassistance'@'%';
GRANT SELECT on project.in_house_patient to 'labassistance'@'%';
GRANT SELECT on project.out_house_patient to 'labassistance'@'%';
GRANT SELECT on project.previous_checkin_dates to 'labassistance'@'%';
SHOW GRANTS FOR 'labassistance'@'%';