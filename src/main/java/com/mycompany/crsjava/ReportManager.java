package com.mycompany.crsjava;

import java.io.File;
import java.util.List;

/**
 * ReportManager
 * - generateAndSend(student, sem, year): create PDF + send email for single student
 * - sendReportsToAll(sem, year): load students and send for each student
 */
public class ReportManager {
    private final EmailService emailService;
    private final ReportGen reportGen;

    public ReportManager() {
        this.emailService = new EmailService();
        this.reportGen = new ReportGen();
    }

    /**
     * Generate PDF and send to one student.
     * Returns true when both PDF creation and sending succeed (best-effort).
     */
    public boolean generateAndSend(Student student, int sem, int year) {
        if (student == null) return false;
        String filename = student.getId() + "_Report_" + sem + "_" + year + ".pdf";

        boolean created = reportGen.createReport(student, sem, year, filename);
        if (!created) {
            System.out.println("Failed to create PDF: " + filename);
            return false;
        }

        String email = student.getEmail();
        if (email == null || email.isBlank()) {
            System.out.println("No email for student " + student.getId());
            return false;
        }

        try {
            emailService.sendReport(email, student.getName(), new File(filename));
            System.out.println("Sent report to: " + email);
            return true;
        } catch (Exception e) {
            System.out.println("Error sending to " + email + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Generate & send reports to all students loaded from FileManager.
     * This method attempts to continue on errors (best-effort).
     */
    public void sendReportsToAll(int sem, int year) {
        List<Student> allStudents = FileManager.loadAllData();
        if (allStudents == null || allStudents.isEmpty()) {
            System.out.println("No students loaded. Check student_information.csv");
            return;
        }

        int success = 0;
        int total = allStudents.size();

        for (Student s : allStudents) {
            boolean ok = generateAndSend(s, sem, year);
            if (ok) success++;
        }

        System.out.println("Finished sending. Success: " + success + " / " + total);
    }
}
