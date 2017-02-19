/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.patient;

import java.util.ArrayList;

/**
 *
 * @author GaurangDeshpande
 */
public class PrescriptionDirectory {
    private ArrayList<Prescription> prescriptionHistory;

    public PrescriptionDirectory() {
        prescriptionHistory = new ArrayList<>();
    }

    public ArrayList<Prescription> getPrescriptionHistory() {
        return prescriptionHistory;
    }
    
    public Prescription prescribeMedicine(){
        Prescription prescription = new Prescription();
        prescriptionHistory.add(prescription);
        return prescription;
    }
    
    public Prescription editPrescription(String medicineName){
        for(Prescription medic: prescriptionHistory){
            if(medic.getMedicineName().equalsIgnoreCase(medicineName)){
                return medic;
            }
        }
        return null;
    }
    
    public void deletePrescription(Prescription prescription){
        prescriptionHistory.remove(prescription);
    }
}
