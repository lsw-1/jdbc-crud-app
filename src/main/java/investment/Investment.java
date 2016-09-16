package investment;

import account.Account;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ludwig on 9/15/2016.
 */
@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long currentValue;
    private Map<Long, Date> valueAtDate;
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

    public Map<Long, Date> getValueAtDate() {
        return valueAtDate;
    }

    public void setValueAtDate(Map<Long, Date> valueAtDate) {
        this.valueAtDate = valueAtDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
