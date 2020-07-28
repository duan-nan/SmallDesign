package com.javaweb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaweb.handler.IResultSetHandler;

public class JdbcTemplate {
	/**
	 * DML操作
	 * @param sql sql语句
	 * @param params 参数
	 * @return 返回一个int类型的数字
	 */
	public static int DML(String sql,Object... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			con = JdbcUtils.getConnection();
			pstmt = con.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeResourse(con, pstmt, res);
		}
		return 0;
	}
	/**
	 * DOL操作
	 * @param <T> 泛型
	 * @param sql sql语句
	 * @param rsh 结果集
	 * @param params 参数
	 * @return 返回一个对象
	 */
	public static <T>T DOL(String sql,IResultSetHandler<T> rsh,Object... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			con = JdbcUtils.getConnection();
			pstmt = con.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
			res = pstmt.executeQuery();
			return rsh.Handler(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeResourse(con, pstmt, res);
		}
		return null;
	}
	
}
