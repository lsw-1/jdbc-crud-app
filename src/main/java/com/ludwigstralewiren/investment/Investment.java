package com.ludwigstralewiren.investment;

import com.ludwigstralewiren.account.Account;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ludwig on 9/15/2016.
 */
@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String accountName;

    @NotNull
    @Column
    private Long currentValue;
    @ManyToOne
    private Account account;

    public Investment() {
    }

    public Long getId() {
        return id;
    }

    public Long getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Long currentValue) {
        this.currentValue = currentValue;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
