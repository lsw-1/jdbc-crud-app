package com.ludwigstralewiren.account;

import com.ludwigstralewiren.account.Account;
import com.ludwigstralewiren.investment.Investment;

import java.util.List;

/**
 * Created by Ludwig on 9/27/2016.
 */
public interface AccountService {
    List<Account> findAll();
    Account findById(Long id);
    List<Investment> getInvestments(Long id);
    void save(Account account);
    void delete(Account account);
}
