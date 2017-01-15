package ru.ntdev.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.ntdev.user.entity.ResourceEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
@Repository
public class ResourceDaoImpl implements ResourceDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public ResourceEntity getResourceById(Integer id) {
        return null;
    }

    @Override
    public List<ResourceEntity> listResources() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ResourceEntity> resourceEntityList = session.createQuery("from ResourceEntity").list();
        for(ResourceEntity r : resourceEntityList){
            logger.info("Resourses List::"+r);
        }
        return resourceEntityList;

    }

    @Override
    public void addResource(ResourceEntity resourceEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(resourceEntity);
        logger.info("Ресурс успешно добавлен: "+resourceEntity);
    }

    @Override
    public void updateResource(ResourceEntity resourceEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(resourceEntity);
        logger.info("Ресурс обновлен: "+resourceEntity);
    }

    @Override
    public void removeResource(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        ResourceEntity r = session.load(ResourceEntity.class, id);
        session.delete(r);
        logger.info("Ресурс успешно удален: "+r);
    }
}
