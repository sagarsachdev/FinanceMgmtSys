package com.finance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finance.model.User;
import com.finance.service.CardService;
import com.finance.service.UserService;

@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;
  @Autowired
  public CardService cardService;
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister() {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    return mav;
  }
  
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(@ModelAttribute("user") User user) {
  ModelAndView mv = new ModelAndView("login");
  int i = userService.register(user);
  int j = cardService.insertCard(user);
  if(i>0 && j>0) {
   mv.addObject("firstname", user.getName());
  }
  return mv;
  }
  
  
  @RequestMapping("/terms")
  public ModelAndView terms() {
	  return new ModelAndView("terms");
  }
}
