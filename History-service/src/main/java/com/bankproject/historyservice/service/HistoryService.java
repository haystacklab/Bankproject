package com.bankproject.historyservice.service;

import com.bankproject.historyservice.domain.Transaction;
import com.bankproject.historyservice.domain.TransactionType;
import com.bankproject.historyservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class HistoryService {

    @Autowired
    TransactionRepository transactionRepository;

    public CompletableFuture<List<Transaction>> getTransactionsByAccountIdAndType(
            String accountId, TransactionType transactionType) {
        return transactionRepository.getTransactionsByAccountIdAndTransactionType(accountId, transactionType);
    }
}
