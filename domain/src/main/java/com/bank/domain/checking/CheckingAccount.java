package com.bank.domain.checking;

import com.bank.domain.history.History;
import lombok.Data;

import java.util.List;

@Data
public class CheckingAccount {
    private String accountId; // maybe foreign key to Account
    private AccountType accountType = AccountType.CHECKING;
    private Float balance;
    private Status status = Status.CREATED;
//    private List<History> history = List.of(new History());
}


