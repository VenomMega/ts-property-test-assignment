package kz.alibek.kafkasenderservice.controller;

import kz.alibek.kafkasenderservice.model.dto.SentMessageDto;
import kz.alibek.kafkasenderservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {


    private final MessageService messageService;

    @GetMapping("/sent")
    public List<SentMessageDto> getSentMessages() {
        return messageService.getSentMessages();
    }
}
