package com.javaweb.service;

import com.javaweb.service.impl.UserServiceImpl;

public class FactoryService {
	/**
	 *   ��ȡ����
	 * @return
	 */
	public static UserServiceImpl getUserService() {
		return new UserServiceImpl();
	}
	
}
