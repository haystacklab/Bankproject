package com.bankproject.checkingservice.repository;

import com.bankproject.checkingservice.domain.CheckingAccount;
import org.springframework.data.repository.CrudRepository;

public interface CheckingRepository extends CrudRepository<CheckingAccount, String> {
    Iterable<CheckingAccount> findByAccountId(String accountId);

    Iterable<CheckingAccount> findByUserId(String userId);
}
