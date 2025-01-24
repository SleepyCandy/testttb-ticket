package com.ttbtest.saleandservice.ticket.service;


import com.ttbtest.saleandservice.ticket.dto.TicketDTO;
import com.ttbtest.saleandservice.ticket.entity.TicketEntity;

public interface TicketServiceInterface {

    TicketEntity getTicketById(Long id);
    TicketEntity createTicket(TicketDTO accountDTO);
    TicketEntity updateTicket(TicketDTO accountDTO);
    void deleteTicket(Long id);
}
