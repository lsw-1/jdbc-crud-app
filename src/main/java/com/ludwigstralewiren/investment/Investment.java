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
    @GeneratedValue
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
