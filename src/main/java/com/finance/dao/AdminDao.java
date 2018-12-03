package com.finance.dao;

import java.util.List;

import com.finance.model.User;

public interface AdminDao {
	List<User> getAllUsers();
	int updateUser(User u);
	int delete(int id);
	List<User> getUsrById(int id);
	List<User> getUsrByUname(String uname);
}
