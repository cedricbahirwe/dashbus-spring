package com.example.aucaregistration.controller;

import com.example.aucaregistration.domain.Message;
import com.example.aucaregistration.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/message",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveMessage(@RequestBody Message message) {
        if (message != null) {
            try {
                Message savedMessage = messageService.saveMessage(message);
                return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Message>> getMessages() {
        List<Message> messages = messageService.getMessages();
        return ResponseEntity.ok(messages);
    }

    @DeleteMapping(value = "/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long messageId) {
        try {
            messageService.deleteMessage(messageId);
            return new ResponseEntity<>("Message Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}