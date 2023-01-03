package com.bankproject.accountservice.service;

import com.bank.domain.account.AccountDetails;
import com.bank.domain.account.AccountResponse;
import com.bank.domain.checking.CheckingAccount;
import com.bank.domain.credit.CreditAccount;
import com.bankproject.accountservice.domain.User;
import com.bankproject.accountservice.helper.CheckingAccountHelper;
import com.bankproject.accountservice.helper.CreditAccountHelper;
import com.bankproject.accountservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.bankproject.accountservice.util.LoggerUtil.log;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountHelper accountHelper;

    @Autowired
    private CreditAccountHelper creditAccountHelper;

    @Autowired
    private CheckingAccountHelper checkingAccountHelper;

    @Override
    public AccountResponse getAccountsByUserId(String userId) {
        // get account from ser
        // get all accounts from checkings; simultaneously get all accounts from credit
        // for each checking and credit account, simultaneously get history for all the accounts
        return getAccountsByCF(userId);
    }

    public AccountResponse getAccountsByCF(String userId) {
        CompletableFuture<AccountResponse> accRespCF = accountHelper.getAccountDetails(userId);
        CompletableFuture<List<CheckingAccount>> checkingAccountsCF = checkingAccountHelper.getCheckingAccounts(userId);
        CompletableFuture<List<CreditAccount>> creditAccountsCF = creditAccountHelper.getCreditAccounts(userId);
        log("Inside getAccounts service main");

        AccountResponse accountResponse = accRespCF
                .thenCombine(checkingAccountsCF, (accountResponseResult, checkingAccounts) -> {
                    log("Combining checkingAccounts with accountResponse");
                    accountResponseResult.setCheckingAccounts(checkingAccounts);
                    return accountResponseResult;
                })
                .thenCombine(creditAccountsCF, (accountResponseResult, creditAccounts) -> {
                    log("Combining creditAccounts with accountResponse");
                    accountResponseResult.setCreditAccounts(creditAccounts);
                    return accountResponseResult;
                })
                .join();
        log("Done fetching accountResponse in main");
        return accountResponse;
    }

    @Override
    public CompletableFuture<List<User>> getAllUsers() {
        return accountHelper.getAllUsers();
    }
}
