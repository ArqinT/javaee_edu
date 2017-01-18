package ru.ntdev.user.service;

import ru.ntdev.user.entity.RoleEntity;

import java.util.List;

/**
 * Created by atursunov on 18.01.17.
 */
public interface RoleService {

    List<RoleEntity> listRoles();
    RoleEntity getRoleById(int id);
    void addRole(RoleEntity roleEntity);
    void removeRole(int id);
    void updateRole(RoleEntity roleEntity);
}
