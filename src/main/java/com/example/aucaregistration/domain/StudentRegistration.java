package com.example.aucaregistration.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="student_registration_table")
public class StudentRegistration {
    @Id
    private UUID id;
    private LocalDate registrationDate;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "unitId")
    private AcademicUnit unit;
    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;

    public StudentRegistration() {
    }

    public StudentRegistration(UUID id, LocalDate registrationDate, Student student, AcademicUnit unit, Semester semester) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.student = student;
        this.unit = unit;
        this.semester = semester;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AcademicUnit getUnit() {
        return unit;
    }

    public void setUnit(AcademicUnit unit) {
        this.unit = unit;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}