package com.example.javaspringbootdemo.repo;

import com.example.javaspringbootdemo.test.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAllByUsernameLike(String str);
    Account findByIdAndUsername(int id, String username);
}
