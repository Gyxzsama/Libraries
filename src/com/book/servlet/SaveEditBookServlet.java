package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.Page;
import com.book.entity.Book;
import com.book.service.EditBookService;
import com.book.service.ListBookService;
import com.book.service.SaveEditBookService;

@SuppressWarnings("serial")
@WebServlet("/SaveEditBook.do")
public class SaveEditBookServlet extends HttpServlet {
	SaveEditBookService saveeditbookservice = new SaveEditBookService();
	ListBookService listbookServie = new ListBookService();
	Book book = null;
	EditBookService editbookservice = new EditBookService();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("submit").trim();
		System.out.println(action);
		if (action.equals("1")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			String bookName = request.getParameter("bookName").trim();
			String author = request.getParameter("author").trim();
			String publisher = request.getParameter("publisher").trim();
			double price = Double.valueOf((request.getParameter("price").trim()));
			int stock = Integer.parseInt(request.getParameter("stock").trim());
			int current = Integer.parseInt(request.getParameter("current").trim());
			saveeditbookservice.saveeditbook(id, bookName, author, publisher, price, stock, current);

			book = new Book(id, bookName, author, publisher, price, stock, current);
			request.setAttribute("book", book);
			request.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("page/book_edit.jsp").forward(request, response);
		} else if (action.equals("2")) {
			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Book> pageBook = listbookServie.getAllBook(pageNo, pageSize);
			request.setAttribute("pageBook", pageBook);
			request.getRequestDispatcher("page/book_list.jsp").forward(request, response);
		}
	}
}
