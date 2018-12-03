package com.finance.service;

import java.util.List;

import com.finance.model.User;

public interface AdminService {

	List<User> getAllUsers();
	int updateUser(User u);
	int delete(int id);
	List<User> getUsrById(int id);
	List<User> getUsrByUname(String uname);
}
