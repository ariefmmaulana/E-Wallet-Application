package com.example.ewallet.service;

import com.example.ewallet.entity.Transaction;

public interface TransactionService {

    public Transaction topUp(Transaction transaction);
    public Transaction withdraw(Transaction transaction);
    public Transaction payment(Transaction transaction);
}
