package com.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dao.UserDao;
import com.finance.model.Login;
import com.finance.model.User;

@Service
public class UserServiceImpl implements UserService {

	  @Autowired
	  public UserDao userDao;

	  public int register(User user) {
	    return userDao.register(user);
	  }

	  public User validateUser(Login login) {
	    return userDao.validateUser(login);
	  }

	public int update(Login login) {
		return userDao.update(login);
	}

	}