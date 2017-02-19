/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.doctor;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import source.department.Department;
import source.hospital.Hospital;
import source.patient.Patient;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;

/**
 *
 * @author GaurangDeshpande
 */
public class SpecialMedicalRequestsJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Department department;
    private Hospital hospital;
    /**
     * Creates new form ViewPatientsJPanel
     */
    SpecialMedicalRequestsJPanel(JPanel cardContainer, UserAccount account, Department department, Hospital hospital) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.department = department;
        this.hospital = hospital;
        
        lblLoggedInUser.setText(account.getEmployee().getPerson().getLastName()+", "+account.getEmployee().getPerson().getFirstName());
        
        populatePatientsTable();
    }
    
    public void populatePatientsTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblPatients.getModel();
        dtm.setRowCount(0);
        for(Patient patient:account.getEmployee().getPatientDirectory().getPatientDirectory()){
            Object row[] = new Object[4];
            row[0] = patient;
            row[1] = patient.getPerson().getFirstName()+" "+patient.getPerson().getLastName();
            row[2] = UtilFunctions.formatDate(patient.getLastVisited());
            row[3] = patient.getComments();
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
        lblHeading = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        btnRaiseSpecialRequest = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblHeading.setText("Special Medical Requests");

        btnBack.setBackground(new java.awt.Color(51, 51, 51));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Last Visited", "Reason for last visit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPatients);

        btnRaiseSpecialRequest.setBackground(new java.awt.Color(51, 51, 51));
        btnRaiseSpecialRequest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRaiseSpecialRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRaiseSpecialRequest.setText("Raise Special Medical Request");
        btnRaiseSpecialRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaiseSpecialRequestActionPerformed(evt);
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
                            .addComponent(jScrollPane1)
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRaiseSpecialRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRaiseSpecialRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRaiseSpecialRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaiseSpecialRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatients.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a patient", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        else{
            Patient patient = (Patient) tblPatients.getValueAt(selectedRow, 0);
            RaiseSpecialMedicalRequestJPanel raiseSpecialMedicalRequestJPanel = new RaiseSpecialMedicalRequestJPanel(cardContainer, account, hospital, patient);
            cardContainer.add("raiseSpecialMedicalRequestJPanel", raiseSpecialMedicalRequestJPanel);
            CardLayout layout = (CardLayout) cardContainer.getLayout();
            layout.next(cardContainer);
        }
    }//GEN-LAST:event_btnRaiseSpecialRequestActionPerformed

     private void goBack(){
        cardContainer.remove(this);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRaiseSpecialRequest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JTable tblPatients;
    // End of variables declaration//GEN-END:variables
}
