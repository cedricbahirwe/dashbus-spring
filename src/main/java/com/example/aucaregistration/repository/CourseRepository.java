package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findBySemesterIdAndUnitId(Long semesterId, Long departmentId);
}