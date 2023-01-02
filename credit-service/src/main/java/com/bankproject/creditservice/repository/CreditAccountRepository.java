package com.bankproject.creditservice.repository;

import com.bankproject.creditservice.domain.CreditAccount;
import org.springframework.data.repository.CrudRepository;


public interface CreditAccountRepository extends CrudRepository<CreditAccount, String> {
    Iterable<CreditAccount> getCreditAccountsByUserId(String userId);
}
