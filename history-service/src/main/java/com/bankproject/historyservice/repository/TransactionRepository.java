package com.bankproject.historyservice.repository;

import com.bankproject.historyservice.domain.Transaction;
import com.bankproject.historyservice.domain.TransactionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

    CompletableFuture<List<Transaction>> getTransactionsByAccountIdAndTransactionType(
            String accountId, TransactionType transactionType);
}
