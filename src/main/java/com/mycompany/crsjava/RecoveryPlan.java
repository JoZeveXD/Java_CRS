package com.mycompany.crsjava;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author choks
 */
public class RecoveryPlan {
    private String studentID;
    private String courseID; 
    private String recommendation;
    private List<RecoveryMilestone> milestones;

    public RecoveryPlan(String studentID, String courseID) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.recommendation = "";
        this.milestones = new ArrayList<>();
    }

    public void addMilestone(String week, String task) {
        milestones.add(new RecoveryMilestone(week, task));
    }
    
    public void removeMilestone(int index) {
        if(index >= 0 && index < milestones.size()) {
            milestones.remove(index);
        }
    }

    
    public String getStudentID() { 
        return studentID; 
    }

    public String getCourseID() { 
        return courseID;  
    }

    public String getRecommendation() { 
        return recommendation; 
    }

    public void setRecommendation(String r) { 
        this.recommendation = r; 
    }

    public List<RecoveryMilestone> getMilestones() { 
        return milestones; 
    }
}
