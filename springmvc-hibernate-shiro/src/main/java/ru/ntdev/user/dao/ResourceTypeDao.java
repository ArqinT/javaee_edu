package ru.ntdev.user.dao;

import ru.ntdev.user.entity.ResourceTypeEntity;

import java.util.List;

/**
 * Created by atursunov on 11.01.17.
 */
public interface ResourceTypeDao {
    List<ResourceTypeEntity> listResourceTypes();
    ResourceTypeEntity getTypeById(Integer id);
    void addResourceType(ResourceTypeEntity resourceTypeEntity);
    void removeResourceType(Integer id);
    void updateResourceType(ResourceTypeEntity resourceTypeEntity);
}
