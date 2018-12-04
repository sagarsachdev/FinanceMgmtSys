package com.finance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finance.model.Card;
import com.finance.model.Login;
import com.finance.model.MD5;
import com.finance.model.Purchase;
import com.finance.model.User;
import com.finance.service.AdminService;
import com.finance.service.CardService;
import com.finance.service.PurchaseService;
import com.finance.service.UserService;

/**
 * 
 * @author Group 9
 *
 */
@Controller
public class LoginController {
  @Autowired
  UserService userService;
  @Autowired
  CardService cardService;
  @Autowired
  AdminService adminService;  
  @Autowired
  PurchaseService purchaseService;
  
  static final int GOLD_VALUE = 40000;
  static final int TITANIUM_VLAUE = 80000;
  
  /**
   * 
   * @return mav : It returns view after completing the process defined in method
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin() {
    ModelAndView mav;
		mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
  }
  
  /**
   * 
   * @return mv : It returns view after completing the process defined in method
   */
  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public ModelAndView showAdminLogin() {
    ModelAndView mv;
		mv = new ModelAndView("adminlogin");
		mv.addObject("admin", new Login());
		return mv;
  }
  
  /**
   * @param login : Accepts object of login model which contains username and password entered by user.
   * @param request : Uses request object to initiate the session 
   * @return mav : It returns view after completing the process defined in method
   */
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(@ModelAttribute("login") Login login, HttpServletRequest request) {
    ModelAndView mav;
		mav = null;
		int cardValue = 0;
		String password = MD5.getMd5(login.getPassword());
		login.setPassword(MD5.getMd5(password));
		User user = userService.validateUser(login);
		if (null != user) {
		    mav = new ModelAndView("welcome");
		    String uname = login.getUname();
		    List<User> lst = adminService.getUsrByUname(uname);
		    List<Card> card = cardService.getCardByName(uname);
		    List<Purchase> purchase = purchaseService.getPurchaseById(lst.get(0).getId());
		    cardValue = lst.get(0).getCard().equals("gold") ? GOLD_VALUE : TITANIUM_VLAUE;
		    mav.addObject("cardValue",cardValue);
		    mav.addObject("purchaseList",purchase);
		    mav.addObject("card",card.get(0));
		    mav.addObject("verify",lst.get(0));
		    HttpSession session = request.getSession();
		    session.setAttribute("verify", lst.get(0));
		} else {
		    mav = new ModelAndView("login");
		    mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
  }
  
  /**
   * 
   * @param request : Uses request object to initiate the session
   * @return mv : It returns view after completing the process defined in method
   */
  @RequestMapping("/logout")
  public ModelAndView logout(HttpServletRequest request) {
	  ModelAndView mv;
		HttpSession session = request.getSession();
		  session.removeAttribute("verify");
		  session.invalidate();
		  mv = new ModelAndView("login");
		  return mv;
  }
  
  /**
   * 
   * @return : It returns view after completing the process defined in method
   */
  @RequestMapping("/forgotPassword")
  public ModelAndView forgot() {
	  return new ModelAndView("forgot");
  }
  
  /**
   * 
   * @param login : Accepts object of Login POJO class for resetting the password
   * @return mv : It returns view after completing the process defined in method
   */
  @RequestMapping(value = "/forgotProcess", method = RequestMethod.POST)
  public ModelAndView forgotProcess(@ModelAttribute Login login) {
	  	  ModelAndView mv = null;
		  String password = MD5.getMd5(login.getPassword());
		  login.setPassword(MD5.getMd5(password));
		  int i = userService.update(login);
		  if(i>0) {
			  mv = new ModelAndView("login");
			  mv.addObject("msg", "Password Successfully Changed");
		  }else {
			  mv = new ModelAndView("forgot");
			  mv.addObject("msg", "Username does not exist");
		  }
		  return mv;
  }
  
  @RequestMapping(value="/changePassword")
  public ModelAndView changePassword() {
	  ModelAndView mv = new ModelAndView("changepassword");
	  return mv;
  }

  @RequestMapping(value="/changeProcess")
  public ModelAndView changeProcess(HttpServletRequest request ,@ModelAttribute Login login) {
	  ModelAndView mv = null;
	  String password = MD5.getMd5(login.getPassword());
	  login.setPassword(MD5.getMd5(password));
	  HttpSession session = request.getSession();
	  User user = (User)session.getAttribute("verify");
	  login.setUname(user.getUname());
	  int i = userService.update(login);
	  if(i>0) {
		  mv = new ModelAndView("login");
		  mv.addObject("msg", "Password Successfully Changed");
	  }else {
		  mv = new ModelAndView("changePassword");
		  mv.addObject("msg", "Couldn't change password");
	  }
	  return mv;
  }
  
  @RequestMapping("*")
  @ResponseBody
  public String fallbackMethod(){
  	return "fallback method";
  }
}