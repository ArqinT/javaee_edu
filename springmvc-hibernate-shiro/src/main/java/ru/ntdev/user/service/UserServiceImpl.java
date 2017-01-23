/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ntdev.user.dao.UserDao;
import ru.ntdev.user.entity.UserEntity;

/**
 * @author vminakov
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<UserEntity> listUsers() {
        return this.userDao.listUsers();
    }

    @Override
    @Transactional
    public UserEntity getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void addUser(UserEntity userEntity) {
        this.userDao.addUser(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        this.userDao.updateUser(userEntity);
    }

    @Override
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

}
