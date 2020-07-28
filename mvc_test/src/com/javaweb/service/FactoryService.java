package com.javaweb.service;

import com.javaweb.service.impl.UserServiceImpl;

public class FactoryService {
	/**
	 *   获取对象
	 * @return
	 */
	public static UserServiceImpl getUserService() {
		return new UserServiceImpl();
	}
	
}
