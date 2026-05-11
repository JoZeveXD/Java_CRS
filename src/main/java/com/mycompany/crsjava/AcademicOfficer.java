package com.mycompany.crsjava;

public class AcademicOfficer extends User {

    public AcademicOfficer(String username, String password, String role, boolean active) {
        super(username, password, role, active);
    }

    @Override
    public void showMenu(UserManager um) {
        new AcademicOfficerMenu(um,this).setVisible(true);
    }
}

