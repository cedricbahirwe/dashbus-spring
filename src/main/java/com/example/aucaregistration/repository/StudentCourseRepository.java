package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

}