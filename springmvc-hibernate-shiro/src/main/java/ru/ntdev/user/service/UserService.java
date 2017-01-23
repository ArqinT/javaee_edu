/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.user.service;

import java.util.List;
import ru.ntdev.user.entity.UserEntity;

/**
 *
 * @author vminakov
 */
public interface UserService {
    public List<UserEntity> listUsers();
    public UserEntity getUserById(int id);
    void addUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void removeUser(int id);
}
