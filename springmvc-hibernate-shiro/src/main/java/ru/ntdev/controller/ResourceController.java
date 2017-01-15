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
import ru.ntdev.user.entity.ResourceEntity;
import ru.ntdev.user.service.ResourceService;
import org.springframework.ui.Model;

/**
 * Created by atursunov on 12.01.17.
 */
@Controller
public class ResourceController {
    private ResourceService resourceService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier(value="resourceService")
    public void setresourceService(ResourceService rs){
        this.resourceService = rs;
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public String listResources(Model model) {
        try {
            model.addAttribute("resource", new ResourceEntity());
            model.addAttribute("listResources", this.resourceService.listResources());
            return "resources";
        }
        catch (Exception e) {
            return "welcome";
        }
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource/add", method = RequestMethod.POST)
    public String addResourceType(@ModelAttribute("resource") ResourceEntity rt) {
        if(rt.getId() == 0){
            this.resourceService.addResource(rt);
        }else{
            this.resourceService.updateResource(rt);
        }

        return "redirect:/resources";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource/remove/{id}")
    public String removeResource(@PathVariable("id") Integer id) {
        this.resourceService.removeResource(id);
        return "redirect:/resources";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/resource/edit/{id}")
    public String editResource(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("resource", this.resourceService.getResourceById(id));
        model.addAttribute("listResource", this.resourceService.listResources());
        return "resources";
    }
}
