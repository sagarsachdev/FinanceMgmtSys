package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finance.model.User;
import com.finance.service.CardService;
import com.finance.service.UserService;

/**
 * 
 * @author SmartBiz
 *
 */
@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;
  @Autowired
  public CardService cardService;
  
  /**
   * 
   * @return mav : It returns view after completing the process defined in method
   */
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister() {
    ModelAndView mav;
	try {
		mav = new ModelAndView("register");
		mav.addObject("user", new User());
	} catch (Exception e) {
		mav = new ModelAndView("error","message",e);
	}
    return mav;
  }
  
  /**
   * 
   * @param user : Accepts user object in order to set different attributes defined in User POJO class
   * @return mv : It returns view after completing the process defined in method
   */
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(@ModelAttribute("user") User user) {
  ModelAndView mv;
	try {
		mv = new ModelAndView("login");
		  int i = userService.register(user);
		  int j = cardService.insertCard(user);
		  if(i>0 && j>0) {
		   mv.addObject("firstname", user.getName());
		  }
	} catch (Exception e) {
		mv = new ModelAndView("error","message",e);
	}
  return mv;
  }
  
  /**
   * 
   * @return mv : It returns view after completing the process defined in method
   */
  @RequestMapping("/terms")
  public ModelAndView terms() {
	  ModelAndView mv;
		try {
			mv = new ModelAndView("terms");
		} catch (Exception e) {
			mv = new ModelAndView("error","message",e);
		}
	  return mv;
  }
}
