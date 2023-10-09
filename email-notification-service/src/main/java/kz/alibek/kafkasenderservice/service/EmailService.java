package kz.alibek.kafkasenderservice.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kz.alibek.kafkasenderservice.model.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final Logger log = LogManager.getLogger();

    private final JavaMailSender emailSender;

    @Value("${email.recipient}")
    private String recipientEmail;

    @Value("${email.sender}")
    private String senderEmail;

    public void sendEmail(MessageDto message) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {
            helper.setText(message.getContent(), true);
            helper.setTo(recipientEmail);
            helper.setSubject("Новое сообщение от " + message.getSender());
            helper.setFrom(senderEmail);

            emailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Error occurred while sending the email: {}", e.getMessage());
        }
    }
}
