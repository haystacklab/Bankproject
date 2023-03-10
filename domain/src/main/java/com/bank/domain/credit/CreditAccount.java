package com.bank.domain.credit;

import com.bank.domain.AccountType;
import com.bank.domain.checking.Status;
import com.bank.domain.history.History;
import lombok.Data;

@Data
public class CreditAccount {
    private String accountId; // maybe foriegn key to Account
    private AccountType accountType = AccountType.CREDIT;
    private Float balance;
    private Status status = Status.CREATED;
    private History history;
}
