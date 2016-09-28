package com.ludwigstralewiren.account;

import com.ludwigstralewiren.account.Account;

import java.util.List;


public interface AccountDao {
    List<Account> findAll();
    Account findById(Long id);
    void save(Account user);
    void delete(Account user);
}
