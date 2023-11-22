package com.example.aucaregistration.domain;

import jakarta.persistence.*;

@Entity
@Table(name="course_table")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;
    @OneToOne
    @JoinColumn(name = "definitionId")
    private CourseDefinition courseDefinition;
    @ManyToOne
    @JoinColumn(name = "unitId")
    private AcademicUnit unit;

    public Course() {
    }

    public Course(Semester semester, Teacher teacher, CourseDefinition courseDefinition, AcademicUnit unit) {
        this.semester = semester;
        this.teacher = teacher;
        this.courseDefinition = courseDefinition;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public CourseDefinition getCourseDefinition() {
        return courseDefinition;
    }

    public void setCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinition = courseDefinition;
    }

    public AcademicUnit getUnit() {
        return unit;
    }

    public void setUnit(AcademicUnit unit) {
        this.unit = unit;
    }
}