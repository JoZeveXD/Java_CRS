package com.mycompany.crsjava;

import java.util.ArrayList;
import java.io.*;

public class UserManager {

    private final ArrayList<User> users = new ArrayList<>();

    // --------------------------
    // LOAD USERS
    // --------------------------
    public void loadUsers(String filePath) {
        users.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            
            String line = br.readLine(); // skip header
            
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // skip empty line

                String[] data = line.split(",");

                // Must have 6 columns
                if (data.length < 6) {
                    System.out.println("Invalid line (ignored): " + line);
                    continue;
                }

                String username = data[0];
                String password = data[1];
                String role = data[2];
                boolean active = data[3].equalsIgnoreCase("active");

                String lastLogin = data[4];
                String lastLogout = data[5];

                User u;

                if (role.equalsIgnoreCase("AcademicOfficer")) {
                    u = new AcademicOfficer(username, password, role, active);
                } 
                else if (role.equalsIgnoreCase("CourseAdmin")) {
                    u = new CourseAdmin(username, password, role, active);
                } 
                else {
                    System.out.println("Unknown role detected (ignored): " + line);
                    continue;
                }

                // Assign login/logout tracking
                u.setLastLogin(lastLogin);
                u.setLastLogout(lastLogout);

                users.add(u);
            }

        } catch (IOException e) {
            System.out.println("Error loading users file: " + e.getMessage());
        }
    }

    // --------------------------
    // LOGIN
    // --------------------------
    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)
                    && u.getPassword().equals(password)
                    && u.isActive()) {

                u.setLastLogin(String.valueOf(System.currentTimeMillis()));
                saveUsers("users.txt");
                return u;
            }
        }
        return null;
    }

    // --------------------------
    // SAVE USERS
    // --------------------------
    public void saveUsers(String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {

            // Corrected header
            pw.println("username,password,role,status,lastLogin,lastLogout");

            for (User u : users) {
                pw.println(u.toString());
            }

        } catch (IOException e) {
            System.out.println("Error saving users file: " + e.getMessage());
        }
    }

    // --------------------------
    // ADD USER (prevent duplicates)
    // --------------------------
    public boolean addUser(User u) {
        if (findUserByUsername(u.getUsername()) != null) {
            return false; // duplicate username
        }
        users.add(u);
        return true;
    }

    // --------------------------
    // UPDATE USER
    // --------------------------
    public void updateUser(String username, String newPassword,
                           String newRole, boolean newActive) {

        for (User u : users) {
            if (u.getUsername().equals(username)) {
                u.setPassword(newPassword);
                u.setRole(newRole);
                u.setActive(newActive);
            }
        }
    }

    // --------------------------
    // DEACTIVATE USER
    // --------------------------
    public void deactivateUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                u.setActive(false);
            }
        }
    }

    // --------------------------
    // GETTER METHODS
    // --------------------------
    public ArrayList<User> getUsers() {
        return users;
    }

    public User findUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
