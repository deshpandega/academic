/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_1;

import java.io.FileNotFoundException;

/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class AlgoProjectMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new AppletInputs().createAndShowGUI();
//            }
//        });
        
        Execution pso = new Execution("PSO Simulation");
        pso.execute();
    }
    
}
