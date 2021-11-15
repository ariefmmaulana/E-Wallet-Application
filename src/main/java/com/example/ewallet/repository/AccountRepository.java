package com.example.ewallet.repository;

import com.example.ewallet.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    public Optional<Account> findAccountByUsername(String username);
}
