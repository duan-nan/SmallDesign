package com.javaweb.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.javaweb.domain.User;
import com.javaweb.utils.JdbcUtils;

class JdbcUtilsTest {

	@Test
	void testGetConnection() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			 con = JdbcUtils.getConnection();
			 pstmt =con.prepareStatement("select * from user");
			 res = pstmt.executeQuery();
			 while(res.next()) {
				 User user = new User(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),
						 res.getString(6),res.getDate(7));
				 System.out.println(user);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeResourse(con, pstmt, res);
		}
	
		fail("Not yet implemented");
	}

}
