package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long> { }