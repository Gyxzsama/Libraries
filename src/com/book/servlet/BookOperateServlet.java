package com.book.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Book;
import com.book.entity.Reader;
import com.book.service.AddBookService;
import com.book.service.BorrowBookService;
import com.book.service.EditBookService;
import com.book.service.EditReaderService;
import com.book.service.ListBookService;

@SuppressWarnings("serial")
@WebServlet("/BookOperate.do")
public class BookOperateServlet extends HttpServlet {
	AddBookService addbookServie = new AddBookService();
	ListBookService listbookServie = new ListBookService();
	EditBookService editbookservice = new EditBookService();
	EditReaderService editreaderservice=new EditReaderService();
	BorrowBookService borrowbookservice =new BorrowBookService();
	static Book book=null;
	static Reader reader=null;
	
  	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("submit").trim();
		if (action.equals("1")) {
			int id = Integer.parseInt(request.getParameter("ob_id").trim());
			book=editbookservice.editbook(id);
			if(book==null) {
				request.setAttribute("msg_1", "书籍不存在");
				book=null;
			}
			request.setAttribute("ob", book);
			request.setAttribute("orr", reader);
			request.getRequestDispatcher("page/book_borrow.jsp").forward(request, response);
		} else if (action.equals("2")) {
			int id = Integer.parseInt(request.getParameter("or_id").trim());
			reader=	editreaderservice.editreader(id);
			if(reader==null) {
				request.setAttribute("msg_2", "用户不存在");
				reader=null;
			}
			request.setAttribute("ob", book);
			request.setAttribute("orr", reader);
			request.getRequestDispatcher("page/book_borrow.jsp").forward(request, response);
		} else if (action.equals("3")) {
			int ob_id = Integer.parseInt(request.getParameter("ob_id").trim());
			int or_id = Integer.parseInt(request.getParameter("or_id").trim());
			Date date = new Date();  
			Timestamp timeStamp = new Timestamp(date.getTime());  
			borrowbookservice.borrowbook(or_id, ob_id, timeStamp);
			request.setAttribute("msg", "操作成功");
			request.getRequestDispatcher("page/book_borrow.jsp").forward(request, response);
		}
	}
}
