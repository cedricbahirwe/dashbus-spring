package com.example.aucaregistration.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="student_course_table")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer credits;
    private String results;
    @ManyToOne
    @JoinColumn(name = "stRegId")
    private StudentRegistration studentRegistration;
    @OneToOne
    @JoinColumn(name = "courseId")
    private Course course;

    public StudentCourse() {
    }

    public StudentCourse(Integer credits, String results, StudentRegistration studentRegistration, Course course) {
        this.credits = credits;
        this.results = results;
        this.studentRegistration = studentRegistration;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public StudentRegistration getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentRegistration studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
