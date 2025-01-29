package com.ttbtest.saleandservice.ticket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbtest.saleandservice.ticket.dto.TicketDTO;
import com.ttbtest.saleandservice.ticket.entity.TicketEntity;
import com.ttbtest.saleandservice.ticket.httpService.AccountHttpService;
import com.ttbtest.saleandservice.ticket.repository.TicketRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Date;
import java.util.Map;

@Service
public class TicketService implements TicketServiceInterface {

    @Autowired
    TicketRepository accountRepository;

    @Autowired
    AccountHttpService accountHttpService;

    public TicketEntity getTicketById(Long id){
        return accountRepository.findById(id).orElse(null);
    }

    public Integer createTicket(TicketDTO ticketEntity) throws AccountNotFoundException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var ticketEntityEntity = mapper.convertValue(ticketEntity, TicketEntity.class);
        var account = accountHttpService.getIdAccount(ticketEntity.getCustomerId(),ticketEntity.getAccountId());
        if(ObjectUtils.isEmpty(account)){
            throw new AccountNotFoundException("Account not found for customerId: " + ticketEntity.getCustomerId());
        }
        Map<String, Object> responseMap = mapper.readValue(account, Map.class);
        Map<String, Object> dataString = (Map<String, Object>) responseMap.get("data");
        var accountValue = dataString.get("accountId");
        ticketEntityEntity.setAccountId((Integer) accountValue);
        ticketEntityEntity.setCreatedDate(new Date());
        ticketEntityEntity.setUpdatedDate(new Date());
        var instance = accountRepository.save(ticketEntityEntity);
        return instance.getTicketId();
    }

    public TicketEntity updateTicket(TicketDTO ticket){
        ObjectMapper mapper = new ObjectMapper();
        var ticketEntity = mapper.convertValue(ticket, TicketEntity.class);
        accountRepository.save(ticketEntity);
        return ticketEntity;
    }

    public void deleteTicket(Long id){
        accountRepository.deleteById(id);
    }



}
