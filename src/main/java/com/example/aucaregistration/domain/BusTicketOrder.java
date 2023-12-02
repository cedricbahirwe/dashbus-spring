package com.example.aucaregistration.domain;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ticket_orders")
public class BusTicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    @JoinColumn(name = "ticketId")
    BusTicket ticket;

    @OneToOne
    @JoinColumn(name = "clientId")
    BusClient client;
}
