package com.example.ewallet.service;

import com.example.ewallet.entity.Account;
import com.example.ewallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceDbImpl {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Account getAccountById(String id) {
        if (!accountRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Account Not Found");
        }
        return accountRepository.findById(id).get();
    }

    @Transactional
    public void createAccount(Account account) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        account.setId(uuid);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
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
        boolean existAccount = getAllAccount().stream().anyMatch(t -> t.equals(account));
            if (existAccount){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id Account Not Found");
            } else {
                accountRepository.updateAccount(
                        account.getEmail(),
                        account.getPassword(),
                        account.getPhoneNumber(),
                        account.getId()
                );
            }
        }


    public List<Account> getAllAccount() {
        return accountRepository.getAllAccounts();
    }

    @Transactional
    public void deleteAccount(String id) {
        accountRepository.deleteAccount(id);
    }




}
