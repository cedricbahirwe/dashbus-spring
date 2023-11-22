package com.example.aucaregistration.controller;


import com.example.aucaregistration.domain.StudentRegistration;
import com.example.aucaregistration.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            boolean success = studentRegistrationService.saveStudentRegistration(studentRegistration);
            if (success) {
                return new ResponseEntity<>("StudentRegistration saved", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Something is wrong!", HttpStatus.BAD_REQUEST);
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
}
