package com.book.dao;

public class DeleteBookDao {
	public void DeleteBook(int id){
		String sql = "delete from book where id=?";
		MyDbUtil.UpDate(sql,id);
		MyDbUtil.closeConnection();
	}
}
