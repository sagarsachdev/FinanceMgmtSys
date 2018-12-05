package com.finance.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finance.model.Login;
import com.finance.model.User;
import com.finance.service.AdminService;

/**
 * 
 * @author Group 1
 *
 */
@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	private int value;
	static final String USERNAME = "admin";
	static final String PASSWORD = "admin";

	/**
	 * This method is used for logging in the admin
	 * @param request : It is used to set some attribute
	 * @param l : It is object of Login POJO class
	 * @return mv : It returns view after completing the process defined in method
	 * @throws ServerException : Used to throw server exception
	 * @throws IOException : Used to throw IO exception
	 * @throws ServletException : Used to throw Servlet exception
	 */
	@RequestMapping(value="/adminloginProcess", method = RequestMethod.POST)
	public ModelAndView adminloginProcess(HttpServletRequest request, @ModelAttribute Login l) throws ServerException,IOException, ServletException {
		ModelAndView mv = null;
			if(l.getUname().equals(USERNAME) && l.getPassword().equals(PASSWORD)) {
				List<User> lst = new ArrayList<User>();
				lst = adminService.getAllUsers();
				request.setAttribute("usrList",lst);
				mv = new ModelAndView("userinfo");
			}else {
				mv = new ModelAndView("adminlogin");
				mv.addObject("message", "Username or Password is wrong!!");
			}
		return mv;
	}

	/**
	 * This method is used for displaying all the users registered
	 * @param request : It is used to set some attribute
	 * @return : It returns view after completing the process defined in method
	 */
	@RequestMapping("/userinfo")
	public ModelAndView display(HttpServletRequest request) {
		ModelAndView mv;
			List<User> lst = new ArrayList<User>();
			lst = adminService.getAllUsers();
			request.setAttribute("usrList",lst);
			mv = new ModelAndView("userinfo");
		return mv;
	}

	/**
	 * This method is used to edit user's details such as verifying the user
	 * @param id : Accepts userId to edit user's profile
	 * @return : It returns view after completing the process defined in method
	 */
	@RequestMapping(value="/editusr/{id}")  
	public ModelAndView edit(@PathVariable int id){  
		ModelAndView mv;
			User u = new User();
			u.setId(id);
			value = u.getId();
			List<User> usr=adminService.getUsrById(id);  
			mv = new ModelAndView("usreditform","command",usr.get(0));
			return mv;
	}  

	/**
	 * This method is used to save the changes made by admin
	 * @param usr : Accepts user object to set attributes in POJO class
	 * @return : It returns view after completing the process defined in method
	 */
	@RequestMapping(value="/editsave",method = RequestMethod.POST)  
	public ModelAndView editsave(@ModelAttribute("usr") User usr){  
		ModelAndView mv;
			usr.setId(value);
			adminService.updateUser(usr);  
			mv = new ModelAndView("redirect:/userinfo"); 
			return mv;
	}  

	/** This method is used to delete some user by admin
	 * @param id : Accepts userId in order to delete user's account
	 * @return : It returns view after completing the process defined in method
	 */
	@RequestMapping(value="/deleteusr/{id}",method = RequestMethod.GET)  
	public ModelAndView delete(@PathVariable int id){  
		ModelAndView mv;
			adminService.delete(id);  
			mv = new ModelAndView("redirect:/userinfo");
			return mv;
	}  
}
