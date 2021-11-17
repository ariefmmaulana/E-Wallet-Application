package com.example.ewallet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mst_wallet")
public class Wallet {

    public static final String entityName = "Wallet";
    @Id
    private String id;
    private String name;
    private Integer balance;

    @Transient
    private String accountIdTransient;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Wallet() {
    }

    public Wallet(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountIdTransient() {
        return accountIdTransient;
    }

    public void setAccountIdTransient(String accountIdTransient) {
        this.accountIdTransient = accountIdTransient;
    }

    @JsonIgnore
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void decreaseWallet(Integer balance) { this.balance = this.balance-balance; }

    public void addWallet(Integer balance) { this.balance = this.balance+balance; }

    @Override
    public String toString() {
        return "Wallet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(name, wallet.name) && Objects.equals(balance, wallet.balance) && Objects.equals(accountIdTransient, wallet.accountIdTransient) && Objects.equals(account, wallet.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance, accountIdTransient, account);
    }
}
