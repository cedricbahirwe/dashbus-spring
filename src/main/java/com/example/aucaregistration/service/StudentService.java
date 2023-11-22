package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.Student;
import com.example.aucaregistration.domain.StudentRegistration;
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

    public Student saveStudent(Student student) throws Exception {
        List<Student> existingStudents = studentRepository.findByFullName(student.getFullName());
        if (existingStudents.isEmpty()) {
            return studentRepository.save(student);
        } else {
            throw new Exception("Student already exists");
        }
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
