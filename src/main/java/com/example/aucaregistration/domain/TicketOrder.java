package com.example.aucaregistration.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "ticket_orders")
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "ticketId")
    Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonBackReference
    Client client;

    PaymentMethod paymentType;

    int numberOfTickets;

    String qrCodeId;

    LocalDateTime dateTime = LocalDateTime.now();

    public TicketOrder() {
    }

    public TicketOrder(Ticket ticket, Client client, PaymentMethod paymentType, int numberOfTickets, String qrCodeId, LocalDateTime dateTime) {
        this.ticket = ticket;
        this.client = client;
        this.paymentType = paymentType;
        this.numberOfTickets = numberOfTickets;
        this.qrCodeId = qrCodeId;
        this.dateTime = dateTime;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPaymentType(PaymentMethod paymentType) {
        this.paymentType = paymentType;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
