package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.Page;
import com.book.entity.Reader;
import com.book.service.AddReaderService;
import com.book.service.ListReaderService;

@SuppressWarnings("serial")
@WebServlet("/AddReader.do")
public class AddReaderServlet extends HttpServlet {
	AddReaderService addreaderServie = new AddReaderService();
	ListReaderService listreaderServie = new ListReaderService();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("submit").trim();
		if (action.equals("1")) {
			String readerName = request.getParameter("readerName").trim();
			String readerPwd = request.getParameter("readerPwd").trim();
			String readerContact = request.getParameter("readerContact").trim();
			addreaderServie.addreader(readerName, readerPwd, 0, readerContact);
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("page/reader_add.jsp").forward(request, response);
		}
		else if (action.equals("3")) {
			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Reader> pageReader = listreaderServie.getAllReader(pageNo, pageSize);
			request.setAttribute("pageReader", pageReader);
			request.getRequestDispatcher("page/reader_list.jsp").forward(request, response);
		}
	}
}