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

    public boolean saveAcademicUnit(AcademicUnit academicUnit) {
        if (academicUnit!= null) {
            academicUnitRepository.save(academicUnit);
            return true;
        } else {
            return false;
        }
    }

    public List<AcademicUnit> getAcademicUnits() {
        return academicUnitRepository.findAll();
    }
}
