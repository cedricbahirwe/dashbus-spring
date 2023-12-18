package com.example.aucaregistration.domain;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int defaultPlaces;

    int remainingPlaces;

    double price;

    @ManyToOne
    @JoinColumn(name = "adminId")
    Admin admin;

    @OneToOne
    @JoinColumn(name = "originId")
    StopLocation origin;

    @OneToOne
    @JoinColumn(name = "destinationId")
    StopLocation destination;

    LocalDateTime departureDateTime;

    LocalDateTime arrivalDateTime;

    LocalDateTime createdDateTime = LocalDateTime.now();

    Double discount = 0.0;

    public Ticket() {
    }

    public Ticket(int defaultPlaces, int remainingPlaces, double price, Admin admin, StopLocation origin, StopLocation destination, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, LocalDateTime createdDateTime, Double discount) {
        this.defaultPlaces = defaultPlaces;
        this.remainingPlaces = remainingPlaces;
        this.price = price;
        this.admin = admin;
        this.origin = origin;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.createdDateTime = createdDateTime;
        this.discount = discount;
    }

    public void setDefaultPlaces(int defaultPlaces) {
        this.defaultPlaces = defaultPlaces;
    }

    public void setRemainingPlaces(int remainingPlaces) {
        this.remainingPlaces = remainingPlaces;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setOrigin(StopLocation origin) {
        this.origin = origin;
    }

    public void setDestination(StopLocation destination) {
        this.destination = destination;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
