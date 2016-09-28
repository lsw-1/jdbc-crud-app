package com.ludwigstralewiren.account;

import com.ludwigstralewiren.investment.Investment;

import java.util.List;

/**
 * Created by Ludwig on 9/27/2016.
 */
public class H2AccountService implements AccountService {

    AccountDao accountDao = new H2AccountDao();
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Investment> getInvestments(Long id) {
        return accountDao.findById(id).getInvestments();
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Account account) {
        accountDao.delete(account);
    }
}
