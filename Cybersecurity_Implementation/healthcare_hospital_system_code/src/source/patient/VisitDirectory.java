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
public class VisitDirectory {
    private ArrayList<Visit> visitHistory;

    public VisitDirectory() {
        visitHistory = new ArrayList<>();
    }

    public ArrayList<Visit> getVisitHistory() {
        return visitHistory;
    }
    
    public Visit addVisit(){
        Visit visit = new Visit();
        visitHistory.add(visit);
        return visit;
    }
}
