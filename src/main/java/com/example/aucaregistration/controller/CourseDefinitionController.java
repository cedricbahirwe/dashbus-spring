package com.example.aucaregistration.controller;


import com.example.aucaregistration.domain.CourseDefinition;
import com.example.aucaregistration.service.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/courseDefinitions",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class CourseDefinitionController {

    private final CourseDefinitionService courseDefinitionService;

    @Autowired
    public CourseDefinitionController(CourseDefinitionService courseDefinitionService) {
        this.courseDefinitionService = courseDefinitionService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveCourseDefinition(@RequestBody CourseDefinition courseDefinition) {
        if (courseDefinition != null) {
            try {
                CourseDefinition newCourseDef = courseDefinitionService.saveCourseDefinition(courseDefinition);
                return new ResponseEntity<>(newCourseDef, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (value = "/")
    public ResponseEntity<List<CourseDefinition>> getCourseDefinitions() {
        List<CourseDefinition> courseDefinitions = courseDefinitionService.getCourseDefinitions();
        return ResponseEntity.ok(courseDefinitions);
    }

    @DeleteMapping(value = "/{courseDefinitionId}")
    public ResponseEntity<?> deleteCourseDefinition(@PathVariable Long courseDefinitionId) {
        try {
            courseDefinitionService.deleteCourseDefinition(courseDefinitionId);
            return new ResponseEntity<>("Course Definition Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
