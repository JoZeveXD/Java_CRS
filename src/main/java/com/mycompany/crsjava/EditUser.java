package com.mycompany.crsjava;

import javax.swing.JOptionPane;


public class EditUser extends javax.swing.JFrame {
    
    private final UserManager um;
    private final User currentUser;

    public EditUser(UserManager um, User currentUser) {
        this.um = um;
        this.currentUser=currentUser;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RoleCombo = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        searchUser = new javax.swing.JButton();
        txtNewUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Edit User");

        jLabel2.setText("Username：");

        jLabel4.setText("Role:");

        RoleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CourseAdmin", "AcademicOfficer" }));
        RoleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleComboActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        clear.setText("Clear Fields");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        searchUser.setText("Search");
        searchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserActionPerformed(evt);
            }
        });

        txtNewUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewUsernameActionPerformed(evt);
            }
        });

        jLabel5.setText("New Username:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(clear)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNewUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RoleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(save)
                                .addGap(44, 44, 44)
                                .addComponent(exit)))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchUser)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(RoleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(exit)
                    .addComponent(clear))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
            this.dispose();
            if (currentUser instanceof AcademicOfficer) {
            new AcademicOfficerMenu(um, currentUser).setVisible(true);
        }
        else if (currentUser instanceof CourseAdmin) {
            new CourseAdminMenu(um, currentUser).setVisible(true);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String currentUsername = txtUsername.getText().trim();
        String newUsername = txtNewUsername.getText().trim();
        String role = RoleCombo.getSelectedItem().toString();

    // 2. Validate Selection
    if (currentUsername.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please search for a user first.");
        return;
    }

    // 3. Find the User Object
    User userToEdit = um.findUserByUsername(currentUsername);

    if (userToEdit == null) {
        JOptionPane.showMessageDialog(this, "Critical Error: User not found in memory.");
        return;
    }
    
    // 4. Handle Username Change (With Duplicate Check)
    if (!newUsername.isEmpty() && !newUsername.equals(currentUsername)) {
        
        // CHECK: Is this new name taken?
        if (um.findUserByUsername(newUsername) != null) {
            JOptionPane.showMessageDialog(this, 
                "Error: The username '" + newUsername + "' is already taken.\nPlease choose another.",
                "Duplicate Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // APPLY: Set new name
        userToEdit.setUsername(newUsername);
        
        // UPDATE GUI: The "Current" ID is now the new name
        txtUsername.setText(newUsername);
        txtNewUsername.setText(""); 
    }

    // 5. Update Role
    userToEdit.setRole(role);
    
    // 6. Save to File
    um.saveUsers("users.txt");

    JOptionPane.showMessageDialog(this, "User details updated successfully!");
    
    }//GEN-LAST:event_saveActionPerformed
        
    private void searchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserActionPerformed
        java.util.List<User> users = um.getUsers();

        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No users found!");
            return;
        }

        String[] names = users.stream()
                .map(User::getUsername)
                .toArray(String[]::new);

        String selected;
        selected = (String) JOptionPane.showInputDialog(
                this,
                "Select a user:",
                "User List",
                JOptionPane.QUESTION_MESSAGE,
                null,
                names,
                names[0]
        );

        if (selected == null) return;

        User user = um.findUserByUsername(selected);

        if (user == null) return;

        if (user.getUsername().equals(currentUser.getUsername())) {
            JOptionPane.showMessageDialog(this,
                "You cannot edit your own account!");
            return;
        }

        txtUsername.setEditable(false);
        txtUsername.setText(user.getUsername());
        txtNewUsername.setText(user.getUsername());
        RoleCombo.setSelectedItem(user.getRole());

    }//GEN-LAST:event_searchUserActionPerformed

    private void RoleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleComboActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        txtUsername.setText("");
        txtUsername.setEditable(true);
        txtNewUsername.setText("");
        RoleCombo.setSelectedIndex(0);
    }//GEN-LAST:event_clearActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtNewUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewUsernameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> RoleCombo;
    private javax.swing.JButton clear;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton save;
    private javax.swing.JButton searchUser;
    private javax.swing.JTextField txtNewUsername;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
