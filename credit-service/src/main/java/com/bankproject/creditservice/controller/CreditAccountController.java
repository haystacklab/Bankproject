package com.bankproject.creditservice.controller;

import com.bankproject.creditservice.domain.CreditAccount;
import com.bankproject.creditservice.service.CreditAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditAccountController {

    @Autowired
    CreditAccountService creditAccountService;

    @GetMapping(value = "/get/{userId}", produces = "application/json")
    public List<CreditAccount> getCreditAccounts(@PathVariable String userId) {
        return creditAccountService.getCreditAccounts(userId);
    }
}
