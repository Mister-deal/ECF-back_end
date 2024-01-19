package org.example.DAO;

import org.example.utils.SessionFact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.List;

public interface InterfaceDAO<T>{
    SessionFactory sessionFactory= SessionFact.getFactory();

    default void create(T element) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    default T getById(long id) {
        Session session = sessionFactory.openSession();
        T element = session.get(getEntityClass(), id);
        session.close();
        return element;
    }

    default void remove(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            T element = session.get(getEntityClass(), id);
            session.remove(element);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    default List<T> getAll() {
        Session session = sessionFactory.openSession();
        String queryString="from "+getEntityClass().getName();
        Query<T> query = session.createQuery(queryString,getEntityClass());
        List<T> result = query.getResultList();
        session.close();
        return result;
    }

    Class<T> getEntityClass();
}
