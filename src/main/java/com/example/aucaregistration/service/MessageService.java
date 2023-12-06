package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.Message;
import com.example.aucaregistration.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) throws Exception {
        if (message != null) {
            return messageRepository.save(message);
        } else {
            throw new Exception("Unable to save Message");
        }
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void deleteMessage(Long messageId) throws Exception {
        if (messageRepository.findById(messageId).isPresent()) {
            messageRepository.deleteById(messageId);
        } else {
            throw new Exception("Message not found");
        }
    }
}
