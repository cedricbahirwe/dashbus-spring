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

}
