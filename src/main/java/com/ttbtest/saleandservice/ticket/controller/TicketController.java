package com.ttbtest.saleandservice.ticket.controller;


import com.ttbtest.saleandservice.ticket.dto.TicketDTO;
import com.ttbtest.saleandservice.ticket.dto.ResponseFormat;
import com.ttbtest.saleandservice.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    TicketService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicket(@PathVariable Long id){
        return new ResponseEntity<>(new ResponseFormat(accountService.getTicketById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createTicket(@RequestBody TicketDTO req){
        return new ResponseEntity<>(new ResponseFormat(accountService.createTicket(req)), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updateTicket(@RequestBody TicketDTO req){
        return new ResponseEntity<>(new ResponseFormat(accountService.updateTicket(req)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id){
        accountService.deleteTicket(id);
        return new ResponseEntity<>(new ResponseFormat(null),HttpStatus.OK);
    }

}
