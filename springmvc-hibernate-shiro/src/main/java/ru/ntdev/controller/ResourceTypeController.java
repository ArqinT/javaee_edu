package ru.ntdev.controller;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ntdev.user.entity.ResourceEntity;
import ru.ntdev.user.entity.ResourceTypeEntity;
import ru.ntdev.user.service.ResourceTypeService;

/**
 * Created by atursunov on 11.01.17.
 */
@Controller
public class ResourceTypeController {

    private ResourceTypeService resourceTypeService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired(required=true)
    @Qualifier(value="resourceTypeService")
    public void setResourceTypeService(ResourceTypeService rts){
        this.resourceTypeService = rts;
    }


    @RequiresAuthentication
    @RequestMapping(value = "/resource_types", method = RequestMethod.GET)
    public String listResourceTypes(Model model) {
        try {
            model.addAttribute("resourceType", new ResourceTypeEntity());
            model.addAttribute("listResourceTypes", this.resourceTypeService.listResourceTypes());
            return "resource_types";
        }
        catch(Exception e) {
            return "welcome";
        }
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource_type/add", method = RequestMethod.POST)
    public String addResourceType(@ModelAttribute("resourceType") ResourceTypeEntity rt) {
        if(rt.getId() == 0){
            this.resourceTypeService.addResourceType(rt);
        }else{
            this.resourceTypeService.updateResourceType(rt);
        }

        return "redirect:/resource_types";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource_type/remove/{id}")
    public String removeResourceType(@PathVariable("id") Integer id) {
        this.resourceTypeService.removeResourceType(id);
        return "redirect:/resource_types";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource_type/edit/{id}")
    public String editResourceType(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("resourceType", this.resourceTypeService.getResourceTypeById(id));
        model.addAttribute("listResourceTypes", this.resourceTypeService.listResourceTypes());
        return "resource_types";
    }

}
