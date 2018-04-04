package com.book.service;

import com.book.dao.BackBookDao;

public class BackBookService {
	BackBookDao backbookdao = new BackBookDao();
	public void backbook(int or_id, int ob_id) {
		backbookdao.backBook(or_id,ob_id);
		
	}

}
