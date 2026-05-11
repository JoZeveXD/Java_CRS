package com.mycompany.crsjava;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserStatus extends JFrame {

    private final UserManager um;
    private final User currentUser;

    public UserStatus(UserManager um, User currentUser) {
        this.um = um;
        this.currentUser = currentUser;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("User Status");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        getContentPane().add(mainPanel);

        // Title
        JLabel title = new JLabel("User Status", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mainPanel.add(title, BorderLayout.NORTH);

        // Table to display users
        String[] columnNames = {"Username", "Role", "Status", "Last Login", "Last Logout"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Fill table with users
        for (User u : um.getUsers()) {
            Object[] row = {u.getUsername(), u.getRole(), u.isActive() ? "Active" : "Inactive", u.getLastLogin(), u.getLastLogout()};
            tableModel.addRow(row);
        }

        JTable userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Close button
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> this.dispose());

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(closeBtn);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }
}
