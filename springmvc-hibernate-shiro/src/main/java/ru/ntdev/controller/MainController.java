/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ntdev.user.dao.UserDaoImpl;
import ru.ntdev.user.entity.UserEntity;

import org.apache.shiro.crypto.hash.Sha512Hash;

/**
 *
 * @author vminakov
 */

@Controller
public class MainController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
     
    @RequestMapping(value = "/hello")
    public String welcome(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      Sha512Hash df = new Sha512Hash("123", null, 50000);
      logger.info(df.toString());
      return "welcome"; 
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView hello() {
                String principal = "";
                try{
                    principal = SecurityUtils.getSubject().getPrincipal().toString();
                }catch(Exception e) {
                    logger.info("Welcome Controller:: no principal found"+e.getMessage());
                }
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		model.addObject("message", "Welcome: "+principal);

		return model;

	}
        
}
