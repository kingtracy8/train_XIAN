package com.train.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.train.model.userModel;
import com.train.service.userService;
import com.train.util.MD5Utils;

/**
 * Servlet implementation class registerSeverlet
 */
@WebServlet("/registerSeverlet")
public class registerSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registerSeverlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String passWord = MD5Utils.md5(request.getParameter("passWord"));
		userModel model = new userModel();
		model.setUserName(userName);
		model.setPassWord(passWord);
		userService service = new userService();
		try {
			userModel m = service.selectByName(model.getUserName());
			if (m == null) { // 如果找不到同名的记录，则可以注册
				int i = service.save(model);
				if (i > 0) {
					request.setAttribute("msg", "注册成功！请登录！");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "注册失败！请重新注册！");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "用户名重复！请重新注册！");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
