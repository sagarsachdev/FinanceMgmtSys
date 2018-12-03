package com.finance.dao;

import java.util.List;

import com.finance.model.Card;
import com.finance.model.User;

public interface CardDao {
	int insertCard(User u);
	List<Card> getAllCards();
	List<Card> getCardByName(String fname);
}
