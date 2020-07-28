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
	 * 静态代码块
	 */
	static {
		try {
			//创建一个Properties的对象
			Properties p = new Properties();
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dbcp.properties"));
			//加载注册驱动
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Connection对象
	 * @return Connection对象
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
	 * 关闭资源
	 * @param con Connection对象
	 * @param pstmt PreparedStatement对象
	 * @param res ResultSet对象
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
