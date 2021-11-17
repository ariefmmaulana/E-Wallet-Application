package com.example.ewallet.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void able_to_createAccount(){
        Account account = new Account("Kennedy", "kennedy.nba.com", "0812121212", "Los Angeles", "kennedy.nba", "12345678");
        assertNotNull(account);
    }

    @Test
    public void able_to_createAccount_with_given_information(){
        Account expectedAccount = new Account("Kennedy", "kennedy.nba.com", "0812121212", "Los Angeles", "kennedy.nba", "12345678");
        Account actualAccount = new Account("Kennedy", "kennedy.nba.com", "0812121212", "Los Angeles", "kennedy.nba", "12345678");
        assertEquals(expectedAccount,actualAccount);
    }

    @Test
    public void able_to_createAccount_with_given_wrong_information(){
        Account expectedAccount = new Account("Kennedy", "kennedy.nba.com", "0812121212", "Los Angeles", "kennedy.nba", "12345678");
        Account actualAccount = new Account("Kennedy Martin", "kennedy.nba.com", "0812121212", "Los Angeles", "kennedy.nba", "12345678");
        assertNotEquals(expectedAccount,actualAccount);
    }


}