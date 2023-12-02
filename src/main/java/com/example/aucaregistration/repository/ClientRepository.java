package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> { }