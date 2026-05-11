package com.mycompany.crsjava;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import java.io.File;

public class EmailService {

    private final String senderEmail = "huiyitew05@gmail.com";
    private final String senderPassword = "qbzi uhxp rjbb sncx";

    private Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
    }

    // ===== Send Academic Report with PDF attachment =====
    public void sendReport(String recipient, String studentName, File pdfReport) {
        try {
            Message msg = new MimeMessage(getSession());
            msg.setFrom(new InternetAddress(senderEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            msg.setSubject("Your Academic Performance Report");

            // email text
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Dear " + studentName + ",\n\nYour academic report is attached.\n\nRegards,\nCRS System");

            // pdf attachment
            MimeBodyPart pdfPart = new MimeBodyPart();
            pdfPart.attachFile(pdfReport);

            // combine parts
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(textPart);
            mp.addBodyPart(pdfPart);

            msg.setContent(mp);

            Transport.send(msg);
            System.out.println("Email sent to " + recipient);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
