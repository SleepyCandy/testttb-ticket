package com.ttbtest.saleandservice.ticket.repository;

import com.ttbtest.saleandservice.ticket.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity,Long> {

}
