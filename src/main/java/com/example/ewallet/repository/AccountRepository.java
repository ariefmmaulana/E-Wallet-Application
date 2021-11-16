package com.example.ewallet.repository;

import com.example.ewallet.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT * FROM mst_account", nativeQuery = true)
    List<Account> accounts();

    @Modifying
    @Query(value = "INSERT INTO mst_account(id, full_name, email, address, username, password, phone_number) " +
            "values (:id, :full_name, :email, :address, :username, :password, :phone_number)", nativeQuery = true)
    void createAccount(
            @Param("id") String id,
            @Param("full_name") String full_name,
            @Param("email") String email,
            @Param("address") String address,
            @Param("username") String username,
            @Param("password") String password,
            @Param("phone_number") String phone_number
    );

    @Modifying
    @Query(value = "UPDATE mst_account set email =:email," +
            "password =:password," +
            "phone_number =:phone_number WHERE id = :id", nativeQuery = true)
    void updateAccount(
            @Param("email") String email,
            @Param("password") String password,
            @Param("phone_number") String phone_number,
            @Param("id") String id
    );

    @Modifying
    @Query(value = "DELETE FROM mst_account WHERE id = ?1", nativeQuery = true)
    void deleteAccount(String id);

    @Query(value = "SELECT * FROM mst_account WHERE id =?1", nativeQuery = true)
    Account getAccountById(String id);
}
