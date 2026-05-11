package com.mycompany.crsjava;

public class CourseAdminMenu extends javax.swing.JFrame {
    
    private final UserManager um;
    private final User currentUser;
    
    public CourseAdminMenu(UserManager um, User currentUser) {
        this.um = um;
        this.currentUser=currentUser;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCourseAdmin = new javax.swing.JComboBox<>();
        LogOutbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 14, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Admin Menu");

        cmbCourseAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbCourseAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a task ...", "Register New User", "View User List", "Edit User Details", "Manage Credentials" }));
        cmbCourseAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCourseAdminActionPerformed(evt);
            }
        });

        LogOutbtn.setText("Log Out");
        LogOutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(LogOutbtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmbCourseAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(cmbCourseAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogOutbtn)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 380, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutbtnActionPerformed
        currentUser.setLastLogout(String.valueOf(System.currentTimeMillis()));

        um.saveUsers("users.txt");

        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_LogOutbtnActionPerformed

    private void cmbCourseAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCourseAdminActionPerformed
            String selected = cmbCourseAdmin.getSelectedItem().toString();

    switch (selected) {
        case "Register New User" -> {
           new AddUser(um, currentUser).setVisible(true);
            dispose();
        }
        case "View User List" -> {
            new ViewList(um, currentUser).setVisible(true);
            dispose();
        }
        case "Edit User Details" -> {
            new EditUser(um, currentUser).setVisible(true);
            dispose();
        }
        
        case "Manage Credentials" -> {
            new Credential(um, currentUser).setVisible(true);
            dispose();
        }
    }
    }//GEN-LAST:event_cmbCourseAdminActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOutbtn;
    private javax.swing.JComboBox<String> cmbCourseAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
