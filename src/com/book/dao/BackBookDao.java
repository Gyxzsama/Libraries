package com.book.dao;

public class BackBookDao {

	public void backBook(int or_id, int ob_id) {
		// TODO Auto-generated method stub
		String sql = "delete from borrow where bookId=? and readerId=?";
		String sql1 = "update reader set borrowNum=borrowNum-1 where id=?";
		String sql2 = "update book set current=current+1 where id=?";
		MyDbUtil.UpDate(sql,ob_id,or_id);
		MyDbUtil.UpDate(sql1,or_id);
		MyDbUtil.UpDate(sql2,ob_id);
	}

}
