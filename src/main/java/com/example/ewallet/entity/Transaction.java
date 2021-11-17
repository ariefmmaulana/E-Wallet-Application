package com.example.ewallet.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tx_transaction")
public class Transaction {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    private String transactionType;
    private Integer balance;

    public Transaction() {
    }

    public Transaction(Account account, Wallet wallet, String transactionType, Integer balance) {
        this.account = account;
        this.wallet = wallet;
        this.transactionType = transactionType;
        this.balance = balance;
    }

    public Transaction(String transactionType, Integer balance) {
        this.transactionType = transactionType;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(account, that.account) && Objects.equals(wallet, that.wallet) && Objects.equals(transactionType, that.transactionType) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, wallet, transactionType, balance);
    }
}
