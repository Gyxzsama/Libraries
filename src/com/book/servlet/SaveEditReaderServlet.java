package com.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.book.common.Page;
import com.book.entity.Reader;
import com.book.service.EditReaderService;
import com.book.service.ListReaderService;
import com.book.service.SaveEditReaderService;

@SuppressWarnings("serial")
@WebServlet("/SaveEditReader.do")
public class SaveEditReaderServlet extends HttpServlet {
	SaveEditReaderService saveeditreaderservice = new SaveEditReaderService();
	ListReaderService listreaderServie = new ListReaderService();
	Reader reader = null;
	EditReaderService editreaderservice = new EditReaderService();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("submit").trim();
		if (action.equals("1")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			String readerName = request.getParameter("readerName").trim();
			String readerPwd = request.getParameter("readerPwd").trim();
			int borrowNum = Integer.parseInt(request.getParameter("borrowNum").trim());
			String readerContact = request.getParameter("readerContact").trim();

			saveeditreaderservice.saveeditbook(id, readerName, readerPwd, borrowNum, readerContact);
			reader = new Reader(id, readerName, readerPwd, borrowNum, readerContact);
			request.setAttribute("reader", reader);
			request.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("page/reader_edit.jsp").forward(request, response);

		} else if (action.equals("2")) {
			int pageNo = Integer.parseInt(request.getParameter("pageNo").trim());
			int pageSize = Integer.parseInt(request.getParameter("pageSize").trim());
			Page<Reader> pageReader = listreaderServie.getAllReader(pageNo, pageSize);
			request.setAttribute("pageReader", pageReader);
			request.getRequestDispatcher("page/reader_list.jsp").forward(request, response);
		}
	}
}
