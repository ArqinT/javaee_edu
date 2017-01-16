package ru.ntdev.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.ntdev.user.entity.ResourceItemEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
@Repository
public class ResourceItemDaoImpl implements ResourceItemDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public ResourceItemEntity getResourceById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        ResourceItemEntity r = session.load(ResourceItemEntity.class, new Integer(id));
        logger.info("Resource loaded successfully: "+r);
        return r;
    }

    @Override
    public List<ResourceItemEntity> listResources() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ResourceItemEntity> resourceItemEntityList = session.createQuery("from ResourceItemEntity").list();
        for(ResourceItemEntity r : resourceItemEntityList){
            logger.info("Resourses List::"+r);
        }
        return resourceItemEntityList;

    }

    @Override
    public void addResourceItem(ResourceItemEntity resourceItemEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(resourceItemEntity);
        logger.info("Ресурс успешно добавлен: "+resourceItemEntity);
    }

    @Override
    public void updateResourceItem(ResourceItemEntity resourceItemEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(resourceItemEntity);
        logger.info("Ресурс обновлен: "+resourceItemEntity);
    }

    @Override
    public void removeResourceItem(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        ResourceItemEntity r = session.load(ResourceItemEntity.class, id);
        session.delete(r);
        logger.info("Ресурс успешно удален: "+r);
    }
}
