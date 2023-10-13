package helper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailSMTP {
    public static void sendOTP(String recipient, String username, String otp) throws MessagingException {
        String email = "qlkmt1@gmail.com";
        String password = "xzefxrajyvnoyifk";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Yêu cầu thay đổi mật khẩu");
            message.setText("Xin chào " + username + ",\n"
                    + "\n"
                    + "Ai đó đã yêu cầu đặt lại mật khẩu cho tài khoản của bạn, nếu đây không phải là bạn, vui lòng bỏ qua email này.\n"
                    + "\n"
                    + "Hãy sử dụng mã xác nhận này để khôi phục mật khẩu của bạn: " + otp
                    + "\n\n"
                    + "Vui lòng không chia sẻ mã xác nhận này cho bất kỳ ai.\n"
                    + "\n"
                    + "Trân trọng,\n"
                    + "Phần mềm quản lý kho máy tính\n");
            Transport.send(message);
        } catch (MessagingException e) {
            throw e;
        }
    }
}
