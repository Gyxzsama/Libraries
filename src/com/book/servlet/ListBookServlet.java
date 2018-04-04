package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.Page;
import com.book.entity.Book;
import com.book.service.ListBookService;

@SuppressWarnings("serial")
@WebServlet("/listBook.do")
public class ListBookServlet extends HttpServlet {
	ListBookService listbookServie = new ListBookService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
		int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
		Page<Book> pageBook = listbookServie.getAllBook(pageNo, pageSize);
		request.setAttribute("pageBook", pageBook);
		request.getRequestDispatcher("page/book_list.jsp").forward(request, response);
	}
}
