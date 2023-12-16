package com.example.aucaregistration.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String sendNames;

    String senderEmail;

    String messageBody;


    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    LocalDateTime creationDate;

    public Message() {
    }

    public Message(String sendNames, String senderEmail, String messageBody, LocalDateTime creationDate) {
        this.sendNames = sendNames;
        this.senderEmail = senderEmail;
        this.messageBody = messageBody;
        this.creationDate = creationDate;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setSendNames(String sendNames) {
        this.sendNames = sendNames;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
