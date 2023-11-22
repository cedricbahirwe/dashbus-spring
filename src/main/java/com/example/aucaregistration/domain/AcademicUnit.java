package com.example.aucaregistration.domain;

import jakarta.persistence.*;

@Entity
@Table(name="academic_unit_table")
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private EAcademicUnit unit;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private AcademicUnit parent;

    public AcademicUnit() {
    }

    public AcademicUnit(String code, String name, EAcademicUnit unit, AcademicUnit parent) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EAcademicUnit getUnit() {
        return unit;
    }

    public void setUnit(EAcademicUnit unit) {
        this.unit = unit;
    }

    public AcademicUnit getParent() {
        return parent;
    }

    public void setParent(AcademicUnit parent) {
        this.parent = parent;
    }
}