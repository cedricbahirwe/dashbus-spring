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

    public AcademicUnit saveAcademicUnit(AcademicUnit academicUnit) throws Exception {
        if (academicUnit!= null) {
            return academicUnitRepository.save(academicUnit);
        } else {
            throw new Exception("Unable to save academic unit");
        }
    }

    public List<AcademicUnit> getAcademicUnits() {
        return academicUnitRepository.findAll();
    }
}
