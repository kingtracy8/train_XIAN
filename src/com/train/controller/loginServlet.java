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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		if (request.getSession().getAttribute("checkcode_session").equals(request.getParameter("checkCode"))) {

			try {
				userModel md = service.selectByNameAndPass(model);
				if (md != null) {
					// 找到记录，登录成功
					request.getSession().setAttribute("userName", md.getUserName());
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "登录失败！请重试！");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("msg", "验证码输入有误！请重试！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
