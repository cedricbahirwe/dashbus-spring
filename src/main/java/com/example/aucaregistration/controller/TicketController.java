package com.example.aucaregistration.controller;

import com.example.aucaregistration.domain.Ticket;
import com.example.aucaregistration.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/ticket",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) {
        if (ticket != null) {
            try {
                Ticket saveTicket = ticketService.saveTicket(ticket);
                return new ResponseEntity<>(saveTicket, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getTickets();
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping(value = "/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable int ticketId) {
        try {
            ticketService.deleteTicketById(ticketId);
            return new ResponseEntity<>("Ticket Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
