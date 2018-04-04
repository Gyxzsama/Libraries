package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.Page;
import com.book.entity.Book;
import com.book.service.DeleteBookService;
import com.book.service.ListBookService;


@SuppressWarnings("serial")
@WebServlet("/DeleteBook.do")
public class DeleteBookServlet extends HttpServlet{
	ListBookService listbookServie = new ListBookService();
	DeleteBookService deletebooksevice = new DeleteBookService();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("submit").trim();
		if (action.equals("1")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			deletebooksevice.deletebook(id);
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Book> pageBook = listbookServie.getAllBook(pageNo, pageSize);
			request.setAttribute("pageBook", pageBook);
			
			request.setAttribute("msg", "删除成功");
			request.getRequestDispatcher("page/book_list.jsp").forward(request, response);
		} else if(action.equals("2")){
			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Book> pageBook = listbookServie.getAllBook(pageNo, pageSize);
			request.setAttribute("pageBook", pageBook);
			request.getRequestDispatcher("page/book_list.jsp").forward(request, response);
		}
		
	}
}








