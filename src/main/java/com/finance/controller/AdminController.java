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

import com.finance.dao.AdminDao;
import com.finance.model.Login;
import com.finance.model.User;

@Controller
public class AdminController {
	@Autowired
	AdminDao adao;
	private int value;
	
	/**
	 * @param request
	 * @param l
	 * @return object mv
	 * @throws ServerException
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value="/adminloginProcess", method = RequestMethod.POST)
	  public ModelAndView adminloginProcess(HttpServletRequest request, @ModelAttribute Login l) throws ServerException,IOException, ServletException {
		  ModelAndView mv = null;
		  if(l.getUname().equals("admin") && l.getPassword().equals("admin")) {
			  List<User> lst = new ArrayList<User>();
				lst = adao.getAllUsers();
				request.setAttribute("usrList",lst);
			  mv = new ModelAndView("userinfo");
		  }else {
			  mv = new ModelAndView("adminlogin");
			  mv.addObject("message", "Username or Password is wrong!!");
		  }
		  return mv;
	  }
	
	/**
	 * 
	 * @param request
	 * @return to userinfo page with lst
	 */
	@RequestMapping("/userinfo")
		public ModelAndView display(HttpServletRequest request) {
		List<User> lst = new ArrayList<User>();
		lst = adao.getAllUsers();
		request.setAttribute("usrList",lst);
			return new ModelAndView("userinfo");
		}
	 
	/**
	  * 
	  * @param id
	  * @return ModelAndView object and redirect to usreditform 
	  */
	 @RequestMapping(value="/editusr/{id}")  
	    public ModelAndView edit(@PathVariable int id){  
		 	User u = new User();
		 	u.setId(id);
		 	value = u.getId();
	        List<User> usr=adao.getUsrById(id);  
	        return new ModelAndView("usreditform","command",usr.get(0));  
	    }  
	 
	 /**
	  * 
	  * @param usr
	  * @return ModelAndView object
	  */
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("usr") User usr){  
		 	usr.setId(value);
	        adao.updateUser(usr);  
	        return new ModelAndView("redirect:/userinfo");  
	    }  
	 
	 /**
	  * @param id
	  * @return ModelAndView object
	  */
	 @RequestMapping(value="/deleteusr/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
	        adao.delete(id);  
	        return new ModelAndView("redirect:/userinfo");  
	    }  
}
