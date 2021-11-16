package com.example.ewallet.service;

import com.example.ewallet.dataTransferObject.UserDetailImpl;
import com.example.ewallet.entity.Account;
import com.example.ewallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceDbImpl implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!accountRepository.findAccountByUsername(username).isPresent()){
            throw new UsernameNotFoundException("Username Not Found");
        }

        Account account = accountRepository.findAccountByUsername(username).get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails userDetails = new UserDetailImpl(account.getUsername(), account.getPassword(), authorities);
        return userDetails;
    }
}
