package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
