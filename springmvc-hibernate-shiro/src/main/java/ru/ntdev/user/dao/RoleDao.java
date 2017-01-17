package ru.ntdev.user.dao;

import ru.ntdev.user.entity.RoleEntity;

import java.util.List;

/**
 * Created by artemtursunov on 18.01.17.
 */
public interface RoleDao {
    List<RoleEntity> listRoles();
    RoleEntity getRoleById(int i);
    void addRole(RoleEntity roleEntity);
    void removeRole(int id);
    void updateRole(RoleEntity roleEntity);
}
