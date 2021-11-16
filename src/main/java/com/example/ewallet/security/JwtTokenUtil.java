package com.example.ewallet.security;

import com.example.ewallet.service.UserDetailServiceDbImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    @Value("${sebuah.rahasia}")
    private String secret;

    @Autowired
    UserDetailServiceDbImpl userDetailServiceDb;

    public String generateToken(UserDetails userDetails){

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userDetails.getUsername());

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+(10*60*10000)))
                .signWith(SignatureAlgorithm.HS512, secret).compact();

        return token;
    }

    public UserDetails parseToken(String token){
        Jws<Claims> jwtClaims = Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
        String username = jwtClaims.getBody().getSubject();
        return userDetailServiceDb.loadUserByUsername(username);
    }
}
