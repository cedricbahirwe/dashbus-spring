package com.example.aucaregistration.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "reg_no")
    private String regNo;
    @Column(name = "full_name")
    private String fullName;
    private LocalDate dob;

    public Student() {
    }

    public Student(String regNo, String fullName, LocalDate dob) {
        this.regNo = regNo;
        this.fullName = fullName;
        this.dob = dob;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
