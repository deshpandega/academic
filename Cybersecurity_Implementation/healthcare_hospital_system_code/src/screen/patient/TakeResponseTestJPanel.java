/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.patient;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.apache.log4j.Logger;
import source.patient.Patient;
import source.patient.TestFindings;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;

/**
 *
 * @author GaurangDeshpande
 */
public class TakeResponseTestJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private static int countdown = 0;
    private Timer timer;
    private Patient patient;
    private DecimalFormat format;
    private static int responseCount = 0;
    private String testType;
    private static Logger log;
    
    //private static 
    /**
     * Creates new form TakeTestJPanel
     */
    TakeResponseTestJPanel(JPanel cardContainer, UserAccount account) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.patient=account.getPatient();
        lblLoggedInUser.setText(account.getPatient().getPerson().getLastName()+", "+account.getPatient().getPerson().getFirstName());
        log = Logger.getLogger(TakeResponseTestJPanel.class);
        preparation();
        //initialSetup();
    }
    
    private void preparation(){
        btnBefore.setEnabled(true);
        btnAfter.setEnabled(true);
        
        countdown = 0;
        btnStartTest.setEnabled(false);
        btnTap1.setEnabled(false);
        btnTap2.setEnabled(false);
        btnTap3.setEnabled(false);
        btnTap4.setEnabled(false);
        btnTap5.setEnabled(false);
        btnTap6.setEnabled(false);
        btnTap7.setEnabled(false);
        btnTap8.setEnabled(false);
        btnTap9.setEnabled(false);
        
        format = new DecimalFormat("00");
        lblTimer.setText("00:"+format.format(countdown));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        lblLoggedInUser = new javax.swing.JLabel();
        btnStartTest = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();
        btnTap1 = new javax.swing.JButton();
        btnTap2 = new javax.swing.JButton();
        btnBefore = new javax.swing.JButton();
        btnAfter = new javax.swing.JButton();
        btnTap3 = new javax.swing.JButton();
        btnTap4 = new javax.swing.JButton();
        btnTap5 = new javax.swing.JButton();
        btnTap6 = new javax.swing.JButton();
        btnTap7 = new javax.swing.JButton();
        btnTap8 = new javax.swing.JButton();
        btnTap9 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setBackground(new java.awt.Color(51, 51, 51));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblHeading.setText("Patient Details");

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        btnStartTest.setBackground(new java.awt.Color(51, 51, 51));
        btnStartTest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnStartTest.setForeground(new java.awt.Color(255, 255, 255));
        btnStartTest.setText("Begin Test");
        btnStartTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTestActionPerformed(evt);
            }
        });

        lblTimer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("jLabel1");

        btnTap1.setBackground(new java.awt.Color(51, 51, 51));
        btnTap1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap1.setForeground(new java.awt.Color(255, 255, 255));
        btnTap1.setText("Tap Here!");
        btnTap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap1ActionPerformed(evt);
            }
        });

        btnTap2.setBackground(new java.awt.Color(51, 51, 51));
        btnTap2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap2.setForeground(new java.awt.Color(255, 255, 255));
        btnTap2.setText("Tap Here!");
        btnTap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap2ActionPerformed(evt);
            }
        });

        btnBefore.setBackground(new java.awt.Color(51, 51, 51));
        btnBefore.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBefore.setForeground(new java.awt.Color(255, 255, 255));
        btnBefore.setText("Before");
        btnBefore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeforeActionPerformed(evt);
            }
        });

        btnAfter.setBackground(new java.awt.Color(51, 51, 51));
        btnAfter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAfter.setForeground(new java.awt.Color(255, 255, 255));
        btnAfter.setText("After");
        btnAfter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfterActionPerformed(evt);
            }
        });

        btnTap3.setBackground(new java.awt.Color(51, 51, 51));
        btnTap3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap3.setForeground(new java.awt.Color(255, 255, 255));
        btnTap3.setText("Tap Here!");
        btnTap3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap3ActionPerformed(evt);
            }
        });

        btnTap4.setBackground(new java.awt.Color(51, 51, 51));
        btnTap4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap4.setForeground(new java.awt.Color(255, 255, 255));
        btnTap4.setText("Tap Here!");
        btnTap4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap4ActionPerformed(evt);
            }
        });

        btnTap5.setBackground(new java.awt.Color(51, 51, 51));
        btnTap5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap5.setForeground(new java.awt.Color(255, 255, 255));
        btnTap5.setText("Tap Here!");
        btnTap5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap5ActionPerformed(evt);
            }
        });

        btnTap6.setBackground(new java.awt.Color(51, 51, 51));
        btnTap6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap6.setForeground(new java.awt.Color(255, 255, 255));
        btnTap6.setText("Tap Here!");
        btnTap6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap6ActionPerformed(evt);
            }
        });

        btnTap7.setBackground(new java.awt.Color(51, 51, 51));
        btnTap7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap7.setForeground(new java.awt.Color(255, 255, 255));
        btnTap7.setText("Tap Here!");
        btnTap7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap7ActionPerformed(evt);
            }
        });

        btnTap8.setBackground(new java.awt.Color(51, 51, 51));
        btnTap8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap8.setForeground(new java.awt.Color(255, 255, 255));
        btnTap8.setText("Tap Here!");
        btnTap8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap8ActionPerformed(evt);
            }
        });

        btnTap9.setBackground(new java.awt.Color(51, 51, 51));
        btnTap9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTap9.setForeground(new java.awt.Color(255, 255, 255));
        btnTap9.setText("Tap Here!");
        btnTap9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTap9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTap1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(btnTap2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnTap3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnStartTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBefore, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAfter, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTap4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(btnTap5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnTap6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnTap7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(btnTap8, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnTap9, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 95, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAfter, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBefore, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartTest, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTap1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTap2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTap3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTap4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTap5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTap6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTap7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTap8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTap9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnStartTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTestActionPerformed
        // TODO add your handling code here:
        enableOneButton();
        log.info(UtilFunctions.encrypt("RESP_TEST : "+account.getPatient().getPerson().getFirstName()+" "+account.getPatient().getPerson().getLastName()));
        
        if(countdown!=0){
            countdown=0;
            lblTimer.setText("00:"+String.valueOf(format.format(countdown)));
        }
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdown++;
                lblTimer.setText("00:"+String.valueOf(format.format(countdown)));
                if(countdown>=10){
                    timer.stop();
                    System.out.println("---------Test Stopped--------");
                    btnTap1.setEnabled(false);
                    btnTap2.setEnabled(false);
                    btnTap3.setEnabled(false);
                    btnTap4.setEnabled(false);
                    btnTap5.setEnabled(false);
                    btnTap6.setEnabled(false);
                    btnTap7.setEnabled(false);
                    btnTap8.setEnabled(false);
                    btnTap9.setEnabled(false);
                    btnStartTest.setEnabled(false);
                    btnBefore.setEnabled(true);
                    btnAfter.setEnabled(true);
                    
                    System.out.println("Number of taps in test--->"+responseCount);
                    if (testType.equalsIgnoreCase("Before")) {
                        TestFindings finding = patient.getTestFindingHistory().addTestFindings();
                        finding.setAverageResponseTimeBefore(responseCount);
                        finding.setTimeStamp(new Date());
                    } else if (testType.equalsIgnoreCase("After")) {
                        TestFindings finding = patient.getTestFindingHistory().addTestFindings();
                        finding.setAverageResponseTimeAfter(responseCount);
                        finding.setTimeStamp(new Date());
                    }
                    responseCount=0;
                }
            }
        };
        
        timer = new Timer(1000, listener);
        timer.start();
        System.out.println("---------Test Started---------");
    }//GEN-LAST:event_btnStartTestActionPerformed

    private void enableOneButton(){
        Random rand = new Random();
        int value = rand.nextInt(9)+1; 
        if (value == 1) {
            btnTap1.setEnabled(true);
            btnTap2.setEnabled(false);
            btnTap3.setEnabled(false);
            btnTap4.setEnabled(false);
            btnTap5.setEnabled(false);
            btnTap6.setEnabled(false);
            btnTap7.setEnabled(false);
            btnTap8.setEnabled(false);
            btnTap9.setEnabled(false);
        }
        else if(value == 2) {
            btnTap1.setEnabled(false);
            btnTap2.setEnabled(true);
            btnTap3.setEnabled(false);
            btnTap4.setEnabled(false);
            btnTap5.setEnabled(false);
            btnTap6.setEnabled(false);
            btnTap7.setEnabled(false);
            btnTap8.setEnabled(false);
            btnTap9.setEnabled(false);
        }
        else if(value == 3) {
            btnTap1.setEnabled(false);
            btnTap2.setEnabled(false);
            btnTap3.setEnabled(true);
            btnTap4.setEnabled(false);
            btnTap5.setEnabled(false);
            btnTap6.setEnabled(false);
            btnTap7.setEnabled(false);
            btnTap8.setEnabled(false);
            btnTap9.setEnabled(false);
        }
        else if(value == 4) {
            btnTap1.setEnabled(false);
            btnTap2.setEnabled(false);
            btnTap3.setEnabled(false);
            btnTap4.setEnabled(true);
            btnTap5.setEnabled(false);
            btnTap6.setEnabled(false);
            btnTap7.setEnabled(false);
            btnTap8.setEnabled(false);
            btnTap9.setEnabled(false);
        }
        else if(value == 5) {
            btnTap1.setEnabled(false);
            btnTap2.setEnabled(false);
            btnTap3.setEnabled(false);
            btnTap4.setEnabled(false);
            btnTap5.setEnabled(true);
            btnTap6.setEnabled(false);
            btnTap7.setEnabled(false);
            btnTap8.setEnabled(false);
            btnTap9.setEnabled(false);
        }
        else if(value == 6) {
            btnTap1.setEnabled(false);
            btnTap2.setEnabled(false);
            btnTap3.setEnabled(false);
            btnTap4.setEnabled(false);
            btnTap5.setEnabled(false);
            btnTap6.setEnabled(true);
            btnTap7.setEnabled(false);
            btnTap8.setEnabled(false);
            btnTap9.setEnabled(false);
        }
        else if(value == 7) {
            btnTap1.setEnabled(false);
            btnTap2.setEnabled(false);
            btnTap3.setEnabled(false);
            btnTap4.setEnabled(false);
            btnTap5.setEnabled(false);
            btnTap6.setEnabled(false);
            btnTap7.setEnabled(true);
            btnTap8.setEnabled(false);
            btnTap9.setEnabled(false);
        }
        else if(value == 8) {
            btnTap1.setEnabled(false);
            btnTap2.setEnabled(false);
            btnTap3.setEnabled(false);
            btnTap4.setEnabled(false);
            btnTap5.setEnabled(false);
            btnTap6.setEnabled(false);
            btnTap7.setEnabled(false);
            btnTap8.setEnabled(true);
            btnTap9.setEnabled(false);
        }
        else if(value == 9) {
            btnTap1.setEnabled(false);
            btnTap2.setEnabled(false);
            btnTap3.setEnabled(false);
            btnTap4.setEnabled(false);
            btnTap5.setEnabled(false);
            btnTap6.setEnabled(false);
            btnTap7.setEnabled(false);
            btnTap8.setEnabled(false);
            btnTap9.setEnabled(true);
        }
    }
    
    private void btnTap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap1ActionPerformed
        // TODO add your handling code here:
        responseCount++;
        enableOneButton();
    }//GEN-LAST:event_btnTap1ActionPerformed

    private void btnTap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap2ActionPerformed
        // TODO add your handling code here:
        responseCount++;
        enableOneButton();
    }//GEN-LAST:event_btnTap2ActionPerformed

    private void btnBeforeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeforeActionPerformed
        // TODO add your handling code here:
        btnAfter.setEnabled(false);
        btnStartTest.setEnabled(true);
        btnTap1.setEnabled(false);
        btnTap2.setEnabled(false);
        btnTap3.setEnabled(false);
        btnTap4.setEnabled(false);
        btnTap5.setEnabled(false);
        btnTap6.setEnabled(false);
        btnTap7.setEnabled(false);
        btnTap8.setEnabled(false);
        btnTap9.setEnabled(false);

        format = new DecimalFormat("00");
        lblTimer.setText("00:"+format.format(countdown));
        
        testType="Before";
        
        if(countdown!=0){
            countdown=0;
            lblTimer.setText("00:"+String.valueOf(format.format(countdown)));
        }
    }//GEN-LAST:event_btnBeforeActionPerformed

    private void btnAfterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfterActionPerformed
        // TODO add your handling code here:
        btnBefore.setEnabled(false);
        btnStartTest.setEnabled(true);
        btnTap1.setEnabled(false);
        btnTap2.setEnabled(false);
        btnTap3.setEnabled(false);
        btnTap4.setEnabled(false);
        btnTap5.setEnabled(false);
        btnTap6.setEnabled(false);
        btnTap7.setEnabled(false);
        btnTap8.setEnabled(false);
        btnTap9.setEnabled(false);

        format = new DecimalFormat("00");
        lblTimer.setText("00:"+format.format(countdown));
        
        testType="After";
        
        if(countdown!=0){
            countdown=0;
            lblTimer.setText("00:"+String.valueOf(format.format(countdown)));
        }
    }//GEN-LAST:event_btnAfterActionPerformed

    private void btnTap3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap3ActionPerformed
        // TODO add your handling code here:
        responseCount++;
        enableOneButton();
    }//GEN-LAST:event_btnTap3ActionPerformed

    private void btnTap4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap4ActionPerformed
        // TODO add your handling code here:
        responseCount++;
        enableOneButton();
    }//GEN-LAST:event_btnTap4ActionPerformed

    private void btnTap5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap5ActionPerformed
        // TODO add your handling code here:
        responseCount++;
        enableOneButton();
    }//GEN-LAST:event_btnTap5ActionPerformed

    private void btnTap6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap6ActionPerformed
        // TODO add your handling code here:
        responseCount++;
        enableOneButton();
    }//GEN-LAST:event_btnTap6ActionPerformed

    private void btnTap7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap7ActionPerformed
        // TODO add your handling code hereresponseCount++;
        enableOneButton();
        
    }//GEN-LAST:event_btnTap7ActionPerformed

    private void btnTap8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap8ActionPerformed
        // TODO add your handling code here:
        responseCount++;
        enableOneButton();
    }//GEN-LAST:event_btnTap8ActionPerformed

    private void btnTap9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTap9ActionPerformed
        // TODO add your handling code here:
        responseCount++;
        enableOneButton();
    }//GEN-LAST:event_btnTap9ActionPerformed

    private void goBack(){
        cardContainer.remove(this);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfter;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBefore;
    private javax.swing.JButton btnStartTest;
    private javax.swing.JButton btnTap1;
    private javax.swing.JButton btnTap2;
    private javax.swing.JButton btnTap3;
    private javax.swing.JButton btnTap4;
    private javax.swing.JButton btnTap5;
    private javax.swing.JButton btnTap6;
    private javax.swing.JButton btnTap7;
    private javax.swing.JButton btnTap8;
    private javax.swing.JButton btnTap9;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JLabel lblTimer;
    // End of variables declaration//GEN-END:variables
}