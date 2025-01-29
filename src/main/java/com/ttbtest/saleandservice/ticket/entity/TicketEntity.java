package com.ttbtest.saleandservice.ticket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name = "ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "ticket_type", nullable = false, length = 50)
    private String ticketType;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "status", length = 20, nullable = false)
    private String status = "In-progress";

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

}