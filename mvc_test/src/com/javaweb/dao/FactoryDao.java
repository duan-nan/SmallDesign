package com.javaweb.dao;

import com.javaweb.dao.impl.UserDaoImpl;

public class FactoryDao {
	/**
	 *   ���� service���dao��������
	 * @return 
	 */
	public static UserDaoImpl getUserDao() {
		return new UserDaoImpl();
	}
}
