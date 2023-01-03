package com.bankproject.accountservice.service;

import com.bank.domain.account.AccountDetails;
import com.bank.domain.account.AccountResponse;
import com.bankproject.accountservice.domain.User;
import com.bankproject.accountservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountHelper {

    @Autowired
    private UserRepository userRepository;

    public CompletableFuture<AccountResponse> getAccountDetails(String userId) {
        return CompletableFuture.supplyAsync(() -> mapUserToAccountDetails(
                userRepository.getUserDetailsByUserId(userId)));
    }

    private AccountResponse mapUserToAccountDetails(User user) {
        AccountResponse accountResponse = new AccountResponse();
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAddress(user.getAddress());
        accountDetails.setCountry(user.getCountry());
        accountDetails.setFirstName(user.getFirstName());
        accountDetails.setFirstName(user.getFirstName());
        accountDetails.setLastName(user.getLastName());
        accountDetails.setState(user.getState());
        accountDetails.setCountry(user.getCountry());
        accountDetails.setZip(user.getZip());
        accountDetails.setMemberSince(user.getMemberSince());
        accountResponse.setAccountDetails(accountDetails);
        return accountResponse;
    }

    public CompletableFuture<List<User>> getAllUsers() {
        return CompletableFuture.supplyAsync(() -> (List<User>) userRepository.findAll());
    }
}
