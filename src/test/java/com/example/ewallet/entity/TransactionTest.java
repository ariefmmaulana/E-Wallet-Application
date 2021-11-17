package com.example.ewallet.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void able_to_createTransaction(){
        Transaction transaction = new Transaction("Top up", 200000);
        assertNotNull(transaction);
    }

    @Test
    public void able_to_createTransaction_with_given_information(){
        Transaction expectedTransaction = new Transaction("Top up", 50000);
        Transaction actualTransaction = new Transaction("Top up", 50000);
        assertEquals(expectedTransaction,actualTransaction);
    }

    @Test
    public void able_to_createTransaction_with_given_wrong_information(){
        Transaction expectedTransaction = new Transaction("Top up", 50000);
        Transaction actualTransaction = new Transaction("Withdraw", 50000);
        assertNotEquals(expectedTransaction,actualTransaction);
    }

}