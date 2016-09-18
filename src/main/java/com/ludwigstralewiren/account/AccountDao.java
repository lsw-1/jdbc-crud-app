package com.ludwigstralewiren.account;

import com.ludwigstralewiren.user.User;

import java.util.List;

/**
 * Created by Ludwig on 9/15/2016.
 */
public interface AccountDao {
    List<Account> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);
}
