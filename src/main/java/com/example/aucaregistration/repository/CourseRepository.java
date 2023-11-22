package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}