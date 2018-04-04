package com.book.dao;

public class SaveEditReaderDao {
	public void SaveEditReader(int id,String readerName,String readerPwd,int borrowNum,String ReaderContact) {
		String sql = "update reader set readerName=?,readerPwd=?,borrowNum=?,ReaderContact=? where id=?";
		MyDbUtil.UpDate(sql,readerName,readerPwd,borrowNum,ReaderContact,id);
		MyDbUtil.closeConnection();
	}
}
