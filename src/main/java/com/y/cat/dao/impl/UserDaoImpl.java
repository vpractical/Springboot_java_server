//package com.y.cat.dao.impl;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.y.cat.bean.User;
//import com.y.cat.dao.IUserDao;
//
//@Repository
//public class UserDaoImpl implements IUserDao {
//	@Resource
//	private JdbcTemplate jdbcTemplate;
//
//	public UserDaoImpl() {
//	}
//
//	@Override
//	public List<User> queryAllUsers() {
//		System.out.println("UserDaoImpl->queryAllUsers()");
//		String sql = "select * from user";
//		BeanPropertyRowMapper<User> mapper = new BeanPropertyRowMapper<User>(
//				User.class);
//		List<User> users = jdbcTemplate.query(sql, mapper);
//		return users;
//	}
//
//	@Override
//	public User queryUserById(int id) {
//		try {
//			String sql = "select * from user where id = ?";
//			User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(),id);
//			return user;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public User queryUserByPhone(String phone) {
//		try {
//			String sql = "select * from user where phone = ?";
//			User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(),phone);
//			return user;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public User queryUserByAccount(String account) {
//		try {
//			String sql = "select * from user where account = ?";
//			User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(),account);
//			return user;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public void registerUser(User user) {
//		System.out.println("UserDaoImpl->registerUser() : " + user.getAccount());
//		String sql = "insert into user (account,password) value (?,?)";
//		jdbcTemplate.update(sql, user.getAccount(), user.getPassword());
//	}
//
//	@Override
//	public void unRegisterUser(int id) {
//		String sql = "delete form user where id = ?";
//		jdbcTemplate.update(sql, id);
//	}
//
//	private class UserRowMapper implements RowMapper<User> {
//
//		@Override
//		public User mapRow(ResultSet set, int i) throws SQLException {
//			User user = new User();
//			user.setId(set.getInt("id"));
//			user.setAccount(set.getString("account"));
//			user.setPassword(set.getString("password"));
//			return user;
//		}
//
//	}
//
//}
