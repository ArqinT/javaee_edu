package ru.ntdev.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ntdev.user.dao.ResourceItemDao;
import ru.ntdev.user.entity.ResourceItemEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
@Service
public class ResourceItemServiceImpl implements ResourceItemService {

    @Autowired
    private ResourceItemDao resourceItemDao;

    @Override
    @Transactional
    public List<ResourceItemEntity> listResources() {
        return this.resourceItemDao.listResources();
    }

    @Override
    @Transactional
    public ResourceItemEntity getResourceById(Integer id) {
        return this.resourceItemDao.getResourceById(id);
    }

    @Override
    @Transactional
    public void addResourceItem(ResourceItemEntity resourceItemEntity) {
        this.resourceItemDao.addResourceItem(resourceItemEntity);
    }

    @Override
    @Transactional
    public void removeResourceItem(Integer id) {
        this.resourceItemDao.removeResourceItem(id);
    }

    @Override
    @Transactional
    public void updateResourceItem(ResourceItemEntity resourceItemEntity) {
        this.resourceItemDao.updateResourceItem(resourceItemEntity);
    }
}
