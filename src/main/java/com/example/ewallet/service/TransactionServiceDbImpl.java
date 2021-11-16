package com.example.ewallet.service;

import com.example.ewallet.entity.Transaction;
import com.example.ewallet.entity.Wallet;
import com.example.ewallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceDbImpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    WalletService walletService;

    @Autowired
    AccountService accountService;

    @Override
    public Transaction topUp(Transaction transaction) {
        Wallet wallet = walletService.getWalletById(transaction.getWallet().getId());
        wallet.addWallet(transaction.getBalance());
        walletService.updateWallet(wallet);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction withdraw(Transaction transaction) {
        Wallet wallet = walletService.getWalletById(transaction.getWallet().getId());
        wallet.decreaseWallet(transaction.getBalance());
        walletService.updateWallet(wallet);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction payment(Transaction transaction) {
        Wallet wallet = walletService.getWalletById(transaction.getWallet().getId());
        walletService.updateWallet(wallet);
        return transactionRepository.save(transaction);
    }
}
