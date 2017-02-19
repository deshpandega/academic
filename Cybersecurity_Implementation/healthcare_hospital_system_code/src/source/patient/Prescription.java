/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.patient;

import java.util.Date;

/**
 *
 * @author GaurangDeshpande
 */
public class Prescription extends Visit{
    private String medicineName;
    private String medicineID;
    private Date prescribedOn;
    private Date prescribedTill;
    private int dailyDosage;
    private String prescriptionDescription;

    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineID() {
        return medicineID;
    }
    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public Date getPrescribedOn() {
        return prescribedOn;
    }
    public void setPrescribedOn(Date prescribedOn) {
        this.prescribedOn = prescribedOn;
    }

    public Date getPrescribedTill() {
        return prescribedTill;
    }
    public void setPrescribedTill(Date prescribedTill) {
        this.prescribedTill = prescribedTill;
    }

    public int getDailyDosage() {
        return dailyDosage;
    }
    public void setDailyDosage(int dailyDosage) {
        this.dailyDosage = dailyDosage;
    }

    public String getPrescriptionDescription() {
        return prescriptionDescription;
    }
    public void setPrescriptionDescription(String prescriptionDescription) {
        this.prescriptionDescription = prescriptionDescription;
    }
}