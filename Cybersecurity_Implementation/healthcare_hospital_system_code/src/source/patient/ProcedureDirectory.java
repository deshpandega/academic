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
public class ProcedureDirectory {
    private ArrayList<Procedure> procedureList;

    public ProcedureDirectory() {
        procedureList = new ArrayList<>();
    }

    public ArrayList<Procedure> getProcedureList() {
        return procedureList;
    }
    
    public Procedure carryOutNewProcedure(){
        Procedure procedure = new Procedure();
        procedureList.add(procedure);
        return procedure;
    }
    
    public void deleteProcedure(Procedure procedure){
        procedureList.remove(procedure);
    }
}