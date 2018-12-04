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
 * @author Group 9
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
		mav = new ModelAndView("register");
		mav.addObject("user", new User());
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
		mv = new ModelAndView("login");
		  int i = userService.register(user);
		  int j = cardService.insertCard(user);
		  if(i>0 && j>0) {
		   mv.addObject("firstname", user.getName());
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
			mv = new ModelAndView("terms");
			return mv;
  }
}
