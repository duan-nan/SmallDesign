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
			// ��ȡ�ַ���·���ú����з�
			String path = request.getServletPath();
			path = path.substring(1);
			path = path.substring(0, path.length() - 4);
			// ͨ�����������÷���
			Method method = this.getClass().getDeclaredMethod(path, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��½����
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
			request.setAttribute("loginError", "�û��������������");// ���ô�������
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}


	/**
	 * ʵ��ģ����ѯ
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
		request.setAttribute("list", list);//�����Էŵ�request���Կռ�
		request.getRequestDispatcher("/UserView.jsp").forward(request, response);//��requestת�ӵ�jspҳ��
	}

	/**
	 * ����û�
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
			request.setAttribute("msg", "�û����Ѿ����ڣ���");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
		
	}

	/**
	 * ɾ���û�����Ϣ
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
	 * �޸�ת��
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
	 *   ���²���
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
