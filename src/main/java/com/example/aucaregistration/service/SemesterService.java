package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.Semester;
import com.example.aucaregistration.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {
    private final SemesterRepository semesterRepository;

    @Autowired
    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public Boolean saveSemester(Semester semester) {
        if (semester != null) {
            semesterRepository.save(semester);
            return true;
        } else {
            return false;
        }
    }

    public List<Semester> getSemesters() {
        return semesterRepository.findAll();
    }

    public boolean deleteSemester(Integer semesterId) {
        if (semesterRepository.findById(semesterId).isPresent()) {
            semesterRepository.deleteById(semesterId);
            return true;
        } else {
            return false;
        }
    }
}
