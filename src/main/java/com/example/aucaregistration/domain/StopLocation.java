package com.example.aucaregistration.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class StopLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String abbrev;
    String slang;

    public StopLocation() {
    }

    public StopLocation(String name, String abbrev, String slang) {
        this.name = name;
        this.abbrev = abbrev;
        this.slang = slang;
    }


}
