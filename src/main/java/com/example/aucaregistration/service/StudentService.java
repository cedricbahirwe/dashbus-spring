package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.Student;
import com.example.aucaregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String saveStudent(Student student) {
        List<Student> existingStudents = studentRepository.findByFullName(student.getFullName());
        if (existingStudents.isEmpty()) {
            studentRepository.save(student);
            return "Student saved successfully";
        } else {
            return "Student already exists";
        }
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
