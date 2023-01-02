package com.bankproject.accountservice.repository;

import com.bankproject.accountservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
