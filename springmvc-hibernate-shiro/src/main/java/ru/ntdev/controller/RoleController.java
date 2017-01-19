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
import ru.ntdev.user.entity.RoleEntity;
import ru.ntdev.user.service.ResourceItemService;
import ru.ntdev.user.service.RoleService;

/**
 * Created by atursunov on 18.01.17.
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceItemService resourceItemService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequiresAuthentication
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String listRoles(Model model) {
        try {
            model.addAttribute("role", new RoleEntity());
            model.addAttribute("listRoles", this.roleService.listRoles());
            model.addAttribute("listResources", this.resourceItemService.listResources());
            return "roles";
        }
        catch(Exception e) {
            return "welcome";
        }
    }

    @RequiresAuthentication
    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    public String addRole(@ModelAttribute("role") RoleEntity roleEntity) {
        logger.info("roleEntity: "+ roleEntity.getId());

        if(roleEntity.getId() == 0){
            this.roleService.addRole(roleEntity);
        }else{
            this.roleService.updateRole(roleEntity);
        }

        return "redirect:/roles";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/role/remove/{id}", method = RequestMethod.GET)
    public String removeRole(@PathVariable("id") Integer id) {
        this.roleService.removeRole(id);
        return "redirect:/roles";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/role/edit/{id}")
    public String editRole(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("role", this.roleService.getRoleById(id));
        model.addAttribute("listRoles", this.roleService.listRoles());
        model.addAttribute("listResources", this.resourceItemService.listResources());
        return "roles";
    }
}
