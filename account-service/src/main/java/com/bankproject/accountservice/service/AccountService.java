package com.bankproject.accountservice.service;

import com.bank.domain.account.AccountResponse;
import com.bankproject.accountservice.domain.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AccountService {
    AccountResponse getAccountsByUserId(String userId);

    CompletableFuture<List<User>> getAllUsers();
}
