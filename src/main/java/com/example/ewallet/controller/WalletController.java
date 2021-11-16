package com.example.ewallet.controller;

import com.example.ewallet.entity.Wallet;
import com.example.ewallet.service.WalletServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    @Autowired
    WalletServiceDbImpl walletServiceDb;

    @PostMapping("/wallet")
    public void createWallet(@RequestBody Wallet wallet) {
        walletServiceDb.createWallet(wallet);
    }
}
