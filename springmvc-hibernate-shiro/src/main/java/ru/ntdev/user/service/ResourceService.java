package ru.ntdev.user.service;

import ru.ntdev.user.entity.ResourceEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
public interface ResourceService {

    List<ResourceEntity> listResourceTypes();

    ResourceEntity getResourceTypeById(Integer id);

    void addResourceType(ResourceEntity resourceEntity);

    void removeResourceType(Integer id);

    void updateResourceType(ResourceEntity resourceEntity);
}
