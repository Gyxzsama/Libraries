package com.book.dao;

public class SaveEditBookDao {
	public void SaveEditBook(int id,String bookName,String author,String publisher,double price ,int stock ,int current) {
		String sql = "update book set bookName=?,author=?,publisher=?,price=?,stock=?,current=? where id=?";
		MyDbUtil.UpDate(sql,bookName,author,publisher,price,stock,current,id);
		MyDbUtil.closeConnection();
	}
}
	