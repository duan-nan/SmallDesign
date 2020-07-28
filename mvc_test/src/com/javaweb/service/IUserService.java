package com.javaweb.service;

import java.util.List;

import com.javaweb.domain.User;
/**
 *  User�� Service��
 * @author ASUS
 *
 */
public interface IUserService {
	/**
	 *     �������û���Ϣ
	 * @param user ���ݷ�װ��user������
	 * @return ����һ��int���͵�ֵ
	 */
	public int saveUser(User user);
	/**
	 *   ɾ���û�
	 * @param username �û���
	 * @return ����һ��int���͵�ֵ
	 */
	public int deleteUserByUsername(String username);
	/**
	 *   �޸��û���Ϣ
	 * @param username �û���
	 * @param user User�����µ����ݱ���װ��user������
	 * @return ����һ��interesting���͵�����
	 */
	public int updateUserByUsername(String username,User user);
	/**
	 *   ��ѯһ���û�
	 * @param username �û���
	 * @return ����һ��User����
	 */
	public User queryOneUserByUsername(String username);
	/**
	 *   ��ѯ�����û�����Ϣ
	 * @return ����һ��List���ϣ������ڴ洢User����
	 */
	public List<User> queryAllUser();
	/**
	 * 	��ѯָ���û��ж�����
	 * @param name ����
	 * @return ����һ������
	 */
	public long getCountName(String name);
	
	/**
	 *   ģ����ѯ
	 * @param name ����
	 * @param phone �绰
	 * @param address ��ַ
	 * @return ����һ��list����
	 */
	public List<User> dimQuery(String name, String phone, String address);
}
