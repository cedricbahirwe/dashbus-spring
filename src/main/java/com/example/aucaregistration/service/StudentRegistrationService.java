package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.StudentRegistration;
import com.example.aucaregistration.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationService {

    private final StudentRegistrationRepository studentRegistrationRepository;

    @Autowired
    public StudentRegistrationService(StudentRegistrationRepository studentRegistrationRepository) {
        this.studentRegistrationRepository = studentRegistrationRepository;
    }

    public boolean saveStudentRegistration(StudentRegistration studentRegistration) {
        if (studentRegistration != null) {
            studentRegistrationRepository.save(studentRegistration);
            return true;
        } else {
            return false;
        }
    }


    public List<StudentRegistration> getStudentRegistrations() {
        return studentRegistrationRepository.findAll();
    }

    public boolean deleteStudentRegistration(int studentRegistrationId) {
        if (studentRegistrationRepository.findById(studentRegistrationId).isPresent()) {
            studentRegistrationRepository.deleteById(studentRegistrationId);
            return true;
        } else {
            return false;
        }
    }
}

