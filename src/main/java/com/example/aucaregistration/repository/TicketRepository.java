package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.StopLocation;
import com.example.aucaregistration.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("SELECT t FROM Ticket t WHERE lower(t.origin.name) = lower(:origin) OR lower(t.origin.name) = lower(:destination) OR lower(t.destination.name) = lower(:destination) OR lower(t.destination.name) = lower(:origin)")
    List<Ticket> findByOriginOrDestination(String origin, String destination);
}