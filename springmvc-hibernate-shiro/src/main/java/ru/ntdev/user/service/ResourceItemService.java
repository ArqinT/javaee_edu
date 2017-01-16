package ru.ntdev.user.service;

import org.springframework.stereotype.Service;
import ru.ntdev.user.entity.ResourceItemEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
public interface ResourceItemService {

    List<ResourceItemEntity> listResources();

    ResourceItemEntity getResourceById(Integer id);

    void addResourceItem(ResourceItemEntity resourceItemEntity);

    void removeResourceItem(Integer id);

    void updateResourceItem(ResourceItemEntity resourceItemEntity);
}
