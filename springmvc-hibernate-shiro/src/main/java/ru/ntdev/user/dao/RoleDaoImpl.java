package ru.ntdev.user.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.ntdev.user.entity.RoleEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by artemtursunov on 18.01.17.
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    private static final Logger logger = LoggerFactory.getLogger(ResourceTypeDaoImpl.class);
    private SessionFactory sessionFactory;



    @Override
    public List<RoleEntity> listRoles() {
        return null;
    }

    @Override
    public RoleEntity getRoleById(int i) {
        return null;
    }

    @Override
    public void addRole(RoleEntity roleEntity) {

    }

    @Override
    public void removeRole(int id) {

    }

    @Override
    public void updateRole(RoleEntity roleEntity) {

    }
}
