package com.javaweb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.javaweb.utils.JdbcTemplate;

class JdbcTemplateTest {

	@Test
	void testDML() {
		String sql = "insert into user(username,password,phone,address,reg_date)"
				+ "values(?,?,?,?,?)";
		int a = JdbcTemplate.DML(sql, "zhangsan","123456","15936110784","µ¹Èø°¢Ë¹¶Ù","2020-07-24 21:30:32");
		System.out.println(a);
	}

	@Test
	void testDOL() {
		fail("Not yet implemented");
	}

}
