package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Integer> {
}
