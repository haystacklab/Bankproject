package com.bank.domain.account;

import com.bank.domain.checking.CheckingAccount;
import com.bank.domain.credit.CreditAccount;
import lombok.Data;

import java.util.List;

@Data
public class AccountResponse {
    private AccountDetails accountDetails;
    private List<CheckingAccount> checkingAccounts;
    private List<CreditAccount> creditAccounts;
}
