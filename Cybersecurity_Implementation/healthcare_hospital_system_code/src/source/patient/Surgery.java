/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.patient;

import java.util.ArrayList;
import java.util.Date;
import source.employee.Employee;

/**
 *
 * @author GaurangDeshpande
 */
public class Surgery extends Visit{
    private Date surgeryTime;
    private String surgeryType;
    private String surgeryDescription;
    private String surgeryComplications;
    private String surgeryOutcome;
    private Employee performedBy;
    private ArrayList<Employee> surgeryAssisstedBy;

    public Date getSurgeryTime() {
        return surgeryTime;
    }
    public void setSurgeryTime(Date surgeryTime) {
        this.surgeryTime = surgeryTime;
    }

    public String getSurgeryType() {
        return surgeryType;
    }
    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public String getSurgeryDescription() {
        return surgeryDescription;
    }
    public void setSurgeryDescription(String surgeryDescription) {
        this.surgeryDescription = surgeryDescription;
    }

    public String getSurgeryComplications() {
        return surgeryComplications;
    }
    public void setSurgeryComplications(String surgeryComplications) {
        this.surgeryComplications = surgeryComplications;
    }

    public String getSurgeryOutcome() {
        return surgeryOutcome;
    }
    public void setSurgeryOutcome(String surgeryOutcome) {
        this.surgeryOutcome = surgeryOutcome;
    }

    public Employee getPerformedBy() {
        return performedBy;
    }
    public void setPerformedBy(Employee performedBy) {
        this.performedBy = performedBy;
    }
    
    public ArrayList<Employee> getSurgeryAssisstedBy() {
        return surgeryAssisstedBy;
    }
    public void setSurgeryAssisstedBy(ArrayList<Employee> surgeryAssisstedBy) {
        this.surgeryAssisstedBy = surgeryAssisstedBy;
    }
}