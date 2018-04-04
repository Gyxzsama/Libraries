package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.ListInfoService;

@SuppressWarnings("serial")
@WebServlet("/listInfo.do")
public class ListInfoServlet extends HttpServlet {
	ListInfoService listInfo = new ListInfoService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("msg1", listInfo.getAllBookType());
		request.setAttribute("msg2", listInfo.getAllBookNum());
		request.setAttribute("msg3", listInfo.getAllReaderNum());
		request.setAttribute("msg4", listInfo.getAllReaderBorrow());
		request.getRequestDispatcher("page/index.jsp").forward(request, response);
	}
}
