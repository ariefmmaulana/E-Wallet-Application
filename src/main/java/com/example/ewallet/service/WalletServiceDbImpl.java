package com.example.ewallet.service;

import com.example.ewallet.entity.Account;
import com.example.ewallet.entity.Wallet;
import com.example.ewallet.repository.AccountRepository;
import com.example.ewallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class WalletServiceDbImpl{

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountServiceDbImpl accountServiceDb;

    @Transactional
    public void createWallet(Wallet wallet) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        wallet.setId(uuid);
        Account getById =  accountServiceDb.getAccountById(wallet.getAccountIdTransient());
        wallet.setAccount(getById);
        walletRepository.createWallet(
                wallet.getId(),
                wallet.getName(),
                wallet.getBalance(),
                wallet.getAccount()
        );
    }

    @Transactional
    public void deleteWallet(String id) {
        walletRepository.deleteWallet(id);
    }

    public List<Wallet> getAllWallet() { return walletRepository.wallets();}

    @Transactional
    public void updateWallet(Wallet wallet) {
        walletRepository.updateWallet(
                wallet.getId(),
                wallet.getBalance()
        );
    }

    public Wallet getWalletById(String id) {
        return walletRepository.findById(id).get();
    }
}
