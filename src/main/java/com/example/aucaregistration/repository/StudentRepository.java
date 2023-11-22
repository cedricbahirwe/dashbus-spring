package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFullName(String name);
}
