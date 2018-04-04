package com.book.dao;

public class DeleteReaderDao {
	public void DeleteReader(int id){
		String sql=" delete from reader where id=?";
		MyDbUtil.UpDate(sql,id);
		MyDbUtil.closeConnection();
	}
}
