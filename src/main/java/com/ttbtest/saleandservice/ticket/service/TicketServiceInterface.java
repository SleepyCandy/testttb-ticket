package com.ttbtest.saleandservice.ticket.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ttbtest.saleandservice.ticket.dto.TicketDTO;
import com.ttbtest.saleandservice.ticket.entity.TicketEntity;

import javax.security.auth.login.AccountNotFoundException;

public interface TicketServiceInterface {

    TicketEntity getTicketById(Long id);
    Integer createTicket(TicketDTO accountDTO) throws AccountNotFoundException, JsonProcessingException;
    TicketEntity updateTicket(TicketDTO accountDTO);
    void deleteTicket(Long id);
}
