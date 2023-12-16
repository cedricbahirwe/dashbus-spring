package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.StopLocation;
import com.example.aucaregistration.domain.Ticket;
import com.example.aucaregistration.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket saveTicket(Ticket ticket) throws Exception {
        if (ticket != null) {
            return ticketRepository.save(ticket);
        } else {
            throw new Exception("Unable to save Ticket");
        }
    }

    public Optional<Ticket> getTicket(int ticketId) throws Exception {
        return ticketRepository.findById(ticketId);
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public void deleteTicketById(int ticketId) throws Exception {
        if (ticketRepository.findById(ticketId).isPresent()) {
            ticketRepository.deleteById(ticketId);
        } else {
            throw new Exception("Ticket not found");
        }
    }

    public List<Ticket> findTickets(String origin, String destination) {
        return ticketRepository.findByOriginOrDestination(origin, destination);
    }
}
