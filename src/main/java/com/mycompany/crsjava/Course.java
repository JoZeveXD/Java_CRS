/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crsjava;
/**
 *
 * @author choks
 */
public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade;
    private int semester;
    private int year;
    private double points;

    public Course(String code, String name, int credits, String grade, int semester, int year) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
        this.semester = semester;
        this.year = year;
        calcPoints();
    }

    private void calcPoints() {
        switch(grade.toUpperCase()) {
            case "A": points = 4.0; break;
            case "A-": points = 3.7; break;
            case "B+": points = 3.3; break;
            case "B": points = 3.0; break;
            case "B-": points = 2.7; break;
            case "C+": points = 2.3; break;
            case "C": points = 2.0; break;
            case "D": points = 1.0; break;
            default: points = 0.0; // F
        }
    }
    
    public double getTotalPoints() { 
        return points * credits; 
    }
    public int getCredits() { 
        return credits; 
    }
    public int getSemester() { 
        return semester; 
    }
    public int getYear() { 
        return year; 
    }
    public String getCode() { 
        return code; 
    }
    public String getLetterGrade() { 
        return grade; 
    }
    public String getInfo() { 
        return code + " | " + name + " | " + grade; 
    }
    public String getName() {
        return name;
    }
    

    public boolean isFailed() {
        return points < 2.0; 
    }
}
