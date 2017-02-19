/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.employee;

import java.text.DecimalFormat;
import source.patient.PatientDirectory;
import source.person.Person;

/**
 *
 * @author GaurangDeshpande
 */
public class Employee {
    private Person person;
    private String employeeId;
    private PatientDirectory patientDirectory;
    private static int count=000;

    public Employee() {
        DecimalFormat format = new DecimalFormat("000");
        //employeeId="EMPID"+format.format(++count);
        patientDirectory = new PatientDirectory();
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }
    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    
    public Person assignPerson(){
        Person person = new Person();
        person.assignAddress();
        this.setPerson(person);
        return person;
    }
    
    public String toString(){
        return person.getFirstName()+" "+person.getLastName();
    }
}