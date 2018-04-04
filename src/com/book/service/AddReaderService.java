package com.book.service;

import com.book.dao.AddReaderDao;

public class AddReaderService {
	AddReaderDao addreaderdao = new AddReaderDao();
	public void addreader(String readerName,String readerPwd,int  borrowNum,String readerContact) {
		 addreaderdao.AddReader(readerName, readerPwd, borrowNum, readerContact);
		 
	}

}
