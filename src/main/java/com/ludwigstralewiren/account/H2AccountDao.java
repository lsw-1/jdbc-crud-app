package com.ludwigstralewiren.account;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static com.ludwigstralewiren.config.HibernateUtil.getSessionFactory;

public class H2AccountDao implements AccountDao {

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
        Hibernate.initialize(account.getInvestments());
        session.close();
        return account;
    }

    @Override
    public void save(Account account) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.saveOrUpdate(account);

        session.getTransaction().commit();

        session.close();

        System.out.println("Account has been saved!");

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
