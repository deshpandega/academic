/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.hospital;

import java.util.ArrayList;
import source.role.Role;

/**
 *
 * @author GaurangDeshpande
 */
public class HospitalDirectory {
    private ArrayList<Hospital> hospitalList;

    public HospitalDirectory() {
        hospitalList = new ArrayList<>();
    }

    public ArrayList<Hospital> getHospitalList() {
        return hospitalList;
    }
    
    public Hospital createAndAddHospital(String name, String branch){
        Hospital hospital = new Hospital(name, branch) {
            @Override
            public ArrayList<Role> getSupportedRole() {
                return null;
            }
        };
        hospitalList.add(hospital);
        return hospital;
    }
}