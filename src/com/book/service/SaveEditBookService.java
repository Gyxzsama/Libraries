package com.book.service;

import com.book.dao.SaveEditBookDao;

public class SaveEditBookService {
	SaveEditBookDao saveeditbookdao = new SaveEditBookDao();
	public void saveeditbook(int id,String bookName,String author,String publisher,double price ,int stock ,int current) {
		saveeditbookdao.SaveEditBook(id, bookName, author, publisher, price, stock, current);
	}
}
