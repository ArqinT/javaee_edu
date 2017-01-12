package ru.ntdev.user.dao;

import org.springframework.stereotype.Repository;
import ru.ntdev.user.entity.ResourceEntity;

import java.util.List;

/**
 * Created by atursunov on 12.01.17.
 */
@Repository
public class ResourceDaoImpl implements ResourceDao {
    @Override
    public ResourceEntity getResourceById(Integer id) {
        return null;
    }

    @Override
    public List<ResourceEntity> listResources() {
        return null;
    }

    @Override
    public void addResource(ResourceEntity resourceEntity) {

    }

    @Override
    public void updateResource(ResourceEntity resourceEntity) {

    }

    @Override
    public void removeResource(Integer id) {

    }
}
