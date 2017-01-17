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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ntdev.user.dao.UserDaoImpl;
import ru.ntdev.user.entity.UserEntity;
import ru.ntdev.user.service.UserService;

/**
 *
 * @author vminakov
 */
@Controller

public class UserController {
    	private UserService userService;
        
        private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService = us;
	}
        @RequiresAuthentication        
        @RequiresPermissions("type2:res2")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listPersons(Model model) {
            try {
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
}
