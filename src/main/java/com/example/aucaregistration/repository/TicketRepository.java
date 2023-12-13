package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> { }