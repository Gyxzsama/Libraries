package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.book.entity.Book;
import com.book.service.EditBookService;
import com.book.service.ListBookService;

@SuppressWarnings("serial")
@WebServlet("/EditBook.do")
public class EditBookServlet extends HttpServlet {
	ListBookService listbookServie = new ListBookService();
	Book book=null;
	EditBookService editbookservice = new EditBookService();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("submit").trim();
		
		String id = action.substring(1,action.length());
		String flag=action.substring(0,1);
		
		book=editbookservice.editbook(Integer.parseInt(id));
		
		if (flag.equals("1")){
			request.setAttribute("book", book);
			request.getRequestDispatcher("page/book_edit.jsp").forward(request, response);
		} else if (flag.equals("2")) {
			request.setAttribute("book", book);
			request.getRequestDispatcher("page/book_delete.jsp").forward(request, response);
		}
	}
}