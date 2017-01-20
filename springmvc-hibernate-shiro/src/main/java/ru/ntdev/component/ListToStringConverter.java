package ru.ntdev.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.ntdev.user.entity.ResourceItemEntity;
import ru.ntdev.user.service.ResourceItemService;

import java.util.List;

/**
 * Created by atursunov on 20.01.17.
 */
@Component
public class ListToStringConverter implements Converter<List<ResourceItemEntity>, String> {

    @Autowired
    public ResourceItemService resourceItemService;
    private static final Logger logger = LoggerFactory.getLogger(RoleToResourceItemConverter.class);

    @Override
    public String convert(List<ResourceItemEntity> resourceItemEntities) {
        String str = new String();
        for (ResourceItemEntity resourceItem:resourceItemEntities) {
            str += resourceItem.getId();
        }
        return str;
    }
}
