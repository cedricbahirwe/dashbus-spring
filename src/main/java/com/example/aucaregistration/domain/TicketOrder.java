package com.example.aucaregistration.domain;


import jakarta.persistence.*;
import lombok.Getter;

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
    Client client;

    PaymentMethod paymentType;

    int numberOfTickets;// Can i Provide default value

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
}
