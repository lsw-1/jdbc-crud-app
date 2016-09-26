package com.ludwigstralewiren.account;


import com.ludwigstralewiren.investment.Investment;
import com.ludwigstralewiren.user.User;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * Created by Ludwig on 9/15/2016.
 */
@Entity
@Proxy(lazy = false)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountType;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Investment> investments = new ArrayList<>();

    public Account() {
    }

    public Account(Long id){
        this.id = id;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountType='" + accountType + '\'' +
                ", investments=" + investments +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String  getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void addInvestment(Investment investment) {
        investments.add( investment );
        investment.setAccount(this);
    }

    public void removeInvestment(Investment investment) {
        investments.remove( investment );
        investment.setAccount( null );
    }

}
