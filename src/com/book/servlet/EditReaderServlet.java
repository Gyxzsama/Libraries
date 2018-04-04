package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Reader;
import com.book.service.EditReaderService;
import com.book.service.ListReaderService;

@SuppressWarnings("serial")
@WebServlet("/EditReader.do")
public class EditReaderServlet extends HttpServlet {
	ListReaderService listreaderServie = new ListReaderService();
	Reader reader=null;
	EditReaderService editreaderservice = new EditReaderService();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("submit").trim();
		String id = action.substring(1,action.length());
		String flag=action.substring(0,1);
		
		reader=editreaderservice.editreader(Integer.parseInt(id));
		
		if (flag.equals("1")) {
			request.setAttribute("reader", reader);
			request.getRequestDispatcher("page/reader_edit.jsp").forward(request, response);
		} else if (flag.equals("2")) {
			request.setAttribute("reader", reader);
			request.getRequestDispatcher("page/reader_delete.jsp").forward(request, response);
		}
	}
}