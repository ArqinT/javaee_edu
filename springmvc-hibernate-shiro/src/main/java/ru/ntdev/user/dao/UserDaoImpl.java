/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.user.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.ntdev.user.entity.UserEntity;

/**
 *
 * @author vminakov
 */
@Repository
public class UserDaoImpl implements UserDao{

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> listUsers() {
        
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> userList = session.createQuery("from UserEntity").list();
        for(UserEntity u : userList){
                logger.info("User List::"+u);
        }
        return userList;
    }

    @Override
    public UserEntity getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
        UserEntity u = (UserEntity) session.load(UserEntity.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+u);
        return u;
    }
    
}
