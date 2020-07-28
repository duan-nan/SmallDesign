package com.javaweb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaweb.handler.IResultSetHandler;

public class JdbcTemplate {
	/**
	 * DML����
	 * @param sql sql���
	 * @param params ����
	 * @return ����һ��int���͵�����
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
	 * DOL����
	 * @param <T> ����
	 * @param sql sql���
	 * @param rsh �����
	 * @param params ����
	 * @return ����һ������
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
