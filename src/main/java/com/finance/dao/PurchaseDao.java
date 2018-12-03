package com.finance.dao;

import java.util.List;

import com.finance.model.Card;
import com.finance.model.Purchase;
import com.finance.model.User;

public interface PurchaseDao {
	int purchaseDetails(Purchase pd);
	int updateCard(Card c, User u, Purchase pd);
	List<Purchase> getPurchaseById(int id);
}
