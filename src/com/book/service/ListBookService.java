package com.book.service;

import java.util.List;

import com.book.common.Page;
import com.book.dao.BookDao;
import com.book.entity.Book;

public class ListBookService {
	private BookDao bookDao = new BookDao();
	public Page<Book> getAllBook(int pageNo,int pageSize) {
		Page<Book> books = null;
		books = bookDao.getAllBook(pageNo,pageSize);
		return books;
	}
	public List<Book> getBackBook(int id) {
		List<Book>  books = null;
		books = bookDao.getBackBook(id);
		return books;
	}
}
