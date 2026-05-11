package com.mycompany.crsjava;

import javax.swing.*;
import java.awt.*;

public class ManageUsers extends JFrame {

    private final UserManager um;
    private final User currentUser;

    private JTextField txtUsername;
    private JTextField txtNewUsername;
    private JComboBox<String> RoleCombo;
    private JButton save, exit, clear, searchUser;

    public ManageUsers(UserManager um, User currentUser) {
        this.um = um;
        this.currentUser = currentUser;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Manage Users");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        getContentPane().add(mainPanel);

        // Title
        JLabel titleLabel = new JLabel("Edit User", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        mainPanel.add(formPanel, BorderLayout.CENTER);

        txtUsername = new JTextField(15);
        txtNewUsername = new JTextField(15);
        RoleCombo = new JComboBox<>(new String[]{"CourseAdmin", "AcademicOfficer"});

        searchUser = new JButton("Search");
        save = new JButton("Save");
        exit = new JButton("Exit");
        clear = new JButton("Clear Fields");

        // Username panel
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(new JLabel("Username:"));
        usernamePanel.add(txtUsername);
        usernamePanel.add(searchUser);
        formPanel.add(usernamePanel);

        // New username panel
        JPanel newUsernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newUsernamePanel.add(new JLabel("New Username:"));
        newUsernamePanel.add(txtNewUsername);
        formPanel.add(newUsernamePanel);

        // Role panel
        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rolePanel.add(new JLabel("Role:"));
        rolePanel.add(RoleCombo);
        formPanel.add(rolePanel);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(save);
        buttonPanel.add(exit);
        buttonPanel.add(clear);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Event listeners
        searchUser.addActionListener(e -> searchUserAction());
        save.addActionListener(e -> saveAction());
        exit.addActionListener(e -> exitAction());
        clear.addActionListener(e -> clearAction());
    }

    private void searchUserAction() {
        // TODO: Copy your original searchUserActionPerformed logic here
    }

    private void saveAction() {
        // TODO: Copy your original saveActionPerformed logic here
    }

    private void exitAction() {
        this.dispose();
        currentUser.showMenu(um);
    }

    private void clearAction() {
        txtUsername.setText("");
        txtUsername.setEditable(true);
        txtNewUsername.setText("");
        RoleCombo.setSelectedIndex(0);
    }
}