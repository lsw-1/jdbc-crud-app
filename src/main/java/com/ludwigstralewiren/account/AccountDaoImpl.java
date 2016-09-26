package com.ludwigstralewiren.account;

import com.ludwigstralewiren.config.HibernateUtil;
import com.ludwigstralewiren.account.Account;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.stream.IntStream;

import static com.ludwigstralewiren.config.HibernateUtil.getSessionFactory;

/**
 * Created by ludwi on 2016-09-19.
 */
public class AccountDaoImpl implements AccountDao {

    private SessionFactory sessionFactory = getSessionFactory();

    @Override
    public List<Account> findAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Account> criteriaQuery = builder.createQuery(Account.class);

        criteriaQuery.from(Account.class);

        List<Account> accounts = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return accounts;
    }

    @Override
    public Account findById(Long id) {
        Session session = sessionFactory.openSession();

        Account account = session.get(Account.class, id);

        session.close();

        return account;
    }

    @Override
    public void save(Account account) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(account);

        session.getTransaction().commit();

        session.close();

        System.out.println("Account has been saved!");

    }

    @Override
    public void update(Account account) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(account);

        session.getTransaction().commit();

        session.close();

        System.out.println("Account has been updated!");

    }

    @Override
    public void delete(Account account) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(account);

        session.getTransaction().commit();

        session.close();

        System.out.println("Account has been deleted!");
    }
}
