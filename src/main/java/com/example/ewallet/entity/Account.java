package com.example.ewallet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_account")
public class Account {

    public static final String entityName = "Account";
    @Id
    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;

    @OneToMany(mappedBy = "account")
    private List<Wallet> wallets = new ArrayList<>();

    public Account() {
    }

    public Account(String fullName, String email, String phoneNumber, String address, String username, String password) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public List<Wallet> getWallets() { return wallets; }

    public void addWallets(List<Wallet> wallets) { this.wallets.addAll(wallets);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(fullName, account.fullName) && Objects.equals(email, account.email) && Objects.equals(phoneNumber, account.phoneNumber) && Objects.equals(address, account.address) && Objects.equals(username, account.username) && Objects.equals(password, account.password) && Objects.equals(wallets, account.wallets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, phoneNumber, address, username, password, wallets);
    }
}
