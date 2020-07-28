package com.javaweb.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IUserDao;
import com.javaweb.domain.User;
import com.javaweb.handler.IResultSetHandler;
import com.javaweb.utils.JdbcTemplate;

public class UserDaoImpl implements IUserDao{

	@Override
	public int saveUser(User user) {
		return JdbcTemplate.DML("insert into user(username,password,name,phone,address,reg_date)"
				+ " values(?,?,?,?,?,?)",user.getUsername(),user.getPassword(),user.getName(),
				user.getPhone(),user.getAddress(),user.getReg_date()); 
	}

	@Override
	public int deleteUserByUsername(String username) {
		return JdbcTemplate.DML("DELETE FROM user WHERE username = ?", username);
	}

	@Override
	public int updateUserByUsername(String username,User user) {
		return JdbcTemplate.DML("UPDATE user SET password=?,name=?,phone=?,address=? WHERE username=?",
				user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),username);
	}

	@Override
	public User queryOneUserByUsername(String username) {
		List<User> list= JdbcTemplate.DOL("SELECT * FROM user WHERE username=?",
				new UserResultSetHandler(),username);
		return list.size()>0 ? list.get(0):null;
	}

	@Override
	public List<User> queryAllUser() {
		return JdbcTemplate.DOL("SELECT * FROM user",
				new UserResultSetHandler());	
	}

	@Override
	public long getCountName(String name) {
		List<User> list= JdbcTemplate.DOL("SELECT Count(*) FROM user WHERE name=?",
				new UserResultSetHandler(),name);
		return list.size();
	}

	@Override
	public List<User> dimQuery(String name, String phone, String address) {
		String sql ="SELECT id, username, password, name, phone,address,reg_date\r\n" + 
				"FROM user\r\n" + 
				"WHERE 1=1";
		if(name!=null && !"".equals(name)) {
			sql = sql + " AND name like '%"+name+"%'";
		}
		if(phone!=null && !"".equals(phone)) {
			sql = sql + " AND phone like '%"+phone+"%'";
		}
		if(address!=null && !"".equals(address)) {
			sql = sql + " AND address like '%"+address+"%'";
		}
		System.out.println(sql);
		return JdbcTemplate.DOL(sql,new UserResultSetHandler());
	}

}

class UserResultSetHandler implements IResultSetHandler<List<User>>{

	@Override
	public List<User> Handler(ResultSet res) {
		List<User> list = new ArrayList<User>();
		try {
			while(res.next()) {
				int id = res.getInt("id");
				String username = res.getNString("username");
				String password = res.getString("password");
				String name = res.getString("name");
				String phone =	res.getNString("phone");
				String address = res.getString("address");
				Date date = res.getDate("reg_date");
				User user = new User(id,username,password,name,phone,address,date);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
