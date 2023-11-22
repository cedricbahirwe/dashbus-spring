package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.StudentCourse;
import com.example.aucaregistration.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    public Boolean saveStudentCourse(StudentCourse studentCourse) {
        if (studentCourse != null) {
            studentCourseRepository.save(studentCourse);
            return true;
        } else {
            return false;
        }
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourseRepository.findAll();
    }

    public boolean deleteStudentCourse(Integer studentCourseId) {
        if (studentCourseRepository.findById(studentCourseId).isPresent()) {
            studentCourseRepository.deleteById(studentCourseId);
            return true;
        } else {
            return false;
        }
    }
}
