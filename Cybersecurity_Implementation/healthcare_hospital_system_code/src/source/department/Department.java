/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.department;

import java.util.ArrayList;
import source.employee.EmployeeDirectory;
import source.patient.PatientDirectory;
import source.role.Role;
import source.userAccount.UserAccountDirectory;
import source.util.UtilFunctions;
import source.workQueue.WorkQueue;

/**
 *
 * @author GaurangDeshpande
 */
public abstract class Department {
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private PatientDirectory patientDirectory;
    private UserAccountDirectory userAccountDirectory;
    private String departmentID;
//    private static int count = 0;

    public enum DepartmentType{
        Admission("Admission Department"),
        Anesthesia("Anesthesia Department"),
        Emergency("Emergency Department"),
        Gynecology("Gynecology Department"),
        Laboratory("Laboratory Department"),
        Neurology("Neurology Department"),
        Nursing("Nursing Department"),
        Pediatrics("Pediatrics Department"),
        Security("Security Department"),
        Surgery("Surgery Department"),
        XRay("XRay Department");
        
        private String value;
        
        private DepartmentType(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }
    
    public Department(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        patientDirectory = new PatientDirectory();
        userAccountDirectory = new UserAccountDirectory();
        departmentID=UtilFunctions.assignDepartmentID(name);
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }
    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }
    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public String getDepartmentID() {
        return departmentID;
    }
    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return this.name;
    }
}