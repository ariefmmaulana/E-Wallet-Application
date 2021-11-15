package com.example.ewallet.service;

import com.example.ewallet.entity.Account;

public interface AccountService {
    public Account getAccountById(String id);
    public Account createAccount(Account account);
}
