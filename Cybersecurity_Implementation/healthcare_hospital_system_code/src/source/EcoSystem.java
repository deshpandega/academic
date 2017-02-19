/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.ArrayList;
import source.department.Department;
import source.hospital.HospitalDirectory;
import source.role.Role;
import source.role.SystemAdminRole;

/**
 *
 * @author GaurangDeshpande
 */
public class EcoSystem extends Department{
    private static EcoSystem business;
    private HospitalDirectory hospitalDirectory;

    public static EcoSystem getInstance(){
        if(business ==null){
            business = new EcoSystem();
        }
        return business;
    }
    
    private EcoSystem() {
        super(null);
        hospitalDirectory = new HospitalDirectory();
    }

    public HospitalDirectory getHospitalDirectory() {
        return hospitalDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        return true;
    }
}
