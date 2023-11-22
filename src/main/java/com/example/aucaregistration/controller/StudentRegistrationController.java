package com.example.aucaregistration.controller;


import com.example.aucaregistration.domain.AcademicUnit;
import com.example.aucaregistration.domain.Semester;
import com.example.aucaregistration.domain.Student;
import com.example.aucaregistration.domain.StudentRegistration;
import com.example.aucaregistration.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        value = "/studentRegistrations",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class StudentRegistrationController {

    private final StudentRegistrationService studentRegistrationService;

    @Autowired
    public StudentRegistrationController(StudentRegistrationService studentRegistrationService) {
        this.studentRegistrationService = studentRegistrationService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveStudentRegistration(@RequestBody StudentRegistration studentRegistration) {
        if (studentRegistration != null) {
            try {
                StudentRegistration studentReg = studentRegistrationService.saveStudentRegistration(studentRegistration);
                return new ResponseEntity<>(studentReg, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (value = "/")
    public ResponseEntity<List<StudentRegistration>> getStudentRegistrations() {
        List<StudentRegistration> studentRegistrations = studentRegistrationService.getStudentRegistrations();
        return ResponseEntity.ok(studentRegistrations);
    }

    @GetMapping (value = "/list")
    public ResponseEntity<?> getFilteredStudents(
            @RequestParam(name = "semesterId", required = false) Long semesterId,
            @RequestParam(name = "departmentId", required = false) Long departmentId
    ) {

        if ((semesterId != null) && (departmentId != null)) {
            return getStudentBySemesterAndUnit(semesterId, departmentId);
        } else if (semesterId != null) {
            return getStudentsPerSemester(semesterId);
        } else if (departmentId != null) {
            return getStudentsPerDepartment(departmentId);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    private ResponseEntity<List<Student>> getStudentsPerSemester(Long semesterId) {
        Semester semester = new Semester();
        semester.setId(semesterId);

        List<StudentRegistration> studentRegistrations = studentRegistrationService.getStudentBySemester(semester);
        List<Student> students = studentRegistrations.stream()
                .map(StudentRegistration::getStudent)
                .toList();
        return ResponseEntity.ok(students);
    }

    private ResponseEntity<List<Student>> getStudentsPerDepartment(Long departmentId) {
        AcademicUnit unit = new AcademicUnit();
        unit.setId(departmentId);

        List<StudentRegistration> studentRegistrations = studentRegistrationService.getStudentByUnit(unit);
        List<Student> students = studentRegistrations.stream()
                .map(StudentRegistration::getStudent)
                .toList();
        return ResponseEntity.ok(students);
    }


    private ResponseEntity<List<Student>> getStudentBySemesterAndUnit(Long semesterId, Long unitId) {
        Semester semester = new Semester();
        semester.setId(semesterId);

        AcademicUnit unit = new AcademicUnit();
        unit.setId(unitId);

        List<StudentRegistration> studentRegistrations = studentRegistrationService.getStudentBySemesterAndDepartment(semester, unit);
        List<Student> students = studentRegistrations.stream()
                .map(StudentRegistration::getStudent)
                .toList();
        return ResponseEntity.ok(students);
    }
}
