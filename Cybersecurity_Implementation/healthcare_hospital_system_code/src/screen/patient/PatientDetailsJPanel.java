/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.patient;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import source.department.Department;
import source.hospital.Hospital;
import source.patient.Prescription;
import source.patient.Procedure;
import source.patient.Surgery;
import source.patient.Visit;
import source.patient.VitalSigns;
import source.userAccount.UserAccount;

/**
 *
 * @author GaurangDeshpande
 */
public class PatientDetailsJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Hospital hospital;
    private Department department;
    
    /**
     * Creates new form PatientDetailsJPanel
     */
    PatientDetailsJPanel(JPanel cardContainer, UserAccount account, Department department, Hospital hospital) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.hospital = hospital;
        this.department = department;
        
        lblLoggedInUser.setText(account.getPatient().getPerson().getLastName()+", "+account.getPatient().getPerson().getFirstName());
        
        populatePatientHistory();
    }

    private void populatePatientHistory(){
        lblPatientID.setText(account.getPatient().getPatientID());
        lblPatientName.setText(account.getPatient().getPerson().getFirstName());
        lblAge.setText(String.valueOf(account.getPatient().getPerson().getAge()));
        lblGender.setText(account.getPatient().getPerson().getGender());
        
        populateTable();
    }
    
    public void populateTable(){
        ArrayList<Visit> visitHistory = new ArrayList<Visit>();
        Visit visit = null;
        for(VitalSigns vitalSigns:account.getPatient().getVitalSignHistory().getVitalSignHistory()){
            visit = new Visit();
            visit.setPurpose(vitalSigns.getPurpose());
            visit.setVisitDate(vitalSigns.getVisitDate());
            visitHistory.add(visit);
        }
        for(Prescription prescription: account.getPatient().getPrescriptionHistory().getPrescriptionHistory()){
            visit = new Visit();
            visit.setPurpose(prescription.getPurpose());
            visit.setVisitDate(prescription.getVisitDate());
            visitHistory.add(visit);
        }
        for(Procedure procedure: account.getPatient().getProcedureDirectory().getProcedureList()){
            visit = new Visit();
            visit.setPurpose(procedure.getPurpose());
            visit.setVisitDate(procedure.getVisitDate());
            visitHistory.add(visit);
        }
        for(Surgery surgery: account.getPatient().getSurgicalHistory().getSurgeryDirectory()){
            visit = new Visit();
            visit.setPurpose(surgery.getPurpose());
            visit.setVisitDate(surgery.getVisitDate());
            visitHistory.add(visit);
        }
        
        Collections.sort(visitHistory, (Visit visit1, Visit visit2) -> visit1.getVisitDate().compareTo(visit2.getVisitDate()));
        Collections.reverse(visitHistory);
        
        DefaultTableModel dtm = (DefaultTableModel)tblPatientHistory.getModel();
        dtm.setRowCount(0);
        for(Visit v:visitHistory){
            Object row[] = new Object[2];
            row[0] = v.getVisitDate();
            row[1] = v.getPurpose();
            dtm.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoggedInUser = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        btnViewVitalSigns = new javax.swing.JButton();
        btnViewPrescriptions = new javax.swing.JButton();
        btnViewSurgeries = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblPatientID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientHistory = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnViewProcedures = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

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

        btnViewVitalSigns.setBackground(new java.awt.Color(51, 51, 51));
        btnViewVitalSigns.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewVitalSigns.setForeground(new java.awt.Color(255, 255, 255));
        btnViewVitalSigns.setText("View Past Visits");
        btnViewVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVitalSignsActionPerformed(evt);
            }
        });

        btnViewPrescriptions.setBackground(new java.awt.Color(51, 51, 51));
        btnViewPrescriptions.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewPrescriptions.setForeground(new java.awt.Color(255, 255, 255));
        btnViewPrescriptions.setText("View Prescription");
        btnViewPrescriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPrescriptionsActionPerformed(evt);
            }
        });

        btnViewSurgeries.setBackground(new java.awt.Color(51, 51, 51));
        btnViewSurgeries.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewSurgeries.setForeground(new java.awt.Color(255, 255, 255));
        btnViewSurgeries.setText("View Surgeries");
        btnViewSurgeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSurgeriesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Patient ID:");

        lblPatientID.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Patient Name:");

        lblPatientName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Gender:");

        lblGender.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Age:");

        lblAge.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        tblPatientHistory.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblPatientHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last Visit Date", "Last Visit Comments"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatientHistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPatientHistory);
        if (tblPatientHistory.getColumnModel().getColumnCount() > 0) {
            tblPatientHistory.getColumnModel().getColumn(0).setResizable(false);
            tblPatientHistory.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblPatientHistory.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Recent Visits");

        btnViewProcedures.setBackground(new java.awt.Color(51, 51, 51));
        btnViewProcedures.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewProcedures.setForeground(new java.awt.Color(255, 255, 255));
        btnViewProcedures.setText("View Procedures");
        btnViewProcedures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProceduresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnViewVitalSigns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewPrescriptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewSurgeries, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(btnViewProcedures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPatientName, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewVitalSigns, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewPrescriptions, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewSurgeries, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewProcedures, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVitalSignsActionPerformed
        // TODO add your handling code here:
        ViewPastMedicalRecordPatientJPanel viewPastMedicalRecordPatientJPanel = new ViewPastMedicalRecordPatientJPanel(cardContainer, account, account.getPatient(), hospital, "VitalSign");
        cardContainer.add("viewPastMedicalRecordPatientJPanel",viewPastMedicalRecordPatientJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnViewVitalSignsActionPerformed

    private void btnViewPrescriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPrescriptionsActionPerformed
        // TODO add your handling code here:
        ViewPastMedicalRecordPatientJPanel viewPastMedicalRecordPatientJPanel = new ViewPastMedicalRecordPatientJPanel(cardContainer, account, account.getPatient(), hospital, "Prescription");
        cardContainer.add("viewPastMedicalRecordPatientJPanel",viewPastMedicalRecordPatientJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnViewPrescriptionsActionPerformed

    private void btnViewSurgeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSurgeriesActionPerformed
        // TODO add your handling code here:
        ViewPastMedicalRecordPatientJPanel viewPastMedicalRecordPatientJPanel = new ViewPastMedicalRecordPatientJPanel(cardContainer, account, account.getPatient(), hospital, "Surgery");
        cardContainer.add("viewPastMedicalRecordPatientJPanel",viewPastMedicalRecordPatientJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnViewSurgeriesActionPerformed

    private void btnViewProceduresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProceduresActionPerformed
        // TODO add your handling code here:
        ViewPastMedicalRecordPatientJPanel viewPastMedicalRecordPatientJPanel = new ViewPastMedicalRecordPatientJPanel(cardContainer, account, account.getPatient(), hospital, "Procedures");
        cardContainer.add("viewPastMedicalRecordPatientJPanel",viewPastMedicalRecordPatientJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnViewProceduresActionPerformed

    private void goBack(){
        cardContainer.remove(this);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewPrescriptions;
    private javax.swing.JButton btnViewProcedures;
    private javax.swing.JButton btnViewSurgeries;
    private javax.swing.JButton btnViewVitalSigns;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JTable tblPatientHistory;
    // End of variables declaration//GEN-END:variables
}
