package com.y.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.y.cat.bean.User;
import com.y.cat.dao.IUserDao;
import com.y.cat.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	public UserServiceImpl() {}
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.queryAllUsers();
	}

	@Override
	public User getUserById(int id) {
		return userDao.queryUserById(id);
	}

	@Override
	public void registerUser(User user) {
		userDao.registerUser(user);
	}

	@Override
	public void unRegisterUser(int id) {
		userDao.unRegisterUser(id);
	}

	@Override
	public User getUserByPhone(String phone) {
		return userDao.queryUserByPhone(phone);
	}

	@Override
	public User getUserByAccount(String account) {
		return userDao.queryUserByAccount(account);
	}
	
}
