package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.AcademicUnit;
import com.example.aucaregistration.domain.Semester;
import com.example.aucaregistration.domain.StudentRegistration;
import com.example.aucaregistration.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentRegistrationService {

    private final StudentRegistrationRepository studentRegistrationRepository;

    @Autowired
    public StudentRegistrationService(StudentRegistrationRepository studentRegistrationRepository) {
        this.studentRegistrationRepository = studentRegistrationRepository;
    }

    public StudentRegistration saveStudentRegistration(StudentRegistration studentRegistration) throws Exception {
        if (studentRegistration != null) {
            return studentRegistrationRepository.save(studentRegistration);
        } else {
            throw new Exception("Unable to save Student Registration");
        }
    }


    public List<StudentRegistration> getStudentRegistrations() {
        return studentRegistrationRepository.findAll();
    }

    public void deleteStudentRegistration(Long studentRegistrationId) throws Exception {
        if (studentRegistrationRepository.findById(studentRegistrationId).isPresent()) {
            studentRegistrationRepository.deleteById(studentRegistrationId);
        } else {
            throw new Exception("") ;
        }
    }

    public List<StudentRegistration> getStudentBySemesterAndDepartment(Semester semester, AcademicUnit unit) {
        return studentRegistrationRepository.getStudentBySemesterAndUnit(semester, unit);
    }
    public List<StudentRegistration> getStudentBySemester(Semester semester) {
        return studentRegistrationRepository.getStudentBySemester(semester);
    }

    public List<StudentRegistration> getStudentByUnit(AcademicUnit unit) {
        return studentRegistrationRepository.getStudentByUnit(unit);
    }
}

