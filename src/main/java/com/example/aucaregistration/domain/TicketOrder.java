package com.example.aucaregistration.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "ticket_orders")
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    @JoinColumn(name = "ticketId")
    Ticket ticket;

    @OneToOne
    @JoinColumn(name = "clientId")
    Client client;

    PaymentMethod paymentType;

    int numberOfTickets;

    String qrCodeId;

    public TicketOrder() {
    }

    public TicketOrder(Ticket ticket, Client client, PaymentMethod paymentType, int numberOfTickets, String qrCodeId) {
        this.ticket = ticket;
        this.client = client;
        this.paymentType = paymentType;
        this.numberOfTickets = numberOfTickets;
        this.qrCodeId = qrCodeId;
    }
}
