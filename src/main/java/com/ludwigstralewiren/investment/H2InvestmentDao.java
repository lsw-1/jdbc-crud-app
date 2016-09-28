package com.ludwigstralewiren.investment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static com.ludwigstralewiren.config.HibernateUtil.getSessionFactory;

public class H2InvestmentDao implements InvestmentDao {

    private SessionFactory sessionFactory = getSessionFactory();

    @Override
    public List<Investment> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Investment> criteria =  builder.createQuery(Investment.class);
        criteria.from(Investment.class);
        return session.createQuery(criteria).getResultList();
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
        session.saveOrUpdate(investment);
        session.getTransaction().commit();
        session.close();
        System.out.println("Investment has been saved!");
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
