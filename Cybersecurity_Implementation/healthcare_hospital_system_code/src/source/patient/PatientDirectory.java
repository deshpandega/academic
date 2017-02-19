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
public class PatientDirectory {
    private ArrayList<Patient> patientDirectory;

    public PatientDirectory() {
        patientDirectory = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientDirectory() {
        return patientDirectory;
    }
    
    public void createPatient(Patient patient){
        patientDirectory.add(patient);
    }
    
    public void deletePatient(Patient delPatient){
        patientDirectory.remove(delPatient);
    }
    
    public Patient searchPatientByID(String patientID){
        for(Patient patient:patientDirectory){
            if(patient.getPatientID().equalsIgnoreCase(patientID)){
                return patient;
            }
        }
        return null;
    }
    
    public Patient searchPatientByName(String patientName){
        for(Patient patient:patientDirectory){
            if(patient.getPerson().getFirstName().equalsIgnoreCase(patientName)){
                return patient;
            }
        }
        
        for(Patient patient:patientDirectory){
            if(patient.getPerson().getLastName().equalsIgnoreCase(patientName)){
                return patient;
            }
        }
        
        for(Patient patient:patientDirectory){
            if((patient.getPerson().getFirstName()+" "+patient.getPerson().getLastName()).equalsIgnoreCase(patientName)){
                return patient;
            }
        }
        
        return null;
    }
    
    public Patient searchPatientBySSN(String ssn){
        for(Patient patient:patientDirectory){
            if(patient.getPerson().getSocialSecurityNumber().equalsIgnoreCase(ssn)){
                return patient;
            }
        }
        return null;
    }
    
    public Patient searchPatientByPhoneNumber(long phoneNumber){
        for(Patient patient:patientDirectory){
            if(patient.getPerson().getPhoneNumber()==phoneNumber){
                return patient;
            }
        }
        return null;
    }
}
