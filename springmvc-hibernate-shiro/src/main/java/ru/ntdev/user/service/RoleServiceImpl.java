package ru.ntdev.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ntdev.user.dao.RoleDao;
import ru.ntdev.user.entity.RoleEntity;

import java.util.List;

/**
 * Created by atursunov on 18.01.17.
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;


    @Override
    @Transactional
    public List<RoleEntity> listRoles() {
        return this.roleDao.listRoles();
    }

    @Override
    @Transactional
    public RoleEntity getRoleById(int id) {
        return this.roleDao.getRoleById(id);
    }

    @Override
    @Transactional
    public void addRole(RoleEntity roleEntity) {
        this.roleDao.addRole(roleEntity);
    }

    @Override
    @Transactional
    public void removeRole(int id) {
        this.roleDao.removeRole(id);
    }

    @Override
    @Transactional
    public void updateRole(RoleEntity roleEntity) {
        this.roleDao.updateRole(roleEntity);
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
