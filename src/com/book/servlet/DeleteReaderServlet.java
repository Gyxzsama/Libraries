package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.Page;
import com.book.entity.Reader;
import com.book.service.DeleteReaderService;
import com.book.service.ListReaderService;

@SuppressWarnings("serial")
@WebServlet("/DeleteReader.do")
public class DeleteReaderServlet extends HttpServlet {
	DeleteReaderService deletereaderservice = new DeleteReaderService();
	ListReaderService listreaderservice=new ListReaderService();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("submit").trim();
		if (action.equals("1")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			deletereaderservice.deletereader(id);
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Reader> pageReader = listreaderservice.getAllReader(pageNo, pageSize);
			request.setAttribute("pageReader", pageReader);
			request.setAttribute("msg", "删除成功");
			request.getRequestDispatcher("page/reader_list.jsp").forward(request, response);
		} else if(action.equals("2")){
			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Reader> pageReader = listreaderservice.getAllReader(pageNo, pageSize);
			request.setAttribute("pageReader", pageReader);
			request.getRequestDispatcher("page/reader_list.jsp").forward(request, response);
		}
		
	}
}







