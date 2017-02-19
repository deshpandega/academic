/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.securityTeam;

import java.awt.CardLayout;
import javax.swing.JPanel;
import source.EcoSystem;
import source.department.Department;
import source.department.SecurityDepartment;
import source.hospital.Hospital;
import source.userAccount.UserAccount;

/**
 *
 * @author GaurangDeshpande
 */
public class SecurityTeamWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Hospital hospital;
    private EcoSystem ecoSystem;
    private SecurityDepartment securityDepartment;
    
    /**
     * Creates new form HospitalAdminWorkAreaJPanel
     */
    public SecurityTeamWorkAreaJPanel(JPanel cardContainer, UserAccount account, Department department, Hospital hospital, EcoSystem ecoSystem) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.hospital = hospital;
        this.ecoSystem = ecoSystem;
        this.securityDepartment = (SecurityDepartment)department;
        
        lblLoggedInUser.setText(account.getEmployee().getPerson().getLastName()+", "+account.getEmployee().getPerson().getFirstName());
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
        btnManageRequests = new javax.swing.JButton();
        btnViewActivities = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        btnManageRequests.setBackground(new java.awt.Color(51, 51, 51));
        btnManageRequests.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnManageRequests.setForeground(new java.awt.Color(255, 255, 255));
        btnManageRequests.setText("Manage Requests");
        btnManageRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageRequestsActionPerformed(evt);
            }
        });

        btnViewActivities.setBackground(new java.awt.Color(51, 51, 51));
        btnViewActivities.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewActivities.setForeground(new java.awt.Color(255, 255, 255));
        btnViewActivities.setText("View Activities");
        btnViewActivities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActivitiesActionPerformed(evt);
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
                        .addGap(0, 886, Short.MAX_VALUE)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManageRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewActivities, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManageRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewActivities, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageRequestsActionPerformed
        // TODO add your handling code here:
        ManageRequestsSecurityTeamJPanel manageRequestsHospitalAdminJPanel = new ManageRequestsSecurityTeamJPanel(cardContainer, account, securityDepartment, hospital, ecoSystem);
        cardContainer.add("manageRequestsHospitalAdminJPanel", manageRequestsHospitalAdminJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnManageRequestsActionPerformed

    private void btnViewActivitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActivitiesActionPerformed
        // TODO add your handling code here:
        ViewActivitiesJPanel viewActivitiesJPanel = new ViewActivitiesJPanel(cardContainer, account, securityDepartment, hospital);
        cardContainer.add("viewActivitiesJPanel", viewActivitiesJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnViewActivitiesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageRequests;
    private javax.swing.JButton btnViewActivities;
    private javax.swing.JLabel lblLoggedInUser;
    // End of variables declaration//GEN-END:variables
}
