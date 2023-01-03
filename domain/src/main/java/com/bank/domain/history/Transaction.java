package com.bank.domain.history;

import com.bank.domain.AccountType;
import lombok.Data;
import java.util.Date;

@Data
public class Transaction {
    private String transactionId;
    private String accountId;
    private AccountType accountType;
    private Date transactionTimeStamp;
    private TransactionType transactionType;
    private Float transactionAmount;
    private Boolean isTransactionSuccess;
}
