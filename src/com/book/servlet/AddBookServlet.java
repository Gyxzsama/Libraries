package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.Page;
import com.book.entity.Book;
import com.book.service.AddBookService;
import com.book.service.ListBookService;

@SuppressWarnings("serial")
@WebServlet("/AddBook.do")
public class AddBookServlet extends HttpServlet {
	AddBookService addbookServie = new AddBookService();
	ListBookService listbookServie = new ListBookService();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("submit").trim();
		if (action.equals("1")) {
			String bookName = request.getParameter("bookName").trim();
			String author = request.getParameter("author").trim();
			String publisher = request.getParameter("publisher").trim();
			double price = Double.valueOf((request.getParameter("price").trim()));
			int stock = Integer.parseInt(request.getParameter("stock").trim());
			int current = Integer.parseInt(request.getParameter("current").trim());
			addbookServie.addbook(bookName, author, publisher, price, stock, current);

			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("page/book_add.jsp").forward(request, response);

		} else if (action.equals("2")) {
			String bookName = request.getParameter("bookName").trim();
			String author = request.getParameter("author").trim();
			String publisher = request.getParameter("publisher").trim();
			double price = Double.valueOf((request.getParameter("price").trim()));
			int stock = Integer.parseInt(request.getParameter("stock").trim());
			int current = Integer.parseInt(request.getParameter("current").trim());
			addbookServie.addbook(bookName, author, publisher, price, stock, current);

			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Book> pageBook = listbookServie.getAllBook(pageNo, pageSize);
			request.setAttribute("pageBook", pageBook);
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("page/book_list.jsp").forward(request, response);
		}
		else if (action.equals("3")) {
			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Book> pageBook = listbookServie.getAllBook(pageNo, pageSize);
			request.setAttribute("pageBook", pageBook);
			request.getRequestDispatcher("page/book_list.jsp").forward(request, response);
		}
	}
}