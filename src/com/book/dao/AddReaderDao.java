package com.book.dao;

public class AddReaderDao {
	public void AddReader(String readerName,String readerPwd,int borrowNum,String readerContact) {
		String sql = "insert into reader (readerName,readerPwd,borrowNum,readerContact)values(?,?,0,?);";
		MyDbUtil.UpDate(sql,readerName,readerPwd,readerContact);
		MyDbUtil.closeConnection();
	}
}
