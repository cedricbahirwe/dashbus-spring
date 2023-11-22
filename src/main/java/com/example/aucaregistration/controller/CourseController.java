package com.example.aucaregistration.controller;


import com.example.aucaregistration.domain.Course;
import com.example.aucaregistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/courses",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveCourse(@RequestBody Course course) {
        if (course != null) {
            try {
                Course newCourse = courseService.saveCourse(course);
                return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (value = "/")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> courses = courseService.getCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping (value = "/list")
    public ResponseEntity<List<Course>> findCoursesByDepartmentAndSemester(
            @RequestParam Long departmentId,
            @RequestParam Long semesterId
    ) {
        List<Course> courses = courseService.findCoursesByDepartmentAndSemester(departmentId, semesterId);
        return ResponseEntity.ok(courses);
    }

    @DeleteMapping(value = "/{courseId}")
    public ResponseEntity<?> deleteCourseDefinition(@PathVariable Long courseId) {
        try {
            courseService.deleteCourse(courseId);
            return new ResponseEntity<>("Course Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
