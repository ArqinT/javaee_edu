package ru.ntdev.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ntdev.user.dao.ResourceDao;
import ru.ntdev.user.entity.ResourceEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    private ResourceDao resourceDao;

    @Override
    @Transactional
    public List<ResourceEntity> listResources() {
        return this.resourceDao.listResources();
    }

    @Override
    @Transactional
    public ResourceEntity getResourceById(Integer id) {
        return this.resourceDao.getResourceById(id);
    }

    @Override
    @Transactional
    public void addResource(ResourceEntity resourceEntity) {
        this.resourceDao.addResource(resourceEntity);
    }

    @Override
    @Transactional
    public void removeResource(Integer id) {
        this.resourceDao.removeResource(id);
    }

    @Override
    @Transactional
    public void updateResource(ResourceEntity resourceEntity) {
        this.resourceDao.updateResource(resourceEntity);
    }
}
