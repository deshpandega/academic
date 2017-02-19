/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.util;

import java.text.DecimalFormat;

/**
 *
 * @author GaurangDeshpande
 */
public class StaticVariableCounterCollection {
    private int patientCount;
    private int employeeCount;

    public StaticVariableCounterCollection() {
        patientCount = 0;
        employeeCount = 0;
    }

    public int getPatientCount() {
        return patientCount;
    }
    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }   
    
    public String retriveEmployeeID(){
        DecimalFormat format = new DecimalFormat("000");
        String employeeID = "EMP"+format.format(++employeeCount);
        return employeeID;
    }
    
    public String retrivePatientID(){
        DecimalFormat format = new DecimalFormat("000");
        String patientID = "PAT"+format.format(++patientCount);
        return patientID;
    }
}