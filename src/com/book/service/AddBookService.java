package com.book.service;

import com.book.dao.AddBookDao;

public class AddBookService {
	AddBookDao addbookdao = new AddBookDao();

	public void addbook(String bookName, String author, String publisher, double price, int stock, int current) {
		addbookdao.AddBook(bookName, author, publisher, price, stock, current);
	}
}
