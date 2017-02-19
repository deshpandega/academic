/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.workQueue;

import source.patient.Patient;
import source.patient.Prescription;
import source.patient.Procedure;
import source.patient.Surgery;
import source.patient.VitalSigns;

/**
 *
 * @author GaurangDeshpande
 */
public class MedicalDataAdditionWorkRequest extends WorkRequest{
    private String comments;
    private Patient patientInTalks;
    private Surgery surgery;
    private Procedure procedure;
    private Prescription prescription;
    private VitalSigns vitalSigns;

    public MedicalDataAdditionWorkRequest() {
        patientInTalks = new Patient();
        surgery = new Surgery();
        procedure = new Procedure();
        prescription = new Prescription();
        vitalSigns = new VitalSigns();
    }

    public Patient getPatientInTalks() {
        return patientInTalks;
    }
    public void setPatientInTalks(Patient patientInTalks) {
        this.patientInTalks = patientInTalks;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public Surgery getSurgery() {
        return surgery;
    }
    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public Procedure getProcedure() {
        return procedure;
    }
    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public Prescription getPrescription() {
        return prescription;
    }
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }
    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
}