package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.AcademicUnit;
import com.example.aucaregistration.domain.Semester;
import com.example.aucaregistration.domain.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {
    public List<StudentRegistration> getStudentBySemester(Semester semester);

    public List<StudentRegistration> getStudentBySemesterAndUnit(Semester semester, AcademicUnit unit);

    public List<StudentRegistration> getStudentByUnit(AcademicUnit unit);

}
