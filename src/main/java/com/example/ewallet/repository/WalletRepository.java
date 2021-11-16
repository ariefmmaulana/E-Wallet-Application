package com.example.ewallet.repository;

import com.example.ewallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

    @Modifying
    @Query(value = "INSERT INTO mst_wallet(id, name, balance)" +
            "values (:id, :name, :balance)", nativeQuery = true)
    void createWallet(
            @Param("id") String id,
            @Param("name") String name,
            @Param("balance") Integer balance
    );
}
