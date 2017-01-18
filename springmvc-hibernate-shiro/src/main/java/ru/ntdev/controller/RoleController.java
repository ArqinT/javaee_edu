package ru.ntdev.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ntdev.user.entity.RoleEntity;
import ru.ntdev.user.service.RoleService;

/**
 * Created by atursunov on 18.01.17.
 */
@Controller
public class RoleController {

    private RoleService roleService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier(value="roleService")
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequiresAuthentication
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String listRoles(Model model) {
        try {
            model.addAttribute("role", new RoleEntity());
            model.addAttribute("listRoles", this.roleService.listRoles());
            return "roles";
        }
        catch(Exception e) {
            return "welcome";
        }
    }
}
