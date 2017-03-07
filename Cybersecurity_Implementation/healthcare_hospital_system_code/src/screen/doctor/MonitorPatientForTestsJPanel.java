/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.doctor;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import source.patient.Patient;
import source.patient.TestFindings;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;

/**
 *
 * @author GaurangDeshpande
 */
public class MonitorPatientForTestsJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Patient patient;
    private static Logger log;
    
    /**
     * Creates new form MonitorPatientForTestsJPanel
     */
    MonitorPatientForTestsJPanel(JPanel cardContainer, UserAccount account, Patient patient) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.patient = patient;
        log = Logger.getLogger(MonitorPatientForTestsJPanel.class);
        lblLoggedInUser.setText(account.getEmployee().getPerson().getLastName()+", "+account.getEmployee().getPerson().getFirstName());
        
        log.info(UtilFunctions.encrypt("MON_PAT : "+account.getEmployee()));
        
        panelResponseGraphBefore.setVisible(false);
        panelResponseGraphAfter.setVisible(false);
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
        btnReactionResponse = new javax.swing.JButton();
        btnTappingResponse = new javax.swing.JButton();
        panelResponseGraphBefore = new javax.swing.JPanel();
        panelResponseGraphAfter = new javax.swing.JPanel();

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
        lblHeading.setText("Monitor Patients");

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        btnReactionResponse.setBackground(new java.awt.Color(51, 51, 51));
        btnReactionResponse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReactionResponse.setForeground(new java.awt.Color(255, 255, 255));
        btnReactionResponse.setText("Reaction ");
        btnReactionResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactionResponseActionPerformed(evt);
            }
        });

        btnTappingResponse.setBackground(new java.awt.Color(51, 51, 51));
        btnTappingResponse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTappingResponse.setForeground(new java.awt.Color(255, 255, 255));
        btnTappingResponse.setText("Tapping");
        btnTappingResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTappingResponseActionPerformed(evt);
            }
        });

        panelResponseGraphBefore.setLayout(new java.awt.BorderLayout());

        panelResponseGraphAfter.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(btnTappingResponse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReactionResponse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                            .addComponent(panelResponseGraphBefore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelResponseGraphAfter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTappingResponse, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReactionResponse, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelResponseGraphBefore, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelResponseGraphAfter, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReactionResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactionResponseActionPerformed
        // TODO add your handling code here:
        drawCharts("Reaction");
    }//GEN-LAST:event_btnReactionResponseActionPerformed

    private void btnTappingResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTappingResponseActionPerformed
        // TODO add your handling code here:
        drawCharts("Tapping");
    }//GEN-LAST:event_btnTappingResponseActionPerformed

    private void drawCharts(String type){
        panelResponseGraphBefore.setVisible(true);
        panelResponseGraphAfter.setVisible(true);
        
        DefaultCategoryDataset barChartTappingBefore = new DefaultCategoryDataset();
        DefaultCategoryDataset barChartTappingAfter = new DefaultCategoryDataset();
        DefaultCategoryDataset barChartReactionBefore = new DefaultCategoryDataset();
        DefaultCategoryDataset barChartReactionAfter = new DefaultCategoryDataset();
        
        if (type.equals("Tapping")) {
            for (TestFindings findings : patient.getTestFindingHistory().getTestFindingHistory()) {
                if(findings.getTappingCountBefore()!=0){
                    barChartTappingBefore.addValue(findings.getTappingCountBefore(), "", String.valueOf(UtilFunctions.formatDate(findings.getTimeStamp())));
                }
                if(findings.getTappingConntAfter()!=0){
                    barChartTappingAfter.addValue(findings.getTappingConntAfter(), "", String.valueOf(UtilFunctions.formatDate(findings.getTimeStamp())));
                }
            }
        }
        else if(type.equals("Reaction")){
            for (TestFindings findings : patient.getTestFindingHistory().getTestFindingHistory()) {
                if(findings.getAverageResponseTimeBefore()!=0){
                    barChartReactionBefore.addValue(findings.getAverageResponseTimeBefore(), "", String.valueOf(UtilFunctions.formatDate(findings.getTimeStamp())));
                }
                if(findings.getAverageResponseTimeAfter()!=0){
                    barChartReactionAfter.addValue(findings.getAverageResponseTimeAfter(), "", String.valueOf(UtilFunctions.formatDate(findings.getTimeStamp())));
                }
            }
        }
        
        JFreeChart barChartTapBefore = ChartFactory.createBarChart3D("Tapping Response Before", "Date", "Tappings", barChartTappingBefore, PlotOrientation.VERTICAL, false, true, false);
        JFreeChart barChartTapAfter = ChartFactory.createBarChart3D("Tapping Response After", "Date", "Tappings", barChartTappingAfter, PlotOrientation.VERTICAL, false, true, false);
        JFreeChart barChartRespBefore = ChartFactory.createBarChart3D("Reaction Response Before", "Date", "Response", barChartReactionBefore, PlotOrientation.VERTICAL, false, true, false);
        JFreeChart barChartRespAfter = ChartFactory.createBarChart3D("Reaction Response After", "Date", "Response", barChartReactionAfter, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot barChartTapBeforeCategory = (CategoryPlot) barChartTapBefore.getCategoryPlot();
        CategoryPlot barChartTapAfterCategory = (CategoryPlot) barChartTapAfter.getCategoryPlot();
        CategoryPlot barChartRespBeforeCategory = (CategoryPlot) barChartRespBefore.getCategoryPlot();
        CategoryPlot barChartRespAfterCategory = (CategoryPlot) barChartRespAfter.getCategoryPlot();
        
        barChartTapBeforeCategory.setRangeGridlinePaint(Color.ORANGE);
        barChartTapBeforeCategory.setOutlinePaint(Color.ORANGE);
        ((BarRenderer)barChartTapBeforeCategory.getRenderer()).setBarPainter(new StandardBarPainter());
        BarRenderer renderer = (BarRenderer) barChartTapBefore.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.DARK_GRAY);
        
        barChartTapAfterCategory.setRangeGridlinePaint(Color.ORANGE);
        barChartTapAfterCategory.setOutlinePaint(Color.ORANGE);
        ((BarRenderer)barChartTapAfterCategory.getRenderer()).setBarPainter(new StandardBarPainter());
        renderer = (BarRenderer) barChartTapAfter.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.DARK_GRAY);
        
        barChartRespBeforeCategory.setRangeGridlinePaint(Color.ORANGE);
        barChartRespBeforeCategory.setOutlinePaint(Color.ORANGE);
        ((BarRenderer)barChartRespBeforeCategory.getRenderer()).setBarPainter(new StandardBarPainter());
        renderer = (BarRenderer) barChartRespBefore.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.DARK_GRAY);
        
        barChartRespAfterCategory.setRangeGridlinePaint(Color.ORANGE);
        barChartRespAfterCategory.setOutlinePaint(Color.ORANGE);
        ((BarRenderer)barChartRespAfterCategory.getRenderer()).setBarPainter(new StandardBarPainter());
        renderer = (BarRenderer) barChartRespAfter.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.DARK_GRAY);
        
        if(type.equals("Tapping")){
            ChartPanel chartPanelBefore = new ChartPanel(barChartTapBefore);
            ChartPanel chartPanelAfter = new ChartPanel(barChartTapAfter);
            
            panelResponseGraphBefore.removeAll();
            panelResponseGraphBefore.add(chartPanelBefore, BorderLayout.CENTER);
            panelResponseGraphBefore.validate();
            
            panelResponseGraphAfter.removeAll();
            panelResponseGraphAfter.add(chartPanelAfter, BorderLayout.CENTER);
            panelResponseGraphAfter.validate();
        }
        else if(type.equals("Reaction")){
            ChartPanel chartPanelBefore = new ChartPanel(barChartRespBefore);
            ChartPanel chartPanelAfter = new ChartPanel(barChartRespAfter);
            
            panelResponseGraphBefore.removeAll();
            panelResponseGraphBefore.add(chartPanelBefore, BorderLayout.CENTER);
            panelResponseGraphBefore.validate();
            
            panelResponseGraphAfter.removeAll();
            panelResponseGraphAfter.add(chartPanelAfter, BorderLayout.CENTER);
            panelResponseGraphAfter.validate();
        }
    }

    private void goBack(){
        cardContainer.remove(this);
        Component[] componentArray = cardContainer.getComponents();
        Component component= componentArray[componentArray.length - 1];
        PatientDetailsJPanel patientDetailsJPanel = (PatientDetailsJPanel) component;
        patientDetailsJPanel.populateTable();
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReactionResponse;
    private javax.swing.JButton btnTappingResponse;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JPanel panelResponseGraphAfter;
    private javax.swing.JPanel panelResponseGraphBefore;
    // End of variables declaration//GEN-END:variables
}