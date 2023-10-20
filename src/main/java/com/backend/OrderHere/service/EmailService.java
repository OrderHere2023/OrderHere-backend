package com.backend.OrderHere.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    public void sendEmailWithToken(String recipientEmail, String token) throws MessagingException {
        // gmail service setting
        String host = "smtp.gmail.com";
        String port = "587";
//        String port = "465";
        String username = "orderhereemailservice@gmail.com";
        String password = "Orderhere123";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // create message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject("New Password");
        message.setText("Your new password token：" + token);

        // send email
        Transport.send(message);
    }
}
