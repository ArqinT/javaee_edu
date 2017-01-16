package ru.ntdev.user.dao;

import ru.ntdev.user.entity.ResourceItemEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
public interface ResourceItemDao {
    ResourceItemEntity getResourceById(Integer id);
    List<ResourceItemEntity> listResources();
    void addResourceItem(ResourceItemEntity resourceItemEntity);
    void updateResourceItem(ResourceItemEntity resourceItemEntity);
    void removeResourceItem(Integer id);
}
