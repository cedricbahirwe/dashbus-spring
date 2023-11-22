package com.example.aucaregistration.service;


import com.example.aucaregistration.domain.AcademicUnit;
import com.example.aucaregistration.repository.AcademicUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AcademicUnitService {

    private final AcademicUnitRepository academicUnitRepository;

    @Autowired
    public AcademicUnitService(AcademicUnitRepository academicUnitRepository) {
        this.academicUnitRepository = academicUnitRepository;
    }

    public String saveAcademicUnit(AcademicUnit academicUnit) {
        if (academicUnit!= null) {
            academicUnitRepository.save(academicUnit);
            return "AcademicUnit saved successfully";
        } else {
            return null;
        }
    }

    public List<AcademicUnit> getAllAcademicUnits() {
        return academicUnitRepository.findAll();
    }
}
