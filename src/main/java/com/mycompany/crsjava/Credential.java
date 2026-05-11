package com.mycompany.crsjava;

import javax.swing.JOptionPane;
    
public class Credential extends javax.swing.JFrame {
    
    private final UserManager um;
    private User selectedUser;
    private final User currentUser;
    
    public Credential(UserManager um,User currentUser) {
        this.um = um;
        this.currentUser = currentUser;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        selectUser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        changePassword = new javax.swing.JButton();
        newPassword = new javax.swing.JPasswordField();
        btnButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Credential Managment");

        jLabel2.setText("Username：");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        selectUser.setText("...");
        selectUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectUserActionPerformed(evt);
            }
        });

        jLabel4.setText("New Password:");

        changePassword.setText("Confirm Change");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });

        newPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordActionPerformed(evt);
            }
        });

        btnButton.setText("Back");
        btnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Confirm Password:");

        txtConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newPassword)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(txtConfirmPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnButton)
                        .addGap(46, 46, 46)
                        .addComponent(changePassword)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(105, 105, 105))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectUser)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePassword)
                    .addComponent(btnButton))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void selectUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectUserActionPerformed
        java.util.List<User> users = um.getUsers();

        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No users found!");
            return;
        }

        String[] names = users.stream()
                .map(User::getUsername)
                .toArray(String[]::new);

        String selected = (String) JOptionPane.showInputDialog(
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
        
        selectedUser = user;

        txtUsername.setEditable(false);
        txtUsername.setText(user.getUsername());
    }//GEN-LAST:event_selectUserActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        if (selectedUser == null) {
        String inputUsername = txtUsername.getText().trim();

        if (inputUsername.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select or enter a username first!");
            return;
        }

        selectedUser = um.findUserByUsername(inputUsername);

        if (selectedUser == null) {
            JOptionPane.showMessageDialog(this, "User not found!");
            return;
        }

        if (selectedUser.getUsername().equals(currentUser.getUsername())) {
            JOptionPane.showMessageDialog(this, "You cannot edit your own account!");
            selectedUser = null;
            return;
        }
    }

    // --- 2. GET BOTH PASSWORDS ---
    String newPwd = new String(newPassword.getPassword());       // Your existing field
    String confirmPwd = new String(txtConfirmPassword.getPassword()); // The NEW field you just added

    // --- 3. CHECK IF EMPTY ---
    if (newPwd.isEmpty()) {
        JOptionPane.showMessageDialog(this, "New password cannot be empty!");
        return;
    }

    // --- 4. CHECK IF THEY MATCH (The new logic) ---
    if (!newPwd.equals(confirmPwd)) {
        JOptionPane.showMessageDialog(this, "Passwords do not match! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        
        // Optional: Clear the fields so they can type again
        newPassword.setText("");
        txtConfirmPassword.setText("");
        return; // STOP here. Do not save.
    }

    // --- 5. SAVE CHANGES ---
    selectedUser.setPassword(newPwd);
    um.saveUsers("users.txt");

    JOptionPane.showMessageDialog(this, "Password updated successfully!");

    // --- 6. CLEAN UP UI ---
    newPassword.setText("");
    txtConfirmPassword.setText(""); 
    txtUsername.setText(""); 
    txtUsername.setEditable(true);
    selectedUser = null;
    }//GEN-LAST:event_changePasswordActionPerformed

    private void newPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordActionPerformed

    private void btnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnButtonActionPerformed
        this.dispose();
        new AcademicOfficerMenu(um, currentUser).setVisible(true);
    }//GEN-LAST:event_btnButtonActionPerformed

    private void txtConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnButton;
    private javax.swing.JButton changePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JButton selectUser;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
