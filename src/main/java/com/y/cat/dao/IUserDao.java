package com.y.cat.dao;

import java.util.List;
import com.y.cat.bean.User;

public interface IUserDao {
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> queryAllUsers();
	
	User queryUserById(int id);
	
	User queryUserByPhone(String phone);
	
	User queryUserByAccount(String account);
	
	void registerUser(User user);
	
	void unRegisterUser(int id);
	
	
}
