package com.mycompany.crsjava;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author huiyitew
 */ 
public class FileManager {

    private static class CourseInfo {
        String name;
        int credits;
        public CourseInfo(String name, int credits) {
            this.name = name;
            this.credits = credits;
        }
    }

    public static List<Student> loadAllData() {
        Map<String, Student> studentMap = new HashMap<>();
        Map<String, CourseInfo> courseMap = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("student_information.csv"))) {
            String line; 
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    String id = data[0].trim();
                    String fullName = data[1].trim() + " " + data[2].trim();
                    String email = data[5].trim();

                    studentMap.put(id, new Student(id, fullName, email));
                }
            }
        } catch (Exception e) {}

        try (BufferedReader br = new BufferedReader(new FileReader("course_assessment_information.csv"))) {
            String line; br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    try {
                        courseMap.put(data[0].trim(), new CourseInfo(data[1].trim(), Integer.parseInt(data[2].trim())));
                    } catch (Exception e) {}
                }
            }
        } catch (Exception e) {}

        try (BufferedReader br = new BufferedReader(new FileReader("student_grades.csv"))) {
            String line; 
            br.readLine(); 
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 3) continue; 

                try {
                    String sID = data[0].trim();
                    String cID = data[1].trim();
                    String cName = "Unknown";
                    String grade = "F";
                    int sem = 1; 
                    int year = 2024;

                
                    boolean isNewFormat = (data.length >= 6) || (data[2].trim().length() > 3);

                    if (isNewFormat) {
                        cName = data[2].trim();
                        grade = data[3].trim();
                        sem = Integer.parseInt(data[4].trim());
                        year = Integer.parseInt(data[5].trim());
                    } else {
                        
                        grade = data[2].trim();
                        sem = Integer.parseInt(data[3].trim());
                        year = Integer.parseInt(data[4].trim());
                    }

                    CourseInfo info = courseMap.get(cID);
                    int credits = (info != null) ? info.credits : 3;
                    
                    if(cName.equals("Unknown") && info != null) cName = info.name;

                    Student s = studentMap.get(sID);
                    if (s != null) {
                        s.addCourse(new Course(cID, cName, credits, grade, sem, year));
                    }
                } catch (Exception e) { 
                    System.out.println("Error reading row: " + line);
                }
            }
        } catch (Exception e) { 
            System.out.println("File Error: " + e.getMessage()); 
        }

        return new ArrayList<>(studentMap.values());
    }

    public static void saveGrades(List<Student> allStudents) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("student_grades.csv"))) {
            pw.println("StudentID,CourseID,CourseName,Grade,Semester,Year");
            for (Student s : allStudents) {
                for (Course c : s.getCourses()) {
                    String safeName = (c.getName() == null) ? "Unknown" : c.getName();
                    pw.printf("%s,%s,%s,%s,%d,%d%n", s.getId(), c.getCode(), safeName, c.getLetterGrade(), c.getSemester(), c.getYear());
                }
            }
        } catch (Exception e) {}
    }

    public static void savePlan(RecoveryPlan plan) {
        String filename = "Plan_" + plan.getStudentID() + "_" + plan.getCourseID() + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println(plan.getRecommendation());
            pw.println("---MILESTONES---");
            for (RecoveryMilestone m : plan.getMilestones()) {
                pw.println(m.getWeek() + "|" + m.getTask() + "|" + m.getStatus());
            }
        } catch (IOException e) {}
    }

    public static RecoveryPlan loadPlan(String studentID, String courseID) {
        String filename = "Plan_" + studentID + "_" + courseID + ".txt";
        File f = new File(filename);
        if (!f.exists()) return null;

        RecoveryPlan plan = new RecoveryPlan(studentID, courseID);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String rec = br.readLine();
            if (rec != null) plan.setRecommendation(rec);
            String line;
            boolean readingMilestones = false;
            while ((line = br.readLine()) != null) {
                if (line.equals("---MILESTONES---")) { readingMilestones = true; continue; }
                if (readingMilestones) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 3) {
                        plan.addMilestone(parts[0], parts[1]);
                        plan.getMilestones().get(plan.getMilestones().size()-1).setStatus(parts[2]);
                    }
                }
            }
        } catch (IOException e) { return null; }
        return plan;
    }
}
