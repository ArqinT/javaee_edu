package ru.ntdev.user.service;

import org.springframework.stereotype.Service;
import ru.ntdev.user.entity.ResourceEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
public interface ResourceService {

    List<ResourceEntity> listResources();

    ResourceEntity getResourceById(Integer id);

    void addResource(ResourceEntity resourceEntity);

    void removeResource(Integer id);

    void updateResource(ResourceEntity resourceEntity);
}
