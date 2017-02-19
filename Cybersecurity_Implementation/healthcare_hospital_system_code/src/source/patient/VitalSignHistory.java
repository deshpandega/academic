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
public class VitalSignHistory {
    private ArrayList<VitalSigns> vitalSignHistory;

    public VitalSignHistory() {
        vitalSignHistory = new ArrayList<>();
    }

    public ArrayList<VitalSigns> getVitalSignHistory() {
        return vitalSignHistory;
    }
    
    public VitalSigns addVitalSign(){
        VitalSigns vitalSign = new VitalSigns();
        vitalSignHistory.add(vitalSign);
        return vitalSign;
    }
    
    public void deleteVitalSign(VitalSigns deleteVS){
        vitalSignHistory.remove(deleteVS);
    }
}
