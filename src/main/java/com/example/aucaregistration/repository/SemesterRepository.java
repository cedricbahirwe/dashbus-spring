package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}