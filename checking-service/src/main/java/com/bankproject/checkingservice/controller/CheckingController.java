package com.bankproject.checkingservice.controller;

import com.bankproject.checkingservice.domain.CheckingAccount;
import com.bankproject.checkingservice.service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("checking")
public class CheckingController {

    @Autowired
    private CheckingService checkingService;

    @GetMapping(value = "/get/{userId}", produces = "application/json")
    public List<CheckingAccount> getCheckingAccountsByUserId(@PathVariable String userId) {
        return checkingService.getCheckingAccountsByUserId(userId);
    }
}
