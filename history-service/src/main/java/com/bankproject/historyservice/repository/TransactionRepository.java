package com.bankproject.historyservice.repository;

import com.bank.domain.AccountType;
import com.bankproject.historyservice.domain.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

    CompletableFuture<List<Transaction>> getTransactionsByAccountIdAndAccountType(
            String accountId, AccountType accountType);
}
