package com.ttbtest.saleandservice.ticket.dto;


import lombok.Data;

import java.util.Date;

@Data
public class TicketDTO {
    String ticketId;
    Integer customerId;
    Integer accountId;
    String ticketType;
    String description;
    String status;
    String createdDate;
    String updatedDate;
}


