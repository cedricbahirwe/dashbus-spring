package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}