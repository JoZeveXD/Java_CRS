package com.mycompany.crsjava;

public abstract class User {
    protected String username;
    protected String password;
    protected String role;
    protected boolean active;
    protected String lastLogin;
    protected String lastLogout;

    public User(String username, String password, String role, boolean active) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
        this.lastLogin = "-";
        this.lastLogout = "-";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public String getLastLogin(){
        return lastLogin;
    }
    
    public void setLastLogin(String lastLogin){
        this.lastLogin = lastLogin;
    }
    
    public String getLastLogout(){
        return lastLogout;
    }
    
    public void setLastLogout(String lastLogout){
        this.lastLogout = lastLogout;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + role + "," + (active? "active":"inactive") + "," + lastLogin + "," + lastLogout;
    }

    public void showMenu(UserManager um) {
    }
}
