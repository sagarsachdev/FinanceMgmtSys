package com.finance.dao;

import com.finance.model.Login;
import com.finance.model.User;

public interface UserDao {
	  int register(User user);
	  User validateUser(Login login);
	  int update(Login login);
	}
