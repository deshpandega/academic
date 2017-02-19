/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.patient;

import java.text.DecimalFormat;
import java.util.Date;
import source.person.Person;

/**
 *
 * @author GaurangDeshpande
 */
public class Patient{
    private String patientID;
    private static int count=000;
    private Person person;
    private VitalSignHistory vitalSignHistory;
    private PrescriptionDirectory prescriptionHistory;
    private SurgeriesDirectory surgicalHistory;
    private ProcedureDirectory procedureDirectory;
    private VisitDirectory visitHistory;
    private TestFindingsHistory testFindingHistory;
    private Date lastVisited;
    private String comments;

    public Patient() {
        DecimalFormat format = new DecimalFormat("000");
        //patientID = "PAT"+format.format(++count);
        visitHistory = new VisitDirectory();
        vitalSignHistory = new VitalSignHistory();
        prescriptionHistory = new PrescriptionDirectory();
        surgicalHistory = new SurgeriesDirectory();
        procedureDirectory = new ProcedureDirectory();
        testFindingHistory = new TestFindingsHistory();
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPatientID() {
        return patientID;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }
    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public PrescriptionDirectory getPrescriptionHistory() {
        return prescriptionHistory;
    }
    public void setPrescriptionHistory(PrescriptionDirectory prescriptionHistory) {
        this.prescriptionHistory = prescriptionHistory;
    }

    public SurgeriesDirectory getSurgicalHistory() {
        return surgicalHistory;
    }
    public void setSurgicalHistory(SurgeriesDirectory surgicalHistory) {
        this.surgicalHistory = surgicalHistory;
    }

    public ProcedureDirectory getProcedureDirectory() {
        return procedureDirectory;
    }
    public void setProcedureDirectory(ProcedureDirectory procedureDirectory) {
        this.procedureDirectory = procedureDirectory;
    }

    public VisitDirectory getVisitHistory() {
        return visitHistory;
    }
    public void setVisitHistory(VisitDirectory visitHistory) {
        this.visitHistory = visitHistory;
    }

    public TestFindingsHistory getTestFindingHistory() {
        return testFindingHistory;
    }
    public void setTestFindingHistory(TestFindingsHistory testFindingHistory) {
        this.testFindingHistory = testFindingHistory;
    }
    
    public Date getLastVisited() {
        return lastVisited;
    }
    public void setLastVisited(Date lastVisited) {
        this.lastVisited = lastVisited;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public Person assignPerson(){
        Person person = new Person();
        person.assignAddress();
        this.setPerson(person);
        return person;
    }
    
    public String toString(){
        return patientID;
    }

    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Patient.count = count;
    }
}