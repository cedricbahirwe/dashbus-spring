package com.example.aucaregistration.controller;


import com.example.aucaregistration.domain.*;
import com.example.aucaregistration.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/studentCourses",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveStudentCourse(@RequestBody StudentCourse studentCourse) {
        if (studentCourse != null) {
            try {

                StudentCourse newStudentCourse = studentCourseService.saveStudentCourse(studentCourse);

                return new ResponseEntity<>(newStudentCourse, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (value = "/")
    public ResponseEntity<List<StudentCourse>> getStudentCourses() {
        List<StudentCourse> studentCourses = studentCourseService.getStudentCourses();
        return ResponseEntity.ok(studentCourses);
    }

    @GetMapping (value = "/list")
    public ResponseEntity<?> getFilteredStudents(
            @RequestParam(name = "courseId") Long courseId,
            @RequestParam(name = "semesterId") Long semesterId
    ) {

        List<StudentCourse> studentRegistrations = studentCourseService.getStudentByCourseAndSemester(courseId, semesterId);
        List<Student> students = studentRegistrations.stream()
                .map(StudentCourse::getStudentRegistration)
                .map(StudentRegistration::getStudent)
                .toList();
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/courses")
    public ResponseEntity<?> getCoursesByStudents(@RequestParam(name = "studentId") Long studentId) {

        List<StudentCourse> studentRegistrations = studentCourseService.findCoursesStudentId(studentId);
        List<Course> courses = studentRegistrations.stream()
                .map(StudentCourse::getCourse)
                .toList();
        return ResponseEntity.ok(courses);
    }

    @DeleteMapping(value = "/{studentCourseId}")
    public ResponseEntity<?> deleteStudentCourse(@PathVariable Long studentCourseId) {
        try {
            studentCourseService.deleteStudentCourse(studentCourseId);
            return new ResponseEntity<>("Student Course Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
