package com.bankproject.checkingservice.service;

import com.bankproject.checkingservice.domain.CheckingAccount;
import com.bankproject.checkingservice.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckingService {
    
    @Autowired
    private CheckingRepository checkingRepository;
    
    public List<CheckingAccount> getCheckingAccountsByUserId(String userId) {
        List<CheckingAccount> checkingAccounts;
        checkingAccounts = new ArrayList<>();
        Iterable<CheckingAccount> checkingAccountsIterable = checkingRepository.findByUserId(userId);
        checkingAccountsIterable.forEach(checkingAccounts::add);
        return checkingAccounts;
    }
    
}
