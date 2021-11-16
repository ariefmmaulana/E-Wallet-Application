package com.example.ewallet.repository;

import com.example.ewallet.entity.Account;
import com.example.ewallet.entity.Transaction;
import com.example.ewallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Modifying
    @Query(value = "INSERT INTO tx_transaction(id, balance, transaction_type, account_id, wallet_id)" +
            "values (:id, :balance, :transaction_type, :account_id, :wallet_id)", nativeQuery = true)
    void topUpWallet(
            @Param("id") String id,
            @Param("balance") Integer balance,
            @Param("transaction_type") String transaction_type,
            @Param("account_id")Account account_id,
            @Param("wallet_id")Wallet wallet_id
    );

    @Modifying
    @Query(value = "INSERT INTO tx_transaction(id, balance, transaction_type, account_id, wallet_id)" +
            "values (:id, :balance, :transaction_type, :account_id, :wallet_id)", nativeQuery = true)
    void withdrawWallet(
            @Param("id") String id,
            @Param("balance") Integer balance,
            @Param("transaction_type") String transaction_type,
            @Param("account_id")Account account_id,
            @Param("wallet_id")Wallet wallet_id
    );
}
