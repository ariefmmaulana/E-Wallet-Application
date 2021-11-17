package com.example.ewallet.service;

import com.example.ewallet.entity.Transaction;
import com.example.ewallet.entity.Wallet;
import com.example.ewallet.repository.AccountRepository;
import com.example.ewallet.repository.TransactionRepository;
import com.example.ewallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class TransactionServiceDbImpl {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountServiceDbImpl accountServiceDb;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    WalletServiceDbImpl walletServiceDb;

    @Transactional
    public void topUpWallet(Transaction transaction) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        transaction.setId(uuid);
        Wallet wallet = walletServiceDb.getWalletById(transaction.getWallet().getId());
        wallet.addWallet(transaction.getBalance());
        walletServiceDb.updateWallet(wallet);
        transactionRepository.topUpWallet(
                transaction.getId(),
                transaction.getBalance(),
                transaction.getTransactionType(),
                transaction.getAccount(),
                transaction.getWallet()
        );
    }

    @Transactional
    public void withdrawWallet(Transaction transaction) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        transaction.setId(uuid);
        Wallet wallet = walletServiceDb.getWalletById(transaction.getWallet().getId());
        if (wallet.getBalance()<transaction.getBalance()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Your balance is not enough");
        }
        wallet.decreaseWallet(transaction.getBalance());
        walletServiceDb.updateWallet(wallet);
        transactionRepository.withdrawWallet(
                transaction.getId(),
                transaction.getBalance(),
                transaction.getTransactionType(),
                transaction.getAccount(),
                transaction.getWallet()
        );
    }


}
