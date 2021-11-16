package com.example.ewallet.service;

import com.example.ewallet.entity.Account;
import com.example.ewallet.entity.Wallet;
import com.example.ewallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class WalletServiceDbImpl{

    @Autowired
    WalletRepository walletRepository;

    @Transactional
    public void createWallet(Wallet wallet) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        wallet.setId(uuid);
        walletRepository.createWallet(
                wallet.getId(),
                wallet.getName(),
                wallet.getBalance()
        );
    }


}
