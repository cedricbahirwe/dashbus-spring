package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Course;
import com.example.aucaregistration.domain.Semester;
import com.example.aucaregistration.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    public List<StudentCourse> findByCourseCourseDefinitionIdAndStudentRegistrationSemesterId(Long courseId, Long semesterId);
    List<StudentCourse> findByStudentRegistrationStudentStudentId(Long studentId);

}