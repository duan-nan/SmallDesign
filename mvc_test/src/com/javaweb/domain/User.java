package com.javaweb.domain;

import java.util.Date;

/**
 * 用户类
 * @author ASUS
 *
 */
public class User {
	/**
	 * 用户的ID编号
	 */
	private int id;
	/**
	 * 用户的用户名
	 */
	private String username;
	/**
	 * 姓名
	 */
	private String name; 
	/**
	 * 用户的密码
	 */
	private String password;
	/**
	 * 用户的电话号码
	 */
	private String phone;
	/**
	 * 用户的地址
	 */
	private String address;
	/**
	 * 用户的注册实践
	 */
	private Date reg_date;
	
	/**
	 * 无参构造
	 */
	public User() {
		super();
	}

	/**
	 * 全参构造
	 * @param id
	 * @param username
	 * @param password
	 * @param phone
	 * @param address
	 * @param reg_date
	 */
	public User(int id, String username, String password,String name, String phone, String address, Date reg_date) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.reg_date = reg_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password+", name=" + name  + ", phone="
				+ phone + ", address=" + address + ", reg_date=" + reg_date + "]";
	}
	
	
	
}
