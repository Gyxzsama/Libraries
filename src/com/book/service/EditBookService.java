package com.book.service;

import com.book.dao.EditBookDao;
import com.book.entity.Book;

public class EditBookService {
	EditBookDao editbookdao = new EditBookDao();
	public Book editbook(int id) {
			return editbookdao.SelectBook(id); 
	}
}
