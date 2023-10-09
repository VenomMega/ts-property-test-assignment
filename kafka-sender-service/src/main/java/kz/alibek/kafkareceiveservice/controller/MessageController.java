package kz.alibek.kafkareceiveservice.controller;

import kz.alibek.kafkareceiveservice.model.Message;
import kz.alibek.kafkareceiveservice.model.dto.MessageDto;
import kz.alibek.kafkareceiveservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> receiveMessage(@RequestBody MessageDto message) {
        messageService.sendMessageToKafka(message);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Message> getMessages(@RequestParam(value = "sender", required = false) String sender) {
        if (sender != null && !sender.isEmpty()) {
            return messageService.getMessagesBySender(sender);
        } else {
            return messageService.getLast10Messages();
        }
    }

}
