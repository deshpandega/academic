/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.department;

import java.util.ArrayList;
import source.role.DoctorRole;
import source.role.LabAssistantRole;
import source.role.PatientRole;
import source.role.Role;

/**
 *
 * @author GaurangDeshpande
 */
public class AnesthesiaDepartment extends Department{

    public AnesthesiaDepartment() {
        super(DepartmentType.Anesthesia.getValue());
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DoctorRole());
        return roles;
    }
}