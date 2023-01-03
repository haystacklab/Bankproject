package com.bankproject.historyservice.controller;

import com.bankproject.historyservice.domain.Transaction;
import com.bankproject.historyservice.domain.TransactionType;
import com.bankproject.historyservice.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping(value = "/get/{accountId}/{accountType}", produces = "application/json")
    public CompletableFuture<List<Transaction>> getTransacations(
            @PathVariable String accountId, @PathVariable TransactionType accountType) {
        return historyService.getTransactionsByAccountIdAndType(accountId, accountType);
    }
}
