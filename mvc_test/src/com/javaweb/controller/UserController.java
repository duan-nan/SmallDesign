package com.javaweb.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.domain.User;
import com.javaweb.service.FactoryService;
import com.javaweb.service.IUserService;


public class UserController extends HttpServlet {
	private IUserService userService = FactoryService.getUserService();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 获取字符串路径让后尽行切分
			String path = request.getServletPath();
			path = path.substring(1);
			path = path.substring(0, path.length() - 4);
			// 通过反射来调用方法
			Method method = this.getClass().getDeclaredMethod(path, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 登陆操作
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ("guanliyuan".equals(username) && "123456".equals(password)) {
			request.getRequestDispatcher("/UserView.jsp").forward(request, response);
		}else {
			request.setAttribute("loginError", "用户名或者密码错误！");// 设置错误属性
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}


	/**
	 * 实现模糊查询
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		List<User> list = userService.dimQuery(username, phone, address);
		request.setAttribute("list", list);//把属性放到request属性空间
		request.getRequestDispatcher("/UserView.jsp").forward(request, response);//把request转接到jsp页面
	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		User u = userService.queryOneUserByUsername(request.getParameter("username"));
		if(u == null) {
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setName(request.getParameter("name"));
			user.setPhone(request.getParameter("phone"));
			user.setAddress(request.getParameter("address"));
			 Date date = new Date();
		     DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		     String s1 = df.format(date);
		     user.setReg_date(date);
			int rows = userService.saveUser(user);
			if(rows>0) {
				response.sendRedirect(request.getContextPath()+"/UserView.jsp");
			}else {
				response.sendRedirect(request.getContextPath()+"/error.jsp");
			}
		}else {
			request.setAttribute("msg", "用户名已经存在！！");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
		
	}

	/**
	 * 删除用户的信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		int rows = userService.deleteUserByUsername(username);
		if(rows>0) {
			response.sendRedirect(request.getContextPath()+"/UserView.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

	/**
	 * 修改转接
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userService.queryOneUserByUsername(username);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}
	/**
	 *   更新操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void updateDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setAddress(request.getParameter("address"));
		int rows = userService.updateUserByUsername(request.getParameter("username"),user);
		if(rows>0) {
			response.sendRedirect(request.getContextPath()+"/UserView.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			}
		
	}
}
