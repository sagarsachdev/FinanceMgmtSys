package com.finance.service;

import java.util.List;

import com.finance.model.Card;
import com.finance.model.User;

public interface CardService {
	int insertCard(User u);
	List<Card> getAllCards();
	List<Card> getCardByName(String uname);
}
