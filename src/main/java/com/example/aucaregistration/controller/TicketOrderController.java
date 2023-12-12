package com.example.aucaregistration.controller;

import com.example.aucaregistration.domain.TicketOrder;
import com.example.aucaregistration.service.TicketOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/ticketOrder",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class TicketOrderController {
    private final TicketOrderService ticketOrderService;

    @Autowired
    public TicketOrderController(TicketOrderService ticketOrderService) {
        this.ticketOrderService = ticketOrderService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createOrder(@RequestBody TicketOrder ticketOrder) {
        if (ticketOrder != null) {
            try {
                TicketOrder saveTicketOrder = ticketOrderService.saveTicketOrder(ticketOrder);
                return new ResponseEntity<>(saveTicketOrder, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
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
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
