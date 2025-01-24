package com.ttbtest.saleandservice.ticket.dto;


import lombok.Data;

import java.util.Date;

@Data
public class TicketDTO {
    String ticketId;
    String customerId;
    String accountId;
    String ticketType;
    String description;
    String status;
    String createdDate;
    String updatedDate;
}


