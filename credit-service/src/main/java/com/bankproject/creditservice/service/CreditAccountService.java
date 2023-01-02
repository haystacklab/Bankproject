package com.bankproject.creditservice.service;

import com.bankproject.creditservice.domain.CreditAccount;
import com.bankproject.creditservice.repository.CreditAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditAccountService {

    @Autowired
    CreditAccountRepository creditAccountRepository;

    public List<CreditAccount> getCreditAccounts(String userId) {
        List<CreditAccount> creditAccounts = new ArrayList<>();
        Iterable<CreditAccount> creditAccountsIterable = creditAccountRepository.getCreditAccountsByUserId(userId);
        creditAccountsIterable.forEach(creditAccounts::add);
        return creditAccounts;
    }
}
