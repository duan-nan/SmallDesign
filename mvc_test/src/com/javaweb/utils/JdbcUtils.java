package com.javaweb.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;


public class JdbcUtils {
	private static DataSource ds= null;
	/**
	 * ��̬�����
	 */
	static {
		try {
			//����һ��Properties�Ķ���
			Properties p = new Properties();
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dbcp.properties"));
			//����ע������
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡConnection����
	 * @return Connection����
	 */
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �ر���Դ
	 * @param con Connection����
	 * @param pstmt PreparedStatement����
	 * @param res ResultSet����
	 */
	public static void closeResourse(Connection con,PreparedStatement pstmt,ResultSet res) {
		if(res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
