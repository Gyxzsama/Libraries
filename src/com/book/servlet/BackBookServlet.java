package com.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.book.entity.Book;
import com.book.entity.Reader;
import com.book.service.AddBookService;
import com.book.service.BackBookService;
import com.book.service.BorrowBookService;
import com.book.service.EditBookService;
import com.book.service.EditReaderService;
import com.book.service.ListBookService;

@SuppressWarnings("serial")
@WebServlet("/BackBook.do")
public class BackBookServlet extends HttpServlet {
	AddBookService addbookServie = new AddBookService();
	ListBookService listbookServie = new ListBookService();
	EditBookService editbookservice = new EditBookService();
	EditReaderService editreaderservice = new EditReaderService();
	BorrowBookService borrowbookservice = new BorrowBookService();
	BackBookService backbookservice=new BackBookService();
	static Book book = null;
	static Reader reader = null;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("submit").trim();
		
		String flag=action.substring(0,1);
		
		if (flag.equals("1")) {
			int id = Integer.parseInt(request.getParameter("or_id").trim());
			List<Book> borrowBook = listbookServie.getBackBook(id);
			reader = editreaderservice.editreader(id);
			if(reader==null) {
				request.setAttribute("msg", "用户不存在");
				reader=null;
			}
			request.setAttribute("borrowBook", borrowBook);
			request.setAttribute("orr", reader);
			request.getRequestDispatcher("page/book_operate_1.jsp").forward(request, response);
		} else if (flag.equals("2")) {
			int or_id = Integer.parseInt(request.getParameter("or_id").trim());
			int ob_id = Integer.parseInt(action.substring(1,action.length()));
			book=editbookservice.editbook(ob_id);
			reader=	editreaderservice.editreader(or_id);
			request.setAttribute("ob", book);
			request.setAttribute("orr", reader);
			request.getRequestDispatcher("page/book_operate_2.jsp").forward(request, response);
		} else if(flag.equals("3")) {
			int or_id = Integer.parseInt(request.getParameter("or_id").trim());
			int ob_id = Integer.parseInt(request.getParameter("ob_id").trim());
			backbookservice.backbook(or_id,ob_id);
			request.setAttribute("msg", "操作成功");
			request.setAttribute("ob", book);
			request.setAttribute("orr", reader);
			request.getRequestDispatcher("page/book_operate_2.jsp").forward(request, response);
		}
	}
}
