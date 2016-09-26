package com.ludwigstralewiren.investment;

import com.ludwigstralewiren.account.Account;
import com.ludwigstralewiren.investment.Investment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static com.ludwigstralewiren.config.HibernateUtil.getSessionFactory;

/**
 * Created by ludwi on 2016-09-19.
 */
public class InvestmentDaoImpl implements InvestmentDao {

    SessionFactory sessionFactory = getSessionFactory();

    @Override
    public List<Investment> findAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Investment> criteria =  builder.createQuery(Investment.class);

        criteria.from(Investment.class);

        List<Investment> investments = session.createQuery(criteria).getResultList();

        return investments;
    }

    @Override
    public Investment findById(Long id) {
        Session session = sessionFactory.openSession();

        Investment investment = session.get(Investment.class, id);

        session.close();

        return investment;
    }

    @Override
    public void save(Investment investment) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(investment);

        session.getTransaction().commit();

        session.close();

        System.out.println("Investment has been saved!");
    }

    @Override
    public void update(Investment investment) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(investment);

        session.getTransaction().commit();

        session.close();

        System.out.println("Investment has been updated!");

    }

    @Override
    public void delete(Investment investment) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(investment);

        session.getTransaction().commit();

        session.close();

        System.out.println("Investment has been deleted!");
    }
}
