package com.ludwigstralewiren.investment;

import com.ludwigstralewiren.account.Account;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ludwig on 9/15/2016.
 */
@Entity
@Proxy(lazy = false)
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double currentValue;

    @ManyToOne
    private Account account;
    public Investment() {
    }

    @Override
    public String toString() {
        return "Investment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentValue=" + currentValue +
                ", account=" + account +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Investment that = (Investment) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (currentValue != null ? !currentValue.equals(that.currentValue) : that.currentValue != null) return false;
        return account != null ? account.equals(that.account) : that.account == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (currentValue != null ? currentValue.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }
}
