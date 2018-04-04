package com.book.dao;

public class AddBookDao {
	public void AddBook(String bookName,String author,String publisher,double price ,int stock ,int current) {
		String sql = "insert into book (bookName,author,publisher,price,stock,current)values(?,?,?,?,?,?);";
		MyDbUtil.UpDate(sql,bookName,author,publisher,price,stock,current);
		MyDbUtil.closeConnection();
	}
}
