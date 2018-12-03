package com.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dao.CardDao;
import com.finance.model.Card;
import com.finance.model.User;

@Service
public class CardServiceImpl implements CardService {
	@Autowired
	CardDao cdao;

	public int insertCard(User u) {
		return cdao.insertCard(u);
	}

	public List<Card> getAllCards() {
		return cdao.getAllCards();
	}

	public List<Card> getCardByName(String uname) {
		return cdao.getCardByName(uname);
	}
	
}
