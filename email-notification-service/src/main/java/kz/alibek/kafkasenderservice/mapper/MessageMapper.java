package kz.alibek.kafkasenderservice.mapper;

import kz.alibek.kafkasenderservice.model.Message;
import kz.alibek.kafkasenderservice.model.dto.SentMessageDto;

public class MessageMapper {

    public static SentMessageDto toSentMessageDto(Message message) {
        SentMessageDto dto = new SentMessageDto();
        dto.setSender(message.getSender());
        dto.setContent(message.getContent());
        dto.setResponseCode(message.getResponseCode());
        return dto;
    }
}