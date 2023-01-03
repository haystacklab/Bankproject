package com.bankproject.accountservice.helper;

import com.bank.domain.credit.CreditAccount;
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
public class CreditAccountHelper {

    @Autowired
    private FeignServiceUtil feignServiceUtil;

    public CompletableFuture<List<CreditAccount>> getCreditAccounts(String userId) {
        return CompletableFuture.supplyAsync(() -> {
                    log("Starting to fetch credit accounts");
                    return feignServiceUtil.getCreditAccounts(userId);
                })
                .thenApply(this::getCreditAccountsHistory);
    }

    private List<CreditAccount> getCreditAccountsHistory(List<CreditAccount> creditAccounts) {
        List<CompletableFuture<Void>> creditAccountsFutures = creditAccounts
                .stream()
                .map(this::getAndAssignCreditAccountHistory)
                .collect(Collectors.toList());
        CompletableFuture<Void> futures = CompletableFuture.allOf(creditAccountsFutures.toArray(
                new CompletableFuture[creditAccountsFutures.size()]));
        try {
            futures.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return creditAccounts;
    }

    private CompletableFuture<Void> getAndAssignCreditAccountHistory(CreditAccount creditAccount) {
        return CompletableFuture.supplyAsync(() -> feignServiceUtil.getHistory(
                creditAccount.getAccountId(), creditAccount.getAccountType())
        ).thenAccept(transactionList -> creditAccount.setHistory(
                History.Builder.newInstance()
                        .setPeriodInDays(30)
                        .setTransactions(transactionList).build()
        ));
    }

}
