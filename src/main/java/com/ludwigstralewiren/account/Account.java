package com.ludwigstralewiren.account;


import com.ludwigstralewiren.investment.Investment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ludwig on 9/15/2016.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String accountName;
    @Column
    private String password;
    @Column
    private Double accountBalance;
    @OneToMany
    List<Investment> investments = new ArrayList<>();

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }
}
