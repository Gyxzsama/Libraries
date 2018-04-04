package com.book.service;

import java.sql.Timestamp;

import com.book.dao.BorrowBookDao;

public class BorrowBookService {
	BorrowBookDao borrowbookdao = new BorrowBookDao();
	public void borrowbook(int or_id ,int ob_id,Timestamp timestamp){
		borrowbookdao.BorrowBook(or_id,ob_id,timestamp);
	}
}
