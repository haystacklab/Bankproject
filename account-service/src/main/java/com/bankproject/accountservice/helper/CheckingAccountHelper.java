package com.bankproject.accountservice.helper;

import com.bank.domain.checking.CheckingAccount;
import com.bank.domain.history.History;
import com.bankproject.accountservice.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static com.bankproject.accountservice.util.LoggerUtil.log;

@Service
public class CheckingAccountHelper {

    @Autowired
    private FeignServiceUtil feignServiceUtil;

    public CompletableFuture<List<CheckingAccount>> getCheckingAccounts(String userId) {
        return CompletableFuture
                .supplyAsync(() -> {
                    log("Starting to fetch checking accounts");
                    return feignServiceUtil.getCheckingAccounts(userId);
                })
                .thenApply(this::getCheckingAccountHistory);
    }

    private List<CheckingAccount> getCheckingAccountHistory(List<CheckingAccount> checkingAccounts) {
        List<CompletableFuture<Void>> checkingAccountFutures = checkingAccounts
                .stream()
                .map(this::getAndAssignCheckingAccountHistory)
                .collect(Collectors.toList());
        CompletableFuture<Void> futures = CompletableFuture.allOf(checkingAccountFutures.toArray(
                new CompletableFuture[checkingAccountFutures.size()]));
        try {
            futures.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return checkingAccounts;
    }

    private CompletableFuture<Void> getAndAssignCheckingAccountHistory(CheckingAccount checkingAccount) {
        return CompletableFuture.supplyAsync(() -> feignServiceUtil.getHistory(
                checkingAccount.getAccountId(), checkingAccount.getAccountType())
        ).thenAccept(transactionList -> checkingAccount.setHistory(
                History.Builder.newInstance()
                        .setPeriodInDays(30)
                        .setTransactions(transactionList).build()
        ));
    }
}
