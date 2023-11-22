package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.CourseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDefinitionRepository extends JpaRepository<CourseDefinition, Long> {
}