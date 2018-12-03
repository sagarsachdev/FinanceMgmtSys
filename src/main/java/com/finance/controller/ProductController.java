package com.finance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finance.model.Card;
import com.finance.model.Product;
import com.finance.model.Purchase;
import com.finance.model.User;
import com.finance.service.AdminService;
import com.finance.service.CardService;
import com.finance.service.ProductService;
import com.finance.service.PurchaseService;


@Controller
public class ProductController {
    @Autowired  
    ProductService productService;  
    
    @Autowired
    PurchaseService purchaseService;
    
    @Autowired
    AdminService adminService;
    
    @Autowired
    CardService cardService;
    
    /**
     * 
     * @return list
     */
    @RequestMapping("/viewproduct1")  
    public ModelAndView viewproduct(){  
       List<Product> list=productService.getProducts();   
       return new ModelAndView("viewproduct","list",list);  
    }
    
    /**
     * @param productId
     * @return object mv
     */
    @RequestMapping(value="/searchpro/{productId}")  
    public ModelAndView edit(HttpServletRequest request,@PathVariable int productId){  
        List<Product> p=productService.getCategoryProducts(productId);   
        List<com.finance.model.Period> list=productService.getPeriod1();
        Product n = p.get(0);
        ModelAndView mv=new ModelAndView("productdetails");
        mv.addObject("command1",n);
        mv.addObject("command",list);
        HttpSession session = request.getSession();
        session.getAttribute("verify");
        return mv; 
    }
    
    @RequestMapping("/purchase")
    public ModelAndView purchase(HttpServletRequest request) {
    	Purchase p = new Purchase();
    	int id = Integer.parseInt(request.getParameter("id"));
    	p.setId(id);
    	p.setPeriod(Integer.parseInt(request.getParameter("period")));
    	p.setProductId(Integer.parseInt(request.getParameter("productId")));
    	p.setCost(Float.parseFloat(request.getParameter("cost")));
    	List<User> users = adminService.getUsrById(id);
    	User user = users.get(0);
    	List<Card> cards = cardService.getCardByName(users.get(0).getUname());
    	Card card = cards.get(0);
    	int j=0;
    	ModelAndView mv = null;
    	if(user.getVerified().equals("yes")) {
    		if((card.getValue() - p.getCost()) >= 0) {
    			j = purchaseService.updateCard(card, user, p);
    		}else {
    			mv = new ModelAndView("failure");
    		}
    		if(j>0)
    		{
    			int i = purchaseService.purchaseDetails(p);
    			mv = new ModelAndView("success");
    		}else {
    			mv = new ModelAndView("failure");
    		}
    	}else {
    		mv = new ModelAndView("fail");
    	}
    	return mv;
    }
}

