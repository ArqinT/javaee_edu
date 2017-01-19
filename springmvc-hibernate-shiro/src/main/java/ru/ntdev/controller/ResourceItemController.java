package ru.ntdev.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ntdev.user.entity.ResourceItemEntity;
import ru.ntdev.user.service.ResourceItemService;
import org.springframework.ui.Model;

/**
 * Created by atursunov on 12.01.17.
 */
@Controller
public class ResourceItemController {
    private ResourceItemService resourceItemService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequiresAuthentication
    @RequestMapping(value = "/resource_items", method = RequestMethod.GET)
    public String listResources(Model model) {
        try {
            model.addAttribute("resourceItem", new ResourceItemEntity());
            model.addAttribute("listResources", this.resourceItemService.listResources());
            return "resource_items";
        }
        catch (Exception e) {
            logger.info(e.getMessage());
            return "welcome";
        }
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource/add", method = RequestMethod.POST)
    public String addResourceItem(@ModelAttribute("resourceItem") ResourceItemEntity rt) {
        if(rt.getId() == 0){
            this.resourceItemService.addResourceItem(rt);
        }else{
            this.resourceItemService.updateResourceItem(rt);
        }

        return "redirect:/resource_items";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource/remove/{id}")
    public String removeResourceItem(@PathVariable("id") Integer id) {
        this.resourceItemService.removeResourceItem(id);
        return "redirect:/resource_items";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource/edit/{id}")
    public String editResourceItem(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("resource", this.resourceItemService.getResourceById(id));
        model.addAttribute("listResource", this.resourceItemService.listResources());
        return "resource_items";
    }

    @Autowired
    @Qualifier(value="resourceItemService")
    public void setResourceItemService(ResourceItemService resourceItemService) {
        this.resourceItemService = resourceItemService;
    }
}
