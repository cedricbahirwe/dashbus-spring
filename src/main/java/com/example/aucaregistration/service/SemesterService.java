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

    public Semester saveSemester(Semester semester) throws Exception {
        if (semester != null) {
            return semesterRepository.save(semester);
        } else {
            throw new Exception("Unable to save semester");
        }
    }

    public List<Semester> getSemesters() {
        return semesterRepository.findAll();
    }

    public boolean deleteSemester(Long semesterId) {
        if (semesterRepository.findById(semesterId).isPresent()) {
            semesterRepository.deleteById(semesterId);
            return true;
        } else {
            return false;
        }
    }
}
