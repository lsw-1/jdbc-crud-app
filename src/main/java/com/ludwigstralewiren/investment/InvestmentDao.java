package com.ludwigstralewiren.investment;

import com.ludwigstralewiren.investment.Investment;

import java.util.List;

/**
 * Created by Ludwig on 9/15/2016.
 */
public interface InvestmentDao {
    List<Investment> findAll();
    Investment findById(Long id);
    void save(Investment investment);
    void update(Investment investment);
    void delete(Investment investment);
}
