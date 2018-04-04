package com.book.dao;

import java.sql.Timestamp;

public class BorrowBookDao {
	public void BorrowBook(int or_id ,int ob_id,Timestamp timestamp){
		String sql = "insert into borrow (bookId,readerId,borrowDate)values(?,?,?);";
		String sql1 = "update reader set borrowNum=borrowNum+1 where id=?";
		String sql2 = "update book set current=current-1 where id=?";
		MyDbUtil.UpDate(sql,ob_id,or_id,timestamp);
		MyDbUtil.UpDate(sql1,or_id);
		MyDbUtil.UpDate(sql2,ob_id);
		MyDbUtil.closeConnection();
	}
}
