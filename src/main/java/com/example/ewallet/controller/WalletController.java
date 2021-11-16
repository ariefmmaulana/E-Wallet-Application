package com.example.ewallet.controller;

import com.example.ewallet.entity.Wallet;
import com.example.ewallet.service.WalletServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    WalletServiceDbImpl walletServiceDb;

    @PostMapping("/wallet")
    public void createWallet(@RequestBody Wallet wallet) {
        walletServiceDb.createWallet(wallet);
    }

    @DeleteMapping("/wallet")
    public void deleteWallet(@RequestParam String id) {
        walletServiceDb.deleteWallet(id);
    }

    @GetMapping("/wallets")
    public List<Wallet> wallets() {
        return walletServiceDb.getAllWallet();
    }

    @GetMapping("/wallet")
    public Wallet getWalletById(@RequestParam String id) {
        return walletServiceDb.getWalletById(id);
    }

    @PutMapping("/wallet")
    public void updateWallet(@RequestBody Wallet wallet) {
        walletServiceDb.updateWallet(wallet);
    }
}
