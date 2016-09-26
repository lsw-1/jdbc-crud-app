package com.ludwigstralewiren.account;

import com.ludwigstralewiren.account.Account;

import java.util.List;

/**
 * Created by Ludwig on 9/15/2016.
 */
public interface AccountDao {
    List<Account> findAll();
    Account findById(Long id);
    void save(Account user);
    void update(Account user);
    void delete(Account user);
}
