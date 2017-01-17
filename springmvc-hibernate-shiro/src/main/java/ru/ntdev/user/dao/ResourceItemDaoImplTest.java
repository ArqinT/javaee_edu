package ru.ntdev.user.dao;

import ru.ntdev.user.entity.ResourceItemEntity;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by artemtursunov on 18.01.17.
 */
public class ResourceItemDaoImplTest {
    @org.junit.Test
    public void getResourceById() throws Exception {

    }

    @org.junit.Test
    public void listResources() throws Exception {
        ResourceItemDao  resourceItemDao = new ResourceItemDaoImpl();
        List<ResourceItemEntity> list = resourceItemDao.listResources();
        for(ResourceItemEntity resourceItemEntity:list) {
            System.out.println("Resource: "+resourceItemEntity);
        }
    }

    @org.junit.Test
    public void addResourceItem() throws Exception {

    }

    @org.junit.Test
    public void updateResourceItem() throws Exception {

    }

    @org.junit.Test
    public void removeResourceItem() throws Exception {

    }

}