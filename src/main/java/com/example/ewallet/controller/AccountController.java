package com.example.ewallet.controller;

import com.example.ewallet.dataTransferObject.UserCredentials;
import com.example.ewallet.entity.Account;
import com.example.ewallet.security.JwtTokenUtil;
import com.example.ewallet.service.AccountServiceDbImpl;
import com.example.ewallet.service.UserDetailServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    AccountServiceDbImpl accountServiceDb;

    @Autowired
    UserDetailServiceDbImpl userDetailServiceDb;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/accounts")
    public List<Account> accounts(){
        return accountServiceDb.getAllAccount();
    }

    @PostMapping("/register")
    public void createAccount(@RequestBody Account account) {
        accountServiceDb.createAccount(account);
    }

    @PutMapping("/account")
    public void updateAccount(@RequestBody Account account) {
        accountServiceDb.updateAccount(account);
    }

    @DeleteMapping("/account")
    public void deleteAccount(@RequestParam String id) {
        accountServiceDb.deleteAccount(id);
    }

    @GetMapping("/account")
    public Account getAccountById(@RequestParam String id) {
        return accountServiceDb.getAccountById(id);
    }

    @PostMapping("/signin")
    public Map<String, Object> signin(@RequestBody UserCredentials userCredentials){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (!authentication.isAuthenticated()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username atau Password Salah");
        }
        UserDetails userDetails = userDetailServiceDb.loadUserByUsername(userCredentials.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);

        Map<String, Object> tokenWrapper = new HashMap<>();
        tokenWrapper.put("token", token);

        return tokenWrapper;
    }
}
