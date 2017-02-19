/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.patient;

import java.util.ArrayList;

/**
 *
 * @author GaurangDeshpande
 */
public class SurgeriesDirectory {
    private ArrayList<Surgery> surgeryDirectory;

    public SurgeriesDirectory() {
        surgeryDirectory = new ArrayList<>();
    }

    public ArrayList<Surgery> getSurgeryDirectory() {
        return surgeryDirectory;
    }
    
    public Surgery performNewSurgery(){
        Surgery surgery = new Surgery();
        surgeryDirectory.add(surgery);
        return surgery;
    }
    
    public void deleteSurgery(Surgery surgery){
        surgeryDirectory.remove(surgery);
    }
}
