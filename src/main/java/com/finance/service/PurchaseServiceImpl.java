package com.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dao.PurchaseDao;
import com.finance.model.Card;
import com.finance.model.Purchase;
import com.finance.model.User;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	  public PurchaseDao purchaseDao;
	
	public int purchaseDetails(Purchase pd) {
		return purchaseDao.purchaseDetails(pd);
	}

	public int updateCard(Card c, User u, Purchase pd) {
		return purchaseDao.updateCard(c, u, pd);
	}

	public List<Purchase> getPurchaseById(int id) {
		return purchaseDao.getPurchaseById(id);
	}
}
