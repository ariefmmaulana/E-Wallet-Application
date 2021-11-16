package com.example.ewallet.repository;

import com.example.ewallet.entity.Account;
import com.example.ewallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

    @Query(value = "SELECT * FROM mst_wallet", nativeQuery = true)
    List<Wallet> wallets();

    @Modifying
    @Query(value = "INSERT INTO mst_wallet(id, name, balance, account_id)" +
            "values (:id, :name, :balance, :account_id)", nativeQuery = true)
    void createWallet(
            @Param("id") String id,
            @Param("name") String name,
            @Param("balance") Integer balance,
            @Param("account_id") Account account_id
    );

    @Modifying
    @Query(value = "DELETE FROM mst_wallet WHERE id = ?1", nativeQuery = true)
    void deleteWallet(String id);

    @Query(value = "SELECT * FROM mst_wallet WHERE id =?1", nativeQuery = true)
    Account getWalletById(String id);

    @Modifying
    @Query(value = "UPDATE mst_wallet set balance =:balance WHERE id =:id", nativeQuery = true)
    void updateWallet(
            @Param("id") String id,
            @Param("balance") Integer balance
    );


}
