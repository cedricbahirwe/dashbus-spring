package com.example.aucaregistration.domain;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String firstName;

    String lastName;

    LocalDate dob;

    String phoneNumber;

    String email;

}
