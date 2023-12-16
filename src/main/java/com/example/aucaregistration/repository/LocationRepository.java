package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.StopLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<StopLocation, Integer> {
    public Optional<StopLocation> findByNameIgnoreCase(String name);
}