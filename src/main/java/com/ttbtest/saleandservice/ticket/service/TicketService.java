package com.ttbtest.saleandservice.ticket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbtest.saleandservice.ticket.dto.TicketDTO;
import com.ttbtest.saleandservice.ticket.entity.TicketEntity;
import com.ttbtest.saleandservice.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements TicketServiceInterface {

    @Autowired
    TicketRepository accountRepository;


    public TicketEntity getTicketById(Long id){
        return accountRepository.findById(id).orElse(null);
    }

    public TicketEntity createTicket(TicketDTO accountDTO){
        ObjectMapper mapper = new ObjectMapper();
        var customerEntity = mapper.convertValue(accountDTO, TicketEntity.class);

        accountRepository.save(customerEntity);
        return customerEntity;
    }

    public TicketEntity updateTicket(TicketDTO accountDTO){
        ObjectMapper mapper = new ObjectMapper();
        var customerEntity = mapper.convertValue(accountDTO, TicketEntity.class);
        accountRepository.save(customerEntity);
        return customerEntity;
    }

    public void deleteTicket(Long id){
        accountRepository.deleteById(id);
    }



}
