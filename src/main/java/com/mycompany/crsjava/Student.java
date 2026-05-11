/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crsjava;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author huiyitew
 */
public class Student {
    private String id;
    private String name;
    private String email;
    private List<Course> courses;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course c) { courses.add(c); }
    public String getName() { return name; }
    public String getId() { return id; }
    public List<Course> getCourses() { return courses; }

    public double getCGPA() {
        double totalP = 0;
        int totalC = 0;
        for(Course c : courses) {
            totalP += c.getTotalPoints();
            totalC += c.getCredits();
        }
        return (totalC == 0) ? 0.0 : totalP / totalC;
    }

    public List<Course> getFilteredCourses(int sem, int year) {
        List<Course> list = new ArrayList<>();
        for(Course c : courses) {
            if(c.getSemester() == sem && c.getYear() == year) list.add(c);
        }
        return list;
    }

    public int countFailedCourses() {
        int count = 0;
        for(Course c : courses) {
            if (c.isFailed()) { // Uses the new method in Course.java
                count++;
            }
        }
        return count;
    }
    
    public List<Course> getFailedCourses() {
        List<Course> list = new ArrayList<>();
        for(Course c : courses) {
            if (c.isFailed()) list.add(c);
        }
        return list;
    }
    
    public String getEmail() { return email; 
    }
    
}


