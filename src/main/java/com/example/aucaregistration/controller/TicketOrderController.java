package com.example.aucaregistration.controller;

import com.example.aucaregistration.domain.Ticket;
import com.example.aucaregistration.domain.TicketOrder;
import com.example.aucaregistration.service.TicketOrderService;
import com.example.aucaregistration.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping(
        value = "/ticketOrder"
)
public class TicketOrderController {
    private final TicketOrderService ticketOrderService;
    private final TicketService ticketService;

    @Autowired
    public TicketOrderController(TicketOrderService ticketOrderService, TicketService ticketService) {
        this.ticketOrderService = ticketOrderService;
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> buyTicket(@RequestBody TicketOrder ticketOrder) {
        if (ticketOrder != null) {
            try {
                int ticketId = ticketOrder.getTicket().getId();

                Ticket ticket = ticketService.getTicket(ticketId).orElseThrow();

                if (isTicketOutOfStock(ticket)) {
                    // Return a 409 Conflict status with a JSON response
                    Map<String, Object> errorResponse = new HashMap<>();
                    errorResponse.put("error", "Out of stock");
                    errorResponse.put("message", "The requested ticket is currently out of stock. Please choose a different item or try again later.");
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
                }

                int numberOfTicketsToBuy = ticketOrder.getNumberOfTickets() > 0 ? ticketOrder.getNumberOfTickets() : 1;

                int remainingTickets = ticket.getRemainingPlaces();

                if (numberOfTicketsToBuy > remainingTickets) {
                    // Return a 409 Conflict status with a JSON response
                    Map<String, Object> errorResponse = new HashMap<>();
                    errorResponse.put("error", "Low stock");
                    errorResponse.put("message", "The number of tickets available is lower than the requested tickets. Please choose a lower number or try again later.");
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
                }

                ticket.setRemainingPlaces(remainingTickets - numberOfTicketsToBuy);

                ticketService.saveTicket(ticket);

                // Current date and time
                LocalDateTime currentDateTime = LocalDateTime.now();
                System.out.println("Current Date and Time: " + currentDateTime);
                ticketOrder.setDateTime(currentDateTime);
                TicketOrder saveTicketOrder = ticketOrderService.saveTicketOrder(ticketOrder);
                return ResponseEntity.status(HttpStatus.CREATED).body(saveTicketOrder);

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty data not allowed!");
        }
    }

    private boolean isTicketOutOfStock(Ticket ticket) {
        return ticket.getRemainingPlaces() < 1;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<TicketOrder>> getAllTicketOrders() {
        List<TicketOrder> ticketOrders = ticketOrderService.getTicketOrders();
        return ResponseEntity.ok(ticketOrders);
    }

    @DeleteMapping(value = "/{ticketOrderId}")
    public ResponseEntity<?> deleteTicketOrder(@PathVariable Long ticketOrderId) {
        try {
            ticketOrderService.deleteTicketOrderById(ticketOrderId);
            return new ResponseEntity<>("TicketOrder Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
