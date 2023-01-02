package com.bankproject.accountservice.service;

import com.bank.domain.account.AccountResponse;
import com.bankproject.accountservice.domain.User;

import java.util.List;

public interface AccountService {
    AccountResponse getAccountsByUserId(String userId);

    List<User> getAllUsers();
}
