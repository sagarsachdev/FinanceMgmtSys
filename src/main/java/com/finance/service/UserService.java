package com.finance.service;

import com.finance.model.Login;
import com.finance.model.User;

public interface UserService {

	  int register(User user);

	  User validateUser(Login login);
	  
	  int update(Login login);
	}