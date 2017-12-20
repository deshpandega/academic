/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_1;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class AppletInputs {

    static int swarmSize = 0, numberOfIterations = 0, betaMin = 0, betaMax = 0, alphaMin = 0, alphaMax = 0, speedOfExecutionInMS = 0;

    private javax.swing.JButton btnCompute;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBetaVal;
    private javax.swing.JSlider sliderBeta;
    private javax.swing.JTextField txtIterations;
    private javax.swing.JTextField txtSpeed;
    private javax.swing.JTextField txtSwarmSize;
    
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Form");
        
        jPanel1 = new javax.swing.JPanel();
        txtSwarmSize = new javax.swing.JTextField();
        txtIterations = new javax.swing.JTextField();
        sliderBeta = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        lblBetaVal = new javax.swing.JLabel();
        txtSpeed = new javax.swing.JTextField();
        btnCompute = new javax.swing.JButton();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        txtSwarmSize.setText("Swarm Size");
        txtIterations.setText("Iterations");
        jLabel1.setText("Beta");
        lblBetaVal.setText("val");

        txtSpeed.setText("Speed");
        btnCompute.setText("Compute");
        
        btnCompute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnComputeActionPerformed(evt);
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(AppletInputs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCompute, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSwarmSize, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBetaVal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIterations, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sliderBeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSwarmSize)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBetaVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sliderBeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCompute)
                        .addGap(0, 539, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        frame.pack();
        frame.setVisible(true);
        
        
//        final String[] labels = {"Swarm Size: ", "No of Iterations: ", "beta min: ", "beta max: ", "alpha min: ", "alpha max: ", "speed in MS: "};
//        int labelsLength = labels.length;
//        final JTextField[] textField = new JTextField[labels.length];
//        //Create and populate the panel.
//        JPanel p = new JPanel(new SpringLayout());
//        for (int i = 0; i < labelsLength; i++) {
//            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
//            p.add(l);
//            textField[i] = new JTextField(10);
//            l.setLabelFor(textField[i]);
//            p.add(textField[i]);
//        }
//        JButton button = new JButton("Submit");
//        p.add(new JLabel());
//        p.add(button);
//
//       
//
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                swarmSize = Integer.parseInt(textField[0].getText());
//                numberOfIterations = Integer.parseInt(textField[1].getText());
//                betaMin = Integer.parseInt(textField[2].getText());
//                betaMax = Integer.parseInt(textField[3].getText());
//                alphaMin = Integer.parseInt(textField[4].getText());
//                alphaMax = Integer.parseInt(textField[5].getText());
//                speedOfExecutionInMS = Integer.parseInt(textField[6].getText());
//            }
//        });
//        //Create and set up the window.
//        JFrame frame = new JFrame("Form");
//        frame.setBounds(100, 100, 450, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Set up the content pane.
//        p.setOpaque(true);  //content panes must be opaque
//        frame.setContentPane(p);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
    }
    
    private void btnComputeActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {                                           
        // TODO add your handling code here:
        
        Execution pso = new Execution("PSO Simulation");
        pso.execute();
    } 
}
