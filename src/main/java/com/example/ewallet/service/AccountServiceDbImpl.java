package com.example.ewallet.service;

import com.example.ewallet.entity.Account;
import com.example.ewallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceDbImpl {

    @Autowired
    AccountRepository accountRepository;

    public Account getAccountById(String id) {
        return accountRepository.findById(id).get();
    }

    @Transactional
    public void createAccount(Account account) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        account.setId(uuid);
        accountRepository.createAccount(
                account.getId(),
                account.getFullName(),
                account.getEmail(),
                account.getAddress(),
                account.getUsername(),
                account.getPassword(),
                account.getPhoneNumber()
        );
    }

    @Transactional
    public void updateAccount(Account account) {
        accountRepository.updateAccount(
                account.getEmail(),
                account.getPassword(),
                account.getPhoneNumber(),
                account.getId()
        );
    }

    public List<Account> getAllAccount() {
        return accountRepository.accounts();
    }

    @Transactional
    public void deleteAccount(String id) {
        accountRepository.deleteAccount(id);
    }


}
