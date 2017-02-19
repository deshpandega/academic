#Top 3 Most Expensive surgeries
SELECT surgery_id, surgery_date, description, surgery_bill FROM surgery ORDER BY surgery_bill DESC LIMIT 3;

#People who paid the amount for a single surgery
SELECT sur.surgery_id, concat(p.first_name, ' ', p.last_name), sur.description, concat('$',sur.surgery_bill )  FROM person p
	JOIN patient pt ON (pt.person_id = p.person_id)
    JOIN surgery sur ON (pt.patient_id = sur.performed_on)
    GROUP BY sur.surgery_id
    ORDER BY sur.surgery_bill DESC;

#People who are neither Staff members nor Patients
SELECT p.person_id, concat(p.first_name, ' ', p.last_name) 
	FROM person p WHERE p.person_id
    NOT IN (SELECT patient.person_id FROM patient)
    AND p.person_id NOT IN (SELECT staff.person_id FROM staff);
    
#
Start TRANSACTION;
SET @appointment_ID = (SELECT COUNT(appointment_id) FROM appointment) + 1;
INSERT INTO appointment () VALUES (@appointment_ID, '2016-12-12 09:00:00', '5', '7', 'regular checkup', '50', '2016-12-12 09:30:00');
UPDATE out_house_patient SET next_checkin_date='2016-12-12 09:00:00' WHERE patient_id='5';
COMMIT;