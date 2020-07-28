package com.javaweb.service.impl;

import java.util.List;

import com.javaweb.dao.FactoryDao;
import com.javaweb.dao.IUserDao;
import com.javaweb.domain.User;
import com.javaweb.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = FactoryDao.getUserDao();

	@Override
	public int saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public int deleteUserByUsername(String username) {
		return userDao.deleteUserByUsername(username); 
	}

	@Override
	public int updateUserByUsername(String username, User user) {
		return userDao.updateUserByUsername(username, user);
	}

	@Override
	public User queryOneUserByUsername(String username) {
		return userDao.queryOneUserByUsername(username);
	}

	@Override
	public List<User> queryAllUser() {
		return userDao.queryAllUser();
	}

	@Override
	public long getCountName(String name) {
		return userDao.getCountName(name);
	}

	@Override
	public List<User> dimQuery(String name, String phone, String address) {
		return userDao.dimQuery( name,phone,address);
	}

	
}
