package com.ludwigstralewiren.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static com.ludwigstralewiren.config.HibernateUtil.getSessionFactory;

/**
 * Created by Ludwig on 9/18/2016.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory = getSessionFactory();

    @Override
    public List<User> findAll() {
        //        Open session
        Session session = sessionFactory.openSession();

//        Create criteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

//        Create CriteriaQuery
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

//        Specify criteria root
        criteriaQuery.from(User.class);
//        Execute
        List<User> users = session.createQuery(criteriaQuery).getResultList();

//        Close session
        session.close();

        return users;
    }

    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();

        User user = session.get(User.class, id);

        session.close();

        return user;
    }

    @Override
    public Long save(User user) {

    /*TO SAVE A ENTITY*/
//        Open session
        Session session = sessionFactory.openSession();
//        Begin transaction
        session.beginTransaction();
//        Use the session to save
        Long id = (Long) session.save(user);
//        commit transaction
        session.getTransaction().commit();
//          close
        session.close();

        return id;
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(user);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(user);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public String findUserByName(String name) {
        Session session = sessionFactory.openSession();

//TODO: Make a query to search for user with corresponding name and IF not existing alert user

        session.close();

        return null;
    }
}
