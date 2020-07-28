package com.javaweb.dao;

import java.util.List;

import com.javaweb.domain.User;

/**
 * 	接口规则：之定义方法而不去实现
 * @author ASUS
 *
 */
public interface IUserDao {
	/**
	 *     插入新用户信息
	 * @param user 数据封装再user对象中
	 * @return 返回一个int类型的值
	 */
	public int saveUser(User user);
	/**
	 *   删除用户
	 * @param username 用户名
	 * @return 返回一个int类型的值
	 */
	public int deleteUserByUsername(String username);
	/**
	 *   修改用户信息
	 * @param username 用户名
	 * @param user User对象，新的数据被封装在user对象中
	 * @return 返回一个interesting类型的数字
	 */
	public int updateUserByUsername(String username,User user);
	/**
	 *   查询一个用户
	 * @param username 用户名
	 * @return 返回一个User对象
	 */
	public User queryOneUserByUsername(String username);
	/**
	 *   查询所有用户的信息
	 * @return 返回一个List集合，集合内存储User对象
	 */
	public List<User> queryAllUser();
	/**
	 * 	查询指定用户有多少条
	 * @param name
	 * @return
	 */
	public long getCountName(String name);
	/**
	 * 模糊查询
	 * @param name 姓名
	 * @param phone 电话
	 * @param address 地址
	 * @return 返回一个list集合
	 */
	public List<User> dimQuery(String name, String phone, String address);
}
