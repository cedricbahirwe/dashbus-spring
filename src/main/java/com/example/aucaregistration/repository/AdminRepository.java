package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Admin;
import com.example.aucaregistration.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUsername(String username);
}