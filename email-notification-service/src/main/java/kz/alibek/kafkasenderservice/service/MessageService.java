package kz.alibek.kafkasenderservice.service;

import kz.alibek.kafkasenderservice.mapper.MessageMapper;
import kz.alibek.kafkasenderservice.model.Message;
import kz.alibek.kafkasenderservice.model.dto.MessageDto;
import kz.alibek.kafkasenderservice.model.dto.SentMessageDto;
import kz.alibek.kafkasenderservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Message saveMessage(MessageDto messageDto, String responseCode) {
        Message message = Message.builder()
                .sender(messageDto.getSender())
                .content(messageDto.getContent())
                .responseCode(responseCode)
                .build();

        return messageRepository.save(message);
    }

    public List<SentMessageDto> getSentMessages() {
        return messageRepository.findAll()
                .stream()
                .map(MessageMapper::toSentMessageDto)
                .collect(Collectors.toList());
    }

}
