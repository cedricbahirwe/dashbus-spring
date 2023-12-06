package com.example.aucaregistration.repository;

import com.example.aucaregistration.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {}