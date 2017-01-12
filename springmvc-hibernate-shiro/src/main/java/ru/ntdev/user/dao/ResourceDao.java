package ru.ntdev.user.dao;

import ru.ntdev.user.entity.ResourceEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
public interface ResourceDao {

    ResourceEntity getResourceById(Integer id);
    List<ResourceEntity> listResources();
    void addResource(ResourceEntity resourceEntity);
    void updateResource(ResourceEntity resourceEntity);
    void removeResource(Integer id);

}
