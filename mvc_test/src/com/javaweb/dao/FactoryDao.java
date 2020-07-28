package com.javaweb.dao;

import com.javaweb.dao.impl.UserDaoImpl;

public class FactoryDao {
	/**
	 *   降低 service层和dao层的耦合性
	 * @return 
	 */
	public static UserDaoImpl getUserDao() {
		return new UserDaoImpl();
	}
}
