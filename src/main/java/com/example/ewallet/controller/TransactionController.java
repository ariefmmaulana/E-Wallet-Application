package com.example.ewallet.controller;

import com.example.ewallet.entity.Transaction;
import com.example.ewallet.service.TransactionServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionServiceDbImpl transactionServiceDb;

    @PostMapping("/topup")
    public void topUpWallet(@RequestBody Transaction transaction) {
        transactionServiceDb.topUpWallet(transaction);
    }

    @PostMapping("/withdraw")
    public void withdrawWallet(@RequestBody Transaction transaction) {
        transactionServiceDb.withdrawWallet(transaction);
    }
}
