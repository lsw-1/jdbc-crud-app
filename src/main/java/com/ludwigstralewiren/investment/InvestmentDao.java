package com.ludwigstralewiren.investment;

import com.ludwigstralewiren.user.User;

import java.util.List;

/**
 * Created by Ludwig on 9/15/2016.
 */
public interface InvestmentDao {
    List<Investment> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);
}
