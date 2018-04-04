package com.book.service;

import com.book.dao.DeleteBookDao;

public class DeleteBookService {
	DeleteBookDao deletebookdao = new DeleteBookDao();
	public void deletebook(int id){
		deletebookdao.DeleteBook(id);
	}
}
