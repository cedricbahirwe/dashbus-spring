package com.example.aucaregistration.domain;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int defaultPlaces;

    int remainingPlaces;

    double price;

    @OneToOne
    @JoinColumn(name = "originId")
    StopLocation origin;
    @OneToOne
    @JoinColumn(name = "destinationId")
    StopLocation destination;
    LocalDate departureDateTime;
    LocalDate arrivalDateTime;

    public Ticket() {
    }

    public Ticket(int defaultPlaces, int remainingPlaces, double price, StopLocation origin, StopLocation destination, LocalDate departureDateTime, LocalDate arrivalDateTime) {
        this.defaultPlaces = defaultPlaces;
        this.remainingPlaces = remainingPlaces;
        this.price = price;
        this.origin = origin;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }
}
