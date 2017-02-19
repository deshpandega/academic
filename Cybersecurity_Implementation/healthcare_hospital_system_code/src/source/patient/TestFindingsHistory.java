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
public class TestFindingsHistory {
    private ArrayList<TestFindings> testFindingHistory;

    public TestFindingsHistory() {
        testFindingHistory = new ArrayList<>();
    }

    public ArrayList<TestFindings> getTestFindingHistory() {
        return testFindingHistory;
    }
    
    public TestFindings addTestFindings(){
        TestFindings finding = new TestFindings();
        testFindingHistory.add(finding);
       return finding;
    }
}
