package com.example.ewallet.controller;

import com.example.ewallet.entity.Account;
import com.example.ewallet.service.AccountServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountServiceDbImpl accountServiceDb;

    @GetMapping("/accounts")
    public List<Account> apa(){
        return accountServiceDb.getAllAccount();
    }

    @PostMapping("/account")
    public void createAccount(@RequestBody Account account) {
        accountServiceDb.createAccount(account);
    }

    @PutMapping("/account")
    public void updateAccount(@RequestBody Account account) {
        accountServiceDb.updateAccount(account);
    }

    @DeleteMapping("/account")
    public void deleteAccount(@RequestParam String id) {
        accountServiceDb.deleteAccount(id);
    }
}
