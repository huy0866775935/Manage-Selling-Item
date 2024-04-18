package Vertify;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    private final String MAIL = "namnhhe161918@fpt.edu.vn";
    private final String PASSWORD = "ngohuunam1102002";

    public void sentEmail(String toEmail, String subject, String text) {

        // Config
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);

        // Authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MAIL, PASSWORD);
            }
        });

        // Mail info
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            System.out.println("Message sent successfully...");

        } catch (MessagingException e) {
            System.out.println(e);
        }
    }

    public String createCaptcha() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int index
                    = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String toEmail = "ngohuunam2002@gmail.com";
        String subject = "Test javaMail API";
        String text = "Medical code : KK88MX46";
        new SendMail().sentEmail(toEmail, subject, text);
    }
}
