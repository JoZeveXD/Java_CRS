package com.mycompany.crsjava;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;
/**
 *
 * @author huiyitew
 */
public class ReportGen {
    private static final Font FONT_TITLE = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    private static final Font FONT_HEADER = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    private static final Font FONT_NORMAL = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
    
    public boolean createReport(Student s, int sem, int year, String filename) {
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(filename));
            doc.open();

            doc.add(new Paragraph("ACADEMIC PERFORMANCE REPORT", FONT_TITLE));
            doc.add(new Paragraph(" ")); // Empty line
            doc.add(new Paragraph("Name: " + s.getName(), FONT_NORMAL));
            doc.add(new Paragraph("ID:   " + s.getId(), FONT_NORMAL));
            doc.add(new Paragraph("Session: " + getSemesterName(sem) + " " + year, FONT_NORMAL));
            doc.add(new Paragraph(" ")); // Empty line

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100); 
            table.setWidths(new float[] { 2f, 6f, 2f, 2f }); 

            addHeaderCell(table, "CODE");
            addHeaderCell(table, "COURSE NAME");
            addHeaderCell(table, "CREDITS");
            addHeaderCell(table, "GRADE");

            List<Course> courses = s.getFilteredCourses(sem, year);
            if (courses.isEmpty()) {
                PdfPCell cell = new PdfPCell(new Phrase("No records found for this semester.", FONT_NORMAL));
                cell.setColspan(4);
                cell.setPadding(10);
                table.addCell(cell);
            } else {
                for (Course c : courses) {
                    String cName = (c.getName() == null || c.getName().equals("Unknown")) ? "-" : c.getName();
                    
                    table.addCell(new Phrase(c.getCode(), FONT_NORMAL));
                    table.addCell(new Phrase(cName, FONT_NORMAL));
                    table.addCell(new Phrase(String.valueOf(c.getCredits()), FONT_NORMAL));
                    table.addCell(new Phrase(c.getLetterGrade(), FONT_NORMAL));
                }
            }
            doc.add(table);

            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("----------------------------------------------------------------------------------"));
            doc.add(new Paragraph(String.format("Current CGPA: %.2f", s.getCGPA()), FONT_HEADER));
            
            int failedCount = s.countFailedCourses();
            boolean isEligible = (s.getCGPA() >= 2.0 && failedCount <= 3);
            
            String statusText = isEligible ? "ELIGIBLE FOR PROGRESSION" : "NOT ELIGIBLE (See Academic Officer)";
            
            Font statusFont = isEligible ? FONT_NORMAL : new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.RED);
            
            doc.add(new Paragraph("Status: " + statusText, statusFont));

            doc.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Helper to make pretty header cells
    private void addHeaderCell(PdfPTable table, String text) {
        PdfPCell cell = new PdfPCell(new Phrase(text, FONT_HEADER));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(6);
        table.addCell(cell);
    }

    private String getSemesterName(int sem) {
        switch(sem) {
            case 1: return "Spring";
            case 2: return "Summer";
            case 3: return "Fall";
            default: return "Semester " + sem;
        }
    }
}
