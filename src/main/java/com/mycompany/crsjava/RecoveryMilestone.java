package com.mycompany.crsjava;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author huiyitew
 */
public class RecoveryMilestone {
    private String week;
    private String task;
    private String status;

    public RecoveryMilestone(String week, String task) {
        this.week = week;
        this.task = task;
        this.status = "Pending";
    }

    public String getWeek() { return week; }
    public String getTask() { return task; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}