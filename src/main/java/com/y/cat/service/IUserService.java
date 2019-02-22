package com.y.cat.service;

import java.util.List;

import com.y.cat.bean.User;

public interface IUserService {
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> getAllUsers();
	
	User getUserById(int id);
	
	User getUserByPhone(String phone);
	
	User getUserByAccount(String account);
	
	void registerUser(User user);
	
	void unRegisterUser(int id);
}
