/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ntdev.user.dao.UserDaoImpl;
import ru.ntdev.user.entity.UserEntity;
import ru.ntdev.user.service.RoleService;
import ru.ntdev.user.service.UserService;

/**
 *
 * @author vminakov
 */
@Controller

public class UserController {
        @Autowired
        @Qualifier(value = "userService")
    	private UserService userService;

    	@Autowired
        @Qualifier(value = "roleService")
    	private RoleService roleService;
        
        private static final Logger logger = LoggerFactory.getLogger(UserController.class);

        @RequiresAuthentication        
        @RequiresPermissions("type2:res2")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listPersons(Model model) {
            try {
                model.addAttribute("user", new UserEntity());
                model.addAttribute("listRoles", this.roleService.listRoles());
                model.addAttribute("listUsers", this.userService.listUsers());
                return "users";
            }
            catch(Exception e) {
                    return "welcome";
            }
            
	}
        
            @RequestMapping(value = "/login")
    public String login(ModelMap model) {      
      return "login"; 
    }
    
    @RequestMapping(value = "/logout")
    public String logout(ModelMap model) {  
      Subject user = SecurityUtils.getSubject();
      String p = user.getPrincipal().toString();
      user.logout();
      logger.info("User logout: "+p);
      return "redirect:/login";
    }


    @RequiresAuthentication
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserEntity userEntity) {
            try {
                logger.info("userEntity: "+ userEntity.getId());
                return "redirect:/users";
//        if(userEntity.getId() == 0){
//            this.userService.addUser(userEntity);
//        }else{
//            this.userService.updateUser(userEntity);
//        }
//
//        return "redirect:/users";
            }
        catch (Exception e) {
            logger.warn("userEntity Exception: "+ e.getMessage());
            return "welcome";
        }
    }

    @RequiresAuthentication
    @RequestMapping(value = "/user/remove/{id}", method = RequestMethod.GET)
    public String removeUser(@PathVariable("id") Integer id) {
        this.userService.removeUser(id);
        return "redirect:/users";
    }

    @RequiresAuthentication
    @RequestMapping(value = "/user/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("role", this.userService.getUserById(id));
        model.addAttribute("listRoles", this.roleService.listRoles());
        model.addAttribute("listUsers", this.userService.listUsers());
        return "users";
    }
}
