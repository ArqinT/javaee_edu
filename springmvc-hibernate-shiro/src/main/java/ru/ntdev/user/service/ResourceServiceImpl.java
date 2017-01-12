package ru.ntdev.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ntdev.user.entity.ResourceEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Override
    @Transactional
    public List<ResourceEntity> listResourceTypes() {
        return null;
    }

    @Override
    @Transactional
    public ResourceEntity getResourceTypeById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void addResourceType(ResourceEntity resourceEntity) {

    }

    @Override
    @Transactional
    public void removeResourceType(Integer id) {

    }

    @Override
    @Transactional
    public void updateResourceType(ResourceEntity resourceEntity) {

    }
}
