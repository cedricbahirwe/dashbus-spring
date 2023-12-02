package com.example.aucaregistration.domain;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class BusTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int numberOfPlaces;

    double price;

    String origin;
    String destination;

    LocalDate departureDateTime;

    LocalDate arrivalDateTime;

}
