package ru.ntdev.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ntdev.user.dao.ResourceTypeDao;
import ru.ntdev.user.entity.ResourceTypeEntity;

import java.util.List;

/**
 * Created by atursunov on 11.01.17.
 */
@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {

    private ResourceTypeDao resourceTypeDao;

    @Override
    @Transactional
    public List<ResourceTypeEntity> listResourceTypes() {
        return this.resourceTypeDao.listResourceTypes();
    }

    @Override
    @Transactional
    public ResourceTypeEntity getResourceTypeById(Integer id) {
        return this.resourceTypeDao.getTypeById(id);
    }

    @Override
    @Transactional
    public void addResourceType(ResourceTypeEntity resourceTypeEntity) {
        this.resourceTypeDao.addResourceType(resourceTypeEntity);
    }

    @Override
    @Transactional
    public void removeResourceType(Integer id) {
        this.resourceTypeDao.removeResourceType(id);
    }

    @Override
    @Transactional
    public void updateResourceType(ResourceTypeEntity resourceTypeEntity) {
        this.resourceTypeDao.updateResourceType(resourceTypeEntity);
    }

    public ResourceTypeDao getResourceTypeDao() {
        return resourceTypeDao;
    }

    public void setResourceTypeDao(ResourceTypeDao resourceTypeDao) {
        this.resourceTypeDao = resourceTypeDao;
    }


}
