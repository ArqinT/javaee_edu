package ru.ntdev.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.ntdev.user.entity.ResourceItemEntity;
import ru.ntdev.user.service.ResourceItemService;

/**
 * Created by atursunov on 19.01.17.
 */
@Component
public class RoleToResourceItemConverter implements Converter<Object, ResourceItemEntity> {

    @Autowired
    public ResourceItemService resourceItemService;
    private static final Logger logger = LoggerFactory.getLogger(RoleToResourceItemConverter.class);

    @Override
    public ResourceItemEntity convert(Object o) {
        Integer id = Integer.parseInt((String) o);
        ResourceItemEntity resourceItemEntity = resourceItemService.getResourceById(id);
        logger.info("Конвертирование id в сущность: "+resourceItemEntity);
        return resourceItemEntity;
    }
}
