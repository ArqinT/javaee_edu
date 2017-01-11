package ru.ntdev.user.service;

import ru.ntdev.user.entity.ResourceTypeEntity;

import java.util.List;

/**
 * Created by atursunov on 11.01.17.
 */
public interface ResourceTypeService {

    List<ResourceTypeEntity> listResourceTypes();

    ResourceTypeEntity getResourceTypeById(Integer id);

    void addResourceType(ResourceTypeEntity resourceTypeEntity);

    void removeResourceType(Integer id);

    void updateResourceType(ResourceTypeEntity resourceTypeEntity);
}

