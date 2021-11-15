package com.example.ewallet.service;

import com.example.ewallet.entity.Transaction;
import com.example.ewallet.entity.Wallet;

public interface WalletService {

    public Wallet getWalletById(String id);
    public Wallet createWallet(Wallet wallet);
    public void updateWallet(Wallet wallet);
}
