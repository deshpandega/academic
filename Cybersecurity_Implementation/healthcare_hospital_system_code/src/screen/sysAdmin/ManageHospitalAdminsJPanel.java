/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.sysAdmin;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import source.EcoSystem;
import source.employee.Employee;
import source.hospital.Hospital;
import source.person.Person;
import source.role.AdminRole;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;

/**
 *
 * @author GaurangDeshpande
 */
public class ManageHospitalAdminsJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private EcoSystem ecoSystem;
    private static Logger log;
    /**
     * Creates new form ManageHospitalAdminsJPanel
     */
    ManageHospitalAdminsJPanel(JPanel cardContainer, UserAccount account, EcoSystem ecoSystem) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.ecoSystem = ecoSystem;
        log = Logger.getLogger(ManageHospitalAdminsJPanel.class);
        
        lblLoggedInUser.setText(account.getEmployee().getPerson().getLastName()+", "+account.getEmployee().getPerson().getFirstName());
        
        populateHospitalList();
        populateGender();
        populateSates();
    }

    private void populateHospitalList(){
        cmbHospitals.removeAllItems();
        cmbHospitals.addItem("Select a branch");
        for(Hospital branchName: ecoSystem.getHospitalDirectory().getHospitalList()){
            cmbHospitals.addItem(branchName);
        }
    }
    
    private void populateGender(){
        cmbGender.removeAllItems();
        cmbGender.addItem("Select a gender");
        for(String gender:UtilFunctions.populateGender()){
            cmbGender.addItem(gender);
        }
    }
    
    private void populateSates(){
        cmbState.removeAllItems();
        cmbState.addItem("Select a state");
        for(String state: UtilFunctions.populateStates()){
            cmbState.addItem(state);
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
        txtHeading = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbHospitals = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        btnCreateUserAdmin = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPasswordField = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtSSN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmailID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtAddressLine1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAddressLine2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtZipcode = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox();
        cmbState = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        txtHeading.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtHeading.setText("Add Hospital Admin");

        btnBack.setBackground(new java.awt.Color(51, 51, 51));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Hospital Name:");

        cmbHospitals.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("First Name:");

        txtFirstName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registration Details");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Last Name:");

        txtLastName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        btnCreateUserAdmin.setBackground(new java.awt.Color(51, 51, 51));
        btnCreateUserAdmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateUserAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateUserAdmin.setText("Create Admin");
        btnCreateUserAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserAdminActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Password:");

        txtPasswordField.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Social Security Number:");

        txtSSN.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Gender:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Phone Number:");

        txtPhoneNumber.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Email:");

        txtEmailID.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Address Line 1:");

        txtAddressLine1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Address Line 2:");

        txtAddressLine2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("City:");

        txtCity.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("State:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Zip:");

        txtZipcode.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        cmbGender.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        cmbState.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(944, 944, 944)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPasswordField)))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCreateUserAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSSN, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtAddressLine1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCity)
                                    .addComponent(txtZipcode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEmailID))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAddressLine2))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(29, 29, 29))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbHospitals, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(366, 366, 366)))))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(txtHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHospitals, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSSN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreateUserAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateUserAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserAdminActionPerformed
        // TODO add your handling code here:
        boolean allDataEnteredCorrectly = validateData();
        if(allDataEnteredCorrectly){
            log.info(UtilFunctions.encrypt("CR_ADM : "+account.getEmployee()));
            Hospital hospital = (Hospital)cmbHospitals.getSelectedItem();
            
            Employee employee = hospital.getEmployeeDirectory().createEmployee();
            employee.setEmployeeId(hospital.getCollectionCount().retriveEmployeeID());
            Person person = employee.assignPerson();
            UserAccount account = hospital.getUserAccountDirectory().createUserAccount();
            
            person.setFirstName(txtFirstName.getText().trim());
            person.setLastName(txtLastName.getText().trim());
            person.setGender((String)cmbGender.getSelectedItem());
            person.setSocialSecurityNumber(txtSSN.getText().trim());
            person.setPhoneNumber(Long.parseLong(txtPhoneNumber.getText().trim()));
            person.setEmailAddress(txtEmailID.getText().trim());
            person.getAddress().setAddLine1(txtAddressLine1.getText().trim());
            person.getAddress().setAddLine2(txtAddressLine2.getText().trim());
            person.getAddress().setCity(txtCity.getText().trim());
            person.getAddress().setState((String)cmbState.getSelectedItem());
            person.getAddress().setZipcode(Integer.parseInt(txtZipcode.getText().trim()));
            
            
            account.setEmployee(employee);
            account.setUsername(txtUsername.getText().trim());
            account.setPassword(String.valueOf(txtPasswordField.getPassword()));
            account.setRole(new AdminRole());
            
            txtFirstName.setText("");
            txtLastName.setText("");
            txtUsername.setText("");
            txtPasswordField.setText("");
            txtSSN.setText("");
            txtPhoneNumber.setText("");
            txtEmailID.setText("");
            txtAddressLine1.setText("");
            txtAddressLine2.setText("");
            txtCity.setText("");
            txtZipcode.setText("");
            
            JOptionPane.showMessageDialog(null,"Admin Created!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            
        }
    }//GEN-LAST:event_btnCreateUserAdminActionPerformed

    private boolean validateData(){
        int i=0;
        
        char[] passwordCharArray = txtPasswordField.getPassword();
        String passwordEntered = String.valueOf(passwordCharArray);
        
        if(cmbHospitals.getSelectedItem().equals("Select a branch")){
            cmbHospitals.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please select a Hospital from the list", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            cmbHospitals.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate First Name
        if (txtFirstName.getText().trim().equalsIgnoreCase("") || txtFirstName.getText().trim() == null) {
            txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter First Name", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        } else if (!UtilFunctions.validateTextOnly(txtFirstName.getText().trim())) {
            txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only alphabets in First Name", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        } else {
            txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Last Name
        if(txtLastName.getText().trim().equalsIgnoreCase("")||txtLastName.getText().trim()==null){
            txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter Last Name", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateTextOnly(txtLastName.getText().trim())){
            txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only alphabets in Last Name", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Username
        if(txtUsername.getText().trim().equalsIgnoreCase("")||txtUsername.getText().trim()==null){
            txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter Username", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateUsernameCriteria(txtUsername.getText().trim())){
            txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Username must be between 6-20 characters", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Password
        if(passwordEntered.equalsIgnoreCase("")||passwordEntered==null){
            txtPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter Password", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validatePasswordCriteria(passwordEntered)){
            txtPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Password must contain:\n 6-20 characters\n Must haave ONE uppercase character\n Must have ONE lower case character\n Must have ONE number\n Must have ONE special character", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate SSN
        if(txtSSN.getText().trim().equalsIgnoreCase("")||txtSSN.getText().trim()==null){
            txtSSN.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter Social Security Number", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateSSN(txtSSN.getText().trim())){
            txtSSN.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only 9 numericals in Social Security Number", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtSSN.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Gender
        if(cmbGender.getSelectedItem().equals("Select a gender")){
            cmbGender.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please select gender", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            cmbGender.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Phone Number
        if(txtPhoneNumber.getText().trim().equalsIgnoreCase("")||txtPhoneNumber.getText().trim()==null){
            txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter Phone Number", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateNumericalsOnly(txtPhoneNumber.getText().trim())){
            txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only numericals in Phone Number", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(txtPhoneNumber.getText().length()!=10){
            txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter 10 dgit Phone Number without . and -", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Email
        if(txtEmailID.getText().trim().equalsIgnoreCase("")||txtEmailID.getText().trim()==null){
            txtEmailID.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter Email", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateEmailAddress(txtEmailID.getText().trim())){
            txtEmailID.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter valid Email", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtEmailID.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Address Line 1
        if(txtAddressLine1.getText().trim().equalsIgnoreCase("")||txtAddressLine1.getText().trim()==null){
            txtAddressLine1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter Address Line 1", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateNumberAndText(txtAddressLine1.getText().trim())){
            txtAddressLine1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only text and numbers in Addres Line 1", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtAddressLine1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Address Line 2
        if(txtAddressLine2.getText().trim().equalsIgnoreCase("")||txtAddressLine2.getText().trim()==null){
            txtAddressLine2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        else if(!UtilFunctions.validateNumberAndText(txtAddressLine2.getText().trim())){
            txtAddressLine2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only text and numbers in Address Line 2", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtAddressLine2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate City
        if(txtCity.getText().trim().equalsIgnoreCase("")||txtCity.getText().trim()==null){
            txtCity.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter City", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateTextOnly(txtCity.getText().trim())){
            txtCity.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only text in City", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtCity.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate State
        if(cmbState.getSelectedItem().equals("Select a state")){
            cmbState.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please select State", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            cmbState.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Zip
        if(txtZipcode.getText().trim().equalsIgnoreCase("")||txtZipcode.getText().trim()==null){
            txtZipcode.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter Zip", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateZip(txtZipcode.getText().trim())){
            txtZipcode.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only 5 numbers in Zip", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtZipcode.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        if(i==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    private void goBack(){
        cardContainer.remove(this);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateUserAdmin;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JComboBox cmbHospitals;
    private javax.swing.JComboBox cmbState;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JTextField txtAddressLine1;
    private javax.swing.JTextField txtAddressLine2;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmailID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JLabel txtHeading;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPasswordField;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSSN;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtZipcode;
    // End of variables declaration//GEN-END:variables
}
