/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.workQueue;

import source.patient.Patient;

/**
 *
 * @author GaurangDeshpande
 */
public class SpecialMedicalWorkRequest extends WorkRequest{
    private String comments;
    private Patient patientInTalks;

    public SpecialMedicalWorkRequest() {
        patientInTalks = new Patient();
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
}