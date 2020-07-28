package com.javaweb.test;

import static org.junit.jupiter.api.Assertions.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.javaweb.dao.IUserDao;
import com.javaweb.dao.impl.UserDaoImpl;
import com.javaweb.domain.User;


class UserDaoImplTest {
	
	private IUserDao dao = new UserDaoImpl();
	
	@Test
	void testSaveUser() {
		Date date=new Date();                           
		SimpleDateFormat temp=new SimpleDateFormat("2020-07-24 21:30:32");  
		@SuppressWarnings("unused")
		String Date=temp.format(date);

		//User user = new User(1,"wangwu","123456","15936220120","河南省",Date);
		//System.out.println(dao.saveUser(user));
		fail("Not yet implemented");
	}

	@Test
	void testDeleteUserByUsername() {
		int a=dao.deleteUserByUsername("wangwu");
		System.out.println(a);
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUserByUsername() {
		User user = new User();
		user.setName("段楠");
		user.setPhone("123456");
		user.setAddress("河南省南阳市");
		int a = dao.updateUserByUsername("z", user);
		System.out.println(a);
		fail("Not yet implemented");
	}

	@Test
	void testQueryOneUserByUsername() {
		User user =dao.queryOneUserByUsername("duannan");
		System.out.println(user);
		fail("Not yet implemented");
	}

	@Test
	void testQueryAllUser() {
		List<User> list = dao.queryAllUser();
		for (User user : list) {
			System.out.println(user);
		}
		fail("Not yet implemented");
	}

	@Test
	void testdimQuery(String name, String phone, String address) {
		@SuppressWarnings("unused")
		String sql = "SELECT id, username, password, name, phone,address,reg_date AS regDate\r\n" + 
				"FROM user\r\n" + 
				"WHERE 1=1 AND name like '%段%'";
		List<User> list=dao.dimQuery("段", "", "");
		for (User user : list) {
			System.out.println(user);
		}
		fail("Not yet implemented");
	}
}
