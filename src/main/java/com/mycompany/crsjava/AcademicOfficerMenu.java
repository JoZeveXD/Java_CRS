package com.mycompany.crsjava;

import javax.swing.JOptionPane;

public class AcademicOfficerMenu extends javax.swing.JFrame {
    
    private final UserManager um;
    private final User currentUser;
    
    public AcademicOfficerMenu(UserManager um, User user) {
        this.um = um;
        this.currentUser = user;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbAcademicOfficer = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Academic Officer Menu");

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbAcademicOfficer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbAcademicOfficer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a task ...", "Manage Recovery Plan", "Check Eligibility", "Generate Reports" }));
        cmbAcademicOfficer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAcademicOfficerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(cmbAcademicOfficer, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbAcademicOfficer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        currentUser.setLastLogout(
        Long.toBinaryString(System.currentTimeMillis())
        );

        um.saveUsers("users.txt");

        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbAcademicOfficerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAcademicOfficerActionPerformed
        String selected = cmbAcademicOfficer.getSelectedItem().toString(); // Check your variable name (maybe cmbTask)

        switch (selected) {
            case "Manage Recovery Plan" -> {
                // Pass 'um' and 'currentUser'
                new RecoveryPlanUI(um, currentUser).setVisible(true);
                this.dispose();
            }
            case "Check Eligibility" -> {
                // Pass 'um' and 'currentUser'
                new EligibilityUI(um, currentUser).setVisible(true);
                this.dispose();
            }
            case "Generate Reports" -> {
                // Pass 'um' and 'currentUser'
                new ReportGenUI(um, currentUser).setVisible(true);
                this.dispose();
            }
            case "View User List" -> {
                // Pass 'um' and 'currentUser'
                new ViewList(um, currentUser).setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_cmbAcademicOfficerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAcademicOfficer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
