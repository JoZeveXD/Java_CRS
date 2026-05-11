package com.mycompany.crsjava;

public class CourseAdmin extends User {

    public CourseAdmin(String username, String password, String role, boolean active) {
        super(username, password, role, active);
    }

    @Override
    public void showMenu(UserManager um) {
        new CourseAdminMenu(um,this).setVisible(true);
    }
}

