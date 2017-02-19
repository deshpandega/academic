/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.doctor;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;
import source.workQueue.LabWorkRequest;
import source.workQueue.MedicalDataAdditionWorkRequest;
import source.workQueue.SpecialMedicalWorkRequest;
import source.workQueue.WorkRequest;

/**
 *
 * @author GaurangDeshpande
 */
public class ViewSpecialRequestJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private SpecialMedicalWorkRequest requestSpecial;
    private LabWorkRequest requestLab;
    private MedicalDataAdditionWorkRequest requestDataAddition;
    private String requestType;
    /**
     * Creates new form AddNewSpecialRequestJPanel
     */
    ViewSpecialRequestJPanel(JPanel cardContainer, UserAccount account, WorkRequest request, String requestType) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        if (requestType.equals("SpecialRequest")) {
            this.requestSpecial = (SpecialMedicalWorkRequest) request;
        } 
        else if (requestType.equals("LabRequest")) {
            this.requestLab = (LabWorkRequest) request;
        }
        else if (requestType.equals("DataAddition")) {
            this.requestDataAddition = (MedicalDataAdditionWorkRequest) request;
        }
        this.requestType = requestType;

        populateRequestDetails();
    }

    private void populateRequestDetails() {
        if (requestType.equals("SpecialRequest")) {
            lblPatientID.setText(requestSpecial.getPatientInTalks().getPatientID());
            lblPatientName.setText(requestSpecial.getPatientInTalks().getPerson().getFirstName() + " " + requestSpecial.getPatientInTalks().getPerson().getLastName());
            lblGender.setText(requestSpecial.getPatientInTalks().getPerson().getGender());
            lblAge.setText(String.valueOf(requestSpecial.getPatientInTalks().getPerson().getAge()));
            lblRequestMessage.setText(requestSpecial.getMessage());
            if (requestSpecial.getRequestAssignee() == null) {
                lblAssignee.setText("Not Assigned");
            } else {
                lblAssignee.setText(requestSpecial.getRequestAssignee().getPerson().getFirstName() + " " + requestSpecial.getRequestAssignee().getPerson().getLastName());
            }
            lblRaisedOn.setText(String.valueOf(UtilFunctions.formatDate(requestSpecial.getRequestCreationDate())));
            lblStatus.setText(requestSpecial.getStatus());
            lblOutput.setText(requestSpecial.getRequestOutcome());
            lblComments.setText(requestSpecial.getComments());
        }
        else if (requestType.equals("LabRequest")) {
            lblPatientID.setText(requestLab.getPatientInTalks().getPatientID());
            lblPatientName.setText(requestLab.getPatientInTalks().getPerson().getFirstName() + " " + requestLab.getPatientInTalks().getPerson().getLastName());
            lblGender.setText(requestLab.getPatientInTalks().getPerson().getGender());
            lblAge.setText(String.valueOf(requestLab.getPatientInTalks().getPerson().getAge()));
            lblRequestMessage.setText(requestLab.getMessage());
            if (requestLab.getRequestAssignee() == null) {
                lblAssignee.setText("Not Assigned");
            } else {
                lblAssignee.setText(requestLab.getRequestAssignee().getPerson().getFirstName() + " " + requestLab.getRequestAssignee().getPerson().getLastName());
            }
            lblRaisedOn.setText(String.valueOf(UtilFunctions.formatDate(requestLab.getRequestCreationDate())));
            lblStatus.setText(requestLab.getStatus());
            lblOutput.setText(requestLab.getRequestOutcome());
            lblComments.setText(requestLab.getComments());
        }
        else if (requestType.equals("DataAddition")) {
            lblPatientID.setText(requestDataAddition.getPatientInTalks().getPatientID());
            lblPatientName.setText(requestDataAddition.getPatientInTalks().getPerson().getFirstName() + " " + requestDataAddition.getPatientInTalks().getPerson().getLastName());
            lblGender.setText(requestDataAddition.getPatientInTalks().getPerson().getGender());
            lblAge.setText(String.valueOf(requestDataAddition.getPatientInTalks().getPerson().getAge()));
            lblRequestMessage.setText(requestDataAddition.getMessage());
            if (requestDataAddition.getRequestAssignee() == null) {
                lblAssignee.setText("Not Assigned");
            } else {
                lblAssignee.setText(requestDataAddition.getRequestAssignee().getPerson().getFirstName() + " " + requestDataAddition.getRequestAssignee().getPerson().getLastName());
            }
            lblRaisedOn.setText(String.valueOf(UtilFunctions.formatDate(requestDataAddition.getRequestCreationDate())));
            lblStatus.setText(requestDataAddition.getStatus());
            lblOutput.setText(requestDataAddition.getRequestOutcome());
            lblComments.setText(requestDataAddition.getComments());
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
        jLabel5 = new javax.swing.JLabel();
        lblPatientID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblRequestMessage = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblAssignee = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblRaisedOn = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblOutput = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblComments = new javax.swing.JLabel();

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
        lblHeading.setText("View Request");

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Request Message:");

        lblRequestMessage.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Assigned To:");

        lblAssignee.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Raised On:");

        lblRaisedOn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Status:");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Outcome:");

        lblOutput.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Comments:");

        lblComments.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

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
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRequestMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblComments, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblAssignee, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRaisedOn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRequestMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAssignee, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRaisedOn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComments, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void goBack(){
        cardContainer.remove(this);
        Component[] componentArray = cardContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        if(requestType.equals("SpecialRequest")){
            RaiseSpecialMedicalRequestJPanel raiseSpecialMedicalRequestJPanel = (RaiseSpecialMedicalRequestJPanel) component;
            raiseSpecialMedicalRequestJPanel.populatePatientHistory();
        }
        else if(requestType.equals("LabRequest")){
            RaiseLabRequestJPanel raiseLabRequestJPanel = (RaiseLabRequestJPanel) component;
            raiseLabRequestJPanel.populatePatientHistory();
        }
        else if(requestType.equals("DataAddition")){
            EmergencyMedicalDataAdditionJPanel emergencyMedicalDataAdditionJPanel = (EmergencyMedicalDataAdditionJPanel) component;
            emergencyMedicalDataAdditionJPanel.populateRequestTable();
        }
        CardLayout layout = (CardLayout)cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAssignee;
    private javax.swing.JLabel lblComments;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JLabel lblRaisedOn;
    private javax.swing.JLabel lblRequestMessage;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
