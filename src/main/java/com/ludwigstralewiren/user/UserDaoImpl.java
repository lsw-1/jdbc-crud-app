package com.ludwigstralewiren.user;

import org.hibernate.SQLQuery;
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
    public void save(User user) {

    /*TO SAVE A ENTITY*/
//        Open session
        Session session = sessionFactory.openSession();
//        Begin transaction
        session.beginTransaction();
//        Use the session to save
        session.saveOrUpdate(user);
//        commit transaction
        session.getTransaction().commit();
//          close
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
    public List findUserByName(String name) {
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM user WHERE userName=:name";
        SQLQuery query = session.createSQLQuery(sql)
                .addEntity(User.class)
                .setParameter("name", name);

        List results = query.list();
        session.close();
        return results;

    }
}
