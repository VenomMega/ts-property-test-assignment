package kz.alibek.kafkasenderservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SentMessageDto {
    private String sender;
    private String content;
    private String responseCode;
}
