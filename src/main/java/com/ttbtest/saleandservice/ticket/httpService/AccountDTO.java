package com.ttbtest.saleandservice.ticket.httpService;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountDTO {
        private Integer accountId;

        private Integer customerId;

        private String accountNumber;

        private String accountType;

        private BigDecimal balance;

        private Date createdDate;

        private Integer statusCode; // สถานะบัญชี เช่น 1 = Active, 2 = Suspended, 3 = Closed

}
