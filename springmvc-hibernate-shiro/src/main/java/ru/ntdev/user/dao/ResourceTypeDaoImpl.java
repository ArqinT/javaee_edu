package ru.ntdev.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.ntdev.user.entity.ResourceTypeEntity;

import java.util.List;

/**
 * Created by atursunov on 11.01.17.
 */
@Repository
public class ResourceTypeDaoImpl implements ResourceTypeDao {

    private static final Logger logger = LoggerFactory.getLogger(ResourceTypeDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public List<ResourceTypeEntity> listResourceTypes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<ResourceTypeEntity> resourceTypeEntityList = session.createQuery("from ResourceTypeEntity").list();
        for(ResourceTypeEntity r : resourceTypeEntityList){
            logger.info("Resourse Types List::"+r);
        }
        return resourceTypeEntityList;
    }

    @Override
    public ResourceTypeEntity getTypeById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        ResourceTypeEntity r = session.load(ResourceTypeEntity.class, new Integer(id));
        logger.info("Type loaded successfully, Type details="+r);
        return r;
    }

    @Override
    public void addResourceType(ResourceTypeEntity resourceTypeEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(resourceTypeEntity);
        logger.info("Тип успешно добавлен: "+resourceTypeEntity);
    }

    @Override
    public void removeResourceType(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        ResourceTypeEntity rt = (ResourceTypeEntity) session.load(ResourceTypeEntity.class, new Integer(id));
        if(null != rt) {
            session.delete(rt);
            logger.info("Тип успешно удалён: "+rt);
        }
    }

    @Override
    public void updateResourceType(ResourceTypeEntity resourceTypeEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(resourceTypeEntity);
        logger.info("Тип успешно обновлён: "+resourceTypeEntity);
    }
}
