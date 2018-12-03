package com.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dao.AdminDao;
import com.finance.model.User;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adao;

	public List<User> getAllUsers() {
		return adao.getAllUsers();
	}

	public int updateUser(User u) {
		return adao.updateUser(u);
	}

	public int delete(int id) {
		return adao.delete(id);
	}

	public List<User> getUsrByUname(String uname) {
		return adao.getUsrByUname(uname);
	}

	public List<User> getUsrById(int id) {
		return adao.getUsrById(id);
	}
}
