package com.example.ewallet.service;

import com.example.ewallet.entity.Account;
import com.example.ewallet.entity.Wallet;
import com.example.ewallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceDbImpl implements WalletService{

    @Autowired
    AccountService accountService;

    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet getWalletById(String id) {
        Wallet wallet = walletRepository.findById(id).get();
        wallet.setAccoundIdTransient(wallet.getAccount().getId());
        return wallet;
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        Account account = accountService.getAccountById(wallet.getAccoundIdTransient());
        wallet.setAccount(account);
        return walletRepository.save(wallet);
    }

    @Override
    public void updateWallet(Wallet wallet) {
        getWalletById(wallet.getId());
        walletRepository.save(wallet);
    }
}
