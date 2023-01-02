package com.bank.domain.history;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Transaction {
    private String transactionId;
    private String userId;
    private LocalDateTime transactionTimeStamp;
    private TransactionType transactionType;
    private Float transactionAmount;
    private Boolean isTransactionSuccess;
}
