package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}