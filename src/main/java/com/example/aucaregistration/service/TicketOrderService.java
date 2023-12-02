package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.TicketOrder;
import com.example.aucaregistration.repository.TicketOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketOrderService {
    private final TicketOrderRepository ticketOrderRepository;

    @Autowired
    public TicketOrderService(TicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    public TicketOrder saveTicketOrder(TicketOrder ticketOrder) throws Exception {
        if (ticketOrder != null) {
            return ticketOrderRepository.save(ticketOrder);
        } else {
            throw new Exception("Unable to save Ticket");
        }
    }

    public List<TicketOrder> getTicketOrders() {
        return ticketOrderRepository.findAll();
    }

    public void deleteTicketOrderById(Long ticketOrderId) throws Exception {
        if (ticketOrderRepository.findById(ticketOrderId).isPresent()) {
            ticketOrderRepository.deleteById(ticketOrderId);
        } else {
            throw new Exception("TicketOrder not found");
        }
    }
}

