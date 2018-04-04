package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.Page;
import com.book.entity.Reader;
import com.book.service.ListReaderService;

@SuppressWarnings("serial")
@WebServlet("/listReader.do")
public class ListReaderServlet extends HttpServlet {
	ListReaderService listreaderServie = new ListReaderService();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
		int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
		Page<Reader> pageReader = listreaderServie.getAllReader(pageNo, pageSize);
		request.setAttribute("pageReader", pageReader);
		request.getRequestDispatcher("page/reader_list.jsp").forward(request, response);
	}
}