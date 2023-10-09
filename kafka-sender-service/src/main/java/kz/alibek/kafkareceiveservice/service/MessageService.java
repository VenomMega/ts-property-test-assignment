package kz.alibek.kafkareceiveservice.service;

import kz.alibek.kafkareceiveservice.model.Message;
import kz.alibek.kafkareceiveservice.model.dto.MessageDto;
import kz.alibek.kafkareceiveservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final KafkaTemplate<String, MessageDto> kafkaTemplate;

    public void sendMessageToKafka(MessageDto message) {
        kafkaTemplate.send("message.send", message);
    }

    public List<Message> getLast10Messages() {
        return messageRepository.findTop10ByOrderByCreatedAtDesc();
    }

    public List<Message> getMessagesBySender(String sender) {
        return messageRepository.findBySender(sender);
    }
}
