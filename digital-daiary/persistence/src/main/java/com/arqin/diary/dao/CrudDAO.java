package com.arqin.diary.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by artemtursunov on 15.12.16.
 */
public class CrudDAO {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static Logger logger = LoggerFactory.getLogger(CrudDAO.class);

    public static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (HibernateException ex)
        {
            System.out.println("Problem creating session factory");
            ex.printStackTrace();
        }
    }

    /**
     * 
     * @param entity
     * @return
     */
    public Serializable addEntity(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Serializable id = session.save(entity);
        session.getTransaction().commit();
        return id;

    }

    public void updateEntity(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void deleteEntity(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public Object getEntity(Class className, Long entityId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Object entity = session.get(className, entityId);
        session.getTransaction().commit();
        return entity;
    }
}
