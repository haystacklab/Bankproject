package com.bankproject.accountservice.controller;


import com.bank.domain.account.AccountResponse;
import com.bankproject.accountservice.domain.User;
import com.bankproject.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/get/{userId}", produces = "application/json")
    public AccountResponse getAccounts(@PathVariable String userId) {
        return accountService.getAccountsByUserId(userId);
    }

    @GetMapping(value = "/getAllUsers", produces = "application/json")
    public CompletableFuture<List<User>> getAllUsers() {
        return accountService.getAllUsers();
    }
}
