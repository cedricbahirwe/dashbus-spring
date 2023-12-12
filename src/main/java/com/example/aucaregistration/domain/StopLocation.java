package com.example.aucaregistration.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "locations")
public class StopLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public void setSlang(String slang) {
        this.slang = slang;
    }


}
