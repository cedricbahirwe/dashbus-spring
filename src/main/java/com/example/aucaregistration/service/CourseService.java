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

    public Boolean saveCourse(Course course) {
        if (course != null) {
            courseRepository.save(course);
            return true;
        } else {
            return false;
        }
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public boolean deleteCourse(Integer courseId) {
        if (courseRepository.findById(courseId).isPresent()) {
            courseRepository.deleteById(courseId);
            return true;
        } else {
            return false;
        }
    }
}
