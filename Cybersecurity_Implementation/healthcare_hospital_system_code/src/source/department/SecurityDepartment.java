/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.department;

import java.util.ArrayList;
import source.role.Role;
import source.role.SecurityTeamRole;

/**
 *
 * @author GaurangDeshpande
 */
public class SecurityDepartment extends Department{

    public SecurityDepartment() {
        super(DepartmentType.Security.getValue());
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SecurityTeamRole());
        return roles;
    }
}