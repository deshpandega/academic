/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.doctor;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import source.hospital.Hospital;
import source.patient.Patient;
import source.patient.Prescription;
import source.patient.Procedure;
import source.patient.Surgery;
import source.patient.VitalSigns;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;

/**
 *
 * @author GaurangDeshpande
 */
public class ViewPastMedicalRecordJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Patient patient;
    private Hospital hospital;
    private String recordType;
    private static Logger log;
    
    /**
     * Creates new form ViewPastMedicalRecordJPanel
     */
    ViewPastMedicalRecordJPanel(JPanel cardContainer, UserAccount account, Patient patient, Hospital hospital, String recordType) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.patient = patient;
        this.hospital = hospital;
        lblLoggedInUser.setText(account.getEmployee().getPerson().getLastName()+", "+account.getEmployee().getPerson().getFirstName());
        this.recordType = recordType;
        log = Logger.getLogger(ViewPastMedicalRecordJPanel.class);
        log.info(UtilFunctions.encrypt("VIEW_REC : "+account.getEmployee()));
        populateMedicalHistory();
    }

    private void populateMedicalHistory() {
        if (recordType.equalsIgnoreCase("VitalSign")) {
            scrollVitalSign.setVisible(true);
            scrollPrescription.setVisible(false);
            scrollSurgery.setVisible(false);
            scrollProcedures.setVisible(false);
            DefaultTableModel dtm = (DefaultTableModel) tblVitalSignHistory.getModel();
            dtm.setRowCount(0);
            for (VitalSigns vs : patient.getVitalSignHistory().getVitalSignHistory()) {
                Object row[] = new Object[7];
                row[0] = vs.getBloodPressure();
                row[1] = vs.getPulseRate();
                row[2] = vs.getWeight();
                row[3] = vs.getRespirationRate();
                row[4] = vs.getBloodGlucoseLevel();
                row[5] = vs.getHeight();
                row[6] = vs.getTemperature();
                dtm.addRow(row);
            }
        }
        else if (recordType.equalsIgnoreCase("Prescription")) {
            scrollVitalSign.setVisible(false);
            scrollPrescription.setVisible(true);
            scrollSurgery.setVisible(false);
            scrollProcedures.setVisible(false);
            DefaultTableModel dtm = (DefaultTableModel) tblPrescriptionHistory.getModel();
            dtm.setRowCount(0);
            for (Prescription p : patient.getPrescriptionHistory().getPrescriptionHistory()) {
                Object row[] = new Object[5];
                row[0] = p.getMedicineName();
                row[1] = p.getPrescribedOn();
                row[2] = p.getPrescribedTill();
                row[3] = p.getDailyDosage();
                row[4] = p.getPrescriptionDescription();
                dtm.addRow(row);
            }
        }
        else if (recordType.equalsIgnoreCase("Surgery")) {
            scrollVitalSign.setVisible(false);
            scrollPrescription.setVisible(false);
            scrollSurgery.setVisible(true);
            scrollProcedures.setVisible(false);
            DefaultTableModel dtm = (DefaultTableModel) tblSurgeryHistory.getModel();
            dtm.setRowCount(0);
            for (Surgery s : patient.getSurgicalHistory().getSurgeryDirectory()) {
                Object row[] = new Object[7];
                row[0] = s.getSurgeryType();
                row[1] = s.getSurgeryTime();
                row[2] = s.getSurgeryDescription();
                row[3] = s.getSurgeryComplications();
                row[4] = s.getSurgeryOutcome();
                row[5] = s.getPerformedBy();
                row[6] = s.getSurgeryAssisstedBy().size();
                dtm.addRow(row);
            }
        }
        else if (recordType.equalsIgnoreCase("Procedures")) {
            scrollVitalSign.setVisible(false);
            scrollPrescription.setVisible(false);
            scrollSurgery.setVisible(false);
            scrollProcedures.setVisible(true);
            DefaultTableModel dtm = (DefaultTableModel) tblProceduresHistory.getModel();
            dtm.setRowCount(0);
            for (Procedure p : patient.getProcedureDirectory().getProcedureList()) {
                Object row[] = new Object[8];
                row[0] = p.getProcedureType();
                row[1] = p.getProcedureDescription();
                row[2] = p.getRequestedBy();
                row[3] = p.getCompletedBy();
                row[4] = p.getPerformedOn();
                row[5] = p.getStatus();
                row[6] = p.getRequestDate();
                row[7] = p.getCompletionDate();
                
                dtm.addRow(row);
            }
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

        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        lblLoggedInUser = new javax.swing.JLabel();
        scrollVitalSign = new javax.swing.JScrollPane();
        tblVitalSignHistory = new javax.swing.JTable();
        scrollPrescription = new javax.swing.JScrollPane();
        tblPrescriptionHistory = new javax.swing.JTable();
        scrollSurgery = new javax.swing.JScrollPane();
        tblSurgeryHistory = new javax.swing.JTable();
        scrollProcedures = new javax.swing.JScrollPane();
        tblProceduresHistory = new javax.swing.JTable();

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
        lblHeading.setText("View Medical History");

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        tblVitalSignHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blood Pressure", "Pulse Rate", "Weight", "Respiration Rate", "Glucose Level", "Height", "Temperature"
            }
        ));
        scrollVitalSign.setViewportView(tblVitalSignHistory);

        tblPrescriptionHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", "Prescribed On", "Prescribed Till", "Daily Dosages", "Description"
            }
        ));
        scrollPrescription.setViewportView(tblPrescriptionHistory);

        tblSurgeryHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Surgery Type", "Time", "Description", "Complications", "Outcomes", "Performed By", "Number of Assists"
            }
        ));
        scrollSurgery.setViewportView(tblSurgeryHistory);

        tblProceduresHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Description", "Requested By", "Completed By", "Performed On", "Status", "Requested Date", "Completion Date"
            }
        ));
        scrollProcedures.setViewportView(tblProceduresHistory);

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
                            .addComponent(scrollProcedures, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                            .addComponent(scrollSurgery, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollVitalSign)
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPrescription))))
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
                .addComponent(scrollVitalSign, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollSurgery, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollProcedures, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void goBack(){
        cardContainer.remove(this);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JScrollPane scrollPrescription;
    private javax.swing.JScrollPane scrollProcedures;
    private javax.swing.JScrollPane scrollSurgery;
    private javax.swing.JScrollPane scrollVitalSign;
    private javax.swing.JTable tblPrescriptionHistory;
    private javax.swing.JTable tblProceduresHistory;
    private javax.swing.JTable tblSurgeryHistory;
    private javax.swing.JTable tblVitalSignHistory;
    // End of variables declaration//GEN-END:variables
}
