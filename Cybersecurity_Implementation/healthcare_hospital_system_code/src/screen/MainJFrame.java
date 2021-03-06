/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import source.EcoSystem;
import source.department.Department;
import source.hospital.Hospital;
import source.userAccount.UserAccount;
import source.util.DB4OUtil;
import source.util.Util;
import source.util.UtilFunctions;

/**
 *
 * @author GaurangDeshpande
 */
public class MainJFrame extends javax.swing.JFrame {

    private EcoSystem ecoSystem;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private static Logger log;
    private UserAccount userAccount;
    private Timer timer;
    private static int count =0;
    
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        PropertyConfigurator.configure("log4j.properties");
        log = Logger.getLogger(MainJFrame.class);
        //BasicConfigurator.configure();
        
        //Test Lets Check
        ecoSystem = dB4OUtil.retrieveFromDatabase();
        //ecoSystem = dB4OUtil.checkBackUp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        navigationPanel = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        btnLoginLogout = new javax.swing.JButton();
        txtPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        cardContainer = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(74);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        navigationPanel.setBackground(new java.awt.Color(255, 102, 51));
        navigationPanel.setPreferredSize(new java.awt.Dimension(1250, 73));

        txtUsername.setBackground(new java.awt.Color(234, 232, 232));
        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(153, 153, 153));
        txtUsername.setText("username");
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        btnLoginLogout.setBackground(new java.awt.Color(51, 51, 51));
        btnLoginLogout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLoginLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginLogout.setText("Login");
        btnLoginLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginLogoutActionPerformed(evt);
            }
        });

        txtPasswordField.setBackground(new java.awt.Color(234, 232, 232));
        txtPasswordField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPasswordField.setForeground(new java.awt.Color(153, 153, 153));
        txtPasswordField.setText("password");
        txtPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFieldFocusLost(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/legacy-hospital-logo.jpg"))); // NOI18N

        javax.swing.GroupLayout navigationPanelLayout = new javax.swing.GroupLayout(navigationPanel);
        navigationPanel.setLayout(navigationPanelLayout);
        navigationPanelLayout.setHorizontalGroup(
            navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 519, Short.MAX_VALUE)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoginLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        navigationPanelLayout.setVerticalGroup(
            navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigationPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername)
                    .addComponent(btnLoginLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );

        jSplitPane1.setTopComponent(navigationPanel);

        cardContainer.setBackground(new java.awt.Color(255, 255, 255));
        cardContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(cardContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        if(txtUsername.getText().trim().equals(Util.USERNAME_HINT)){
            txtUsername.setText(Util.BLANK_QUOTES);
        }
        txtUsername.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void btnLoginLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginLogoutActionPerformed
        // TODO add your handling code here:
        if(btnLoginLogout.getText().trim().equals(Util.LOGIN_BUTTON_TEXT)){
            // Get user name
            String userName = txtUsername.getText().trim();
            // Get Password
            char[] passwordCharArray = txtPasswordField.getPassword();
            String password = String.valueOf(passwordCharArray);
            if((userName.equals(Util.USERNAME_HINT)||userName.equals(Util.BLANK_QUOTES)||userName==null) && (password.equals(Util.PASSWORD_HINT)||password.equals(Util.BLANK_QUOTES)||password==null)){
                JOptionPane.showMessageDialog(null, Util.ERROR_USERNAME_PASSWORD, Util.POP_UP_HEADING_ERROR, JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(userName.equals(Util.USERNAME_HINT)||userName.equals(Util.BLANK_QUOTES)||userName==null){
                JOptionPane.showMessageDialog(null, Util.ERROR_USERNAME, Util.POP_UP_HEADING_ERROR, JOptionPane.WARNING_MESSAGE);
                return;
            }
            else if(password.equals(Util.PASSWORD_HINT)||password.equals(Util.BLANK_QUOTES)||password==null){
                JOptionPane.showMessageDialog(null, Util.ERROR_PASSWORD, Util.POP_UP_HEADING_ERROR, JOptionPane.WARNING_MESSAGE);
                return;
            }
            userAccount = ecoSystem.getUserAccountDirectory().authenticateUser(userName, password);
            if(userAccount!=null){
                backupFiles();
            }
            Hospital hospital = null;
            Department department = null;
            if(userAccount == null){
                //for(Network network:ecoSystem.getNetworkList()){
                    for(Hospital aHospital:ecoSystem.getHospitalDirectory().getHospitalList()){
                        userAccount = aHospital.getUserAccountDirectory().authenticateUser(userName, password);
                        if(userAccount==null){
                            for(Department aDepartment:aHospital.getDepartmentDirectory().getDepartmentList()){
                                userAccount = aDepartment.getUserAccountDirectory().authenticateUser(userName, password);
                                if(userAccount!=null){
                                    hospital = aHospital;
                                    department = aDepartment;
                                    break;
                                }
                            }
                        }
                        else{
                            hospital = aHospital;
                            break;
                        }
                        if(department!=null){
                            break;
                        }
                    }
//                    if(hospital!=null){
//                        break;
//                    }
                //}
            }
            
            if(userAccount==null){
                //Account does not exist
                JOptionPane.showMessageDialog(null, Util.ERROR_INVALID_CREDENTIALS, Util.POP_UP_HEADING_ERROR, JOptionPane.ERROR_MESSAGE);
                log.info(UtilFunctions.encrypt("INVALID_CRED : "+userName));
                return;
            }
            else{
                //Go to this account's work area
                if(userAccount.getPatient()!=null){
                    log.info(UtilFunctions.encrypt("LOGIN : "+userAccount.getPatient().getPerson().getFirstName()+" "+userAccount.getPatient().getPerson().getLastName()));
                }
                else{
                    log.info(UtilFunctions.encrypt("LOGIN : "+userAccount.getEmployee()));
                }
                CardLayout layout = (CardLayout) cardContainer.getLayout();
                cardContainer.add(Util.WORK_AREA, userAccount.getRole().createWorkArea(cardContainer, userAccount, department, hospital, ecoSystem));
                layout.next(cardContainer);
            }
            btnLoginLogout.setText(Util.LOGOUT_BUTTON_TEXT);
            txtUsername.setEnabled(false);
            txtUsername.setVisible(false);
            txtPasswordField.setEnabled(false);
            txtPasswordField.setVisible(false);
        }
        else if(btnLoginLogout.getText().trim().equals(Util.LOGOUT_BUTTON_TEXT)){
            btnLoginLogout.setText(Util.LOGIN_BUTTON_TEXT);
            txtUsername.setEnabled(true);
            txtPasswordField.setEnabled(true);
            
            txtUsername.setText(Util.USERNAME_HINT);
            txtUsername.setForeground(new Color(153,153,153));
            txtUsername.setVisible(true);
            txtPasswordField.setText(Util.PASSWORD_HINT);
            txtPasswordField.setForeground(new Color(153,153,153));
            txtPasswordField.setVisible(true);
            
            cardContainer.removeAll();
            JPanel blankPanel = new JPanel();
            blankPanel.setBackground(Color.WHITE);
            cardContainer.add(Util.BLANK_WORK_AREA, blankPanel);
            CardLayout layout = (CardLayout) cardContainer.getLayout();
            layout.next(cardContainer);
            
            dB4OUtil.storeInDatabase(ecoSystem);
            if (userAccount.getPatient() != null) {
                log.info(UtilFunctions.encrypt("LOGOUT : " + userAccount.getPatient().getPerson().getFirstName()+" "+userAccount.getPatient().getPerson().getLastName()));
            } else {
                log.info(UtilFunctions.encrypt("LOGOUT : " + userAccount.getEmployee()));
            }
        }
    }//GEN-LAST:event_btnLoginLogoutActionPerformed

    private void backupFiles() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Take backup now");
                ++count;
                dB4OUtil.createBackupFile(count, ecoSystem);
            }
        };
                 
        timer = new Timer(12000, listener);
        timer.start();
        System.out.println("---------Test Started---------");
    }
    
    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        // TODO add your handling code here:
        if(txtUsername.getText().equals(Util.BLANK_QUOTES)){
            txtUsername.setText(Util.USERNAME_HINT);
            txtUsername.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFieldFocusLost
        // TODO add your handling code here:
        if(txtPasswordField.getPassword().length==0||String.valueOf(txtPasswordField.getPassword()).equals(Util.BLANK_QUOTES)){
            txtPasswordField.setText(Util.PASSWORD_HINT);
            txtPasswordField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtPasswordFieldFocusLost

    private void txtPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFieldFocusGained
        // TODO add your handling code here:
        char[] passwordCharArray = txtPasswordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        if(password.equals(Util.PASSWORD_HINT)){
            txtPasswordField.setText(Util.BLANK_QUOTES);
        }
        txtPasswordField.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtPasswordFieldFocusGained

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginLogout;
    private javax.swing.JPanel cardContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JPasswordField txtPasswordField;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
