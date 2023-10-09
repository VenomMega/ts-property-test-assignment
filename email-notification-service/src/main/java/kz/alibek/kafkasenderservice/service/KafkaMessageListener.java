package kz.alibek.kafkasenderservice.service;

import kz.alibek.kafkasenderservice.model.dto.MessageDto;
import kz.alibek.kafkasenderservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessageListener {
    private final EmailService emailService;
    private final MessageService messageService;

    @KafkaListener(topics = "message.send", groupId = "test-group-id")
    public void consume(MessageDto messageDto) {
        String responseCode = sendAndRetrieveResponseCode(messageDto);
        messageService.saveMessage(messageDto, responseCode);
    }

    private String sendAndRetrieveResponseCode(MessageDto messageDto) {
        try {
            emailService.sendEmail(messageDto);
            return "200";
        } catch (MailException e) {
            return "500";
        }
    }

}
