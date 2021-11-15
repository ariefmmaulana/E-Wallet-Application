package com.example.ewallet.service;

import com.example.ewallet.entity.Account;
import com.example.ewallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceDbImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account getAccountById(String id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}
