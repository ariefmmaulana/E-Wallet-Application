package com.example.ewallet.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    public void able_to_createWallet(){
        Wallet wallet = new Wallet("Uvo", 50000);
        assertNotNull(wallet);
    }

    @Test
    public void able_to_createWallet_with_given_information(){
        Wallet expectedWallet = new Wallet("Uvo", 50000);
        Wallet actualWallet = new Wallet("Uvo", 50000);
        assertEquals(expectedWallet,actualWallet);
    }

    @Test
    public void able_to_createAccount_with_given_wrong_information(){
        Wallet expectedWallet = new Wallet("Uvo", 50000);
        Wallet actualWallet = new Wallet("Dono", 50000);
        assertNotEquals(expectedWallet,actualWallet);
    }

}