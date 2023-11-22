package com.example.aucaregistration.service;


import com.example.aucaregistration.domain.Course;
import com.example.aucaregistration.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(Course course) throws Exception {
        if (course != null) {
            return courseRepository.save(course);
        } else {
            throw new Exception("Unable to save Course");
        }
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public  List<Course> findCoursesByDepartmentAndSemester(Long departmentId, Long semesterId) {
        return courseRepository.findBySemesterIdAndUnitId(semesterId, departmentId);
    }

    public boolean deleteCourse(Long courseId) {
        if (courseRepository.findById(courseId).isPresent()) {
            courseRepository.deleteById(courseId);
            return true;
        } else {
            return false;
        }
    }
}
