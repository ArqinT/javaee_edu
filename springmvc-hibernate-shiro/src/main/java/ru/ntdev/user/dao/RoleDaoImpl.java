package ru.ntdev.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ntdev.user.entity.RoleEntity;

import javax.annotation.Resource;
import javax.management.relation.Role;
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
        Session session = this.sessionFactory.getCurrentSession();
        List<RoleEntity> list = session.createQuery(" from RoleEntity").list();
        for (RoleEntity r : list) {
            logger.info("Роль: " + r);
        }
        return list;
    }

    @Override
    public RoleEntity getRoleById(int id) {
        Session session = sessionFactory.getCurrentSession();
        RoleEntity roleEntity = session.load(RoleEntity.class, id);
        logger.info("Получена роль по id: " + roleEntity);
        return roleEntity;
    }

    @Override
    public void addRole(RoleEntity roleEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(roleEntity);
        logger.info("Роль добавлена: " + roleEntity);
    }

    @Override
    public void removeRole(int id) {
        Session session = sessionFactory.getCurrentSession();
        RoleEntity roleEntity = session.load(RoleEntity.class, id);
        session.delete(roleEntity);
        logger.info("Роль успешно удалена: " + roleEntity);
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(roleEntity);
        logger.info("Роль успешно обновлена: " + roleEntity);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
