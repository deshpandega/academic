/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.role;

import javax.swing.JPanel;
import source.EcoSystem;
import source.department.Department;
import source.hospital.Hospital;
import source.userAccount.UserAccount;

/**
 *
 * @author GaurangDeshpande
 */
public abstract class Role {
    public enum RoleType{
        HospitalAdmin("Hospital Admin"),
        Doctor("Doctor"),
        Nurse("Nurse"),
        LabAssistant("Lab Assistant"),
        ForntDeskAttendant("Front Desk Attendant"),
        Patient("Patient");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }
        
        public String getValue(){
            return value;
        }
        
        @Override
        public String toString() {
            return this.value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel cardContainer, UserAccount account, Department department, Hospital hospital, EcoSystem bisuness);
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}