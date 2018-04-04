package com.book.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.book.entity.Manager;
import com.book.service.ManagerService;

@SuppressWarnings("serial")
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	// 业务层：注入服务层
	ManagerService userService = new ManagerService();
	//此处只需要dopost来接收book_login中的post请求
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		Manager u = userService.findUserByNameAndPassword(username, userpwd);
		if (u != null) {
			request.getSession().setAttribute("username", username);
			//在servlet中实现请求转发 使用javax.servlet.RequestDispatcher类的forward实现
			//request.getRequestDispatcher("listBook.do").forward(request, response);
			request.getRequestDispatcher("listInfo.do").forward(request, response);
		} else {
			request.setAttribute("msg", "登录失败,请重新输入");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}


//只继承service来实现业务
/*	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		Manager u = userService.findUserByNameAndPassword(username, userpwd);
		if (u != null) {
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("listBook.do").forward(request, response);
		} else {
			request.setAttribute("msg", "登录失败,请重新输入");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}*/