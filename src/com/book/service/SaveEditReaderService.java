package com.book.service;

import com.book.dao.SaveEditReaderDao;

public class SaveEditReaderService {
	SaveEditReaderDao saveeditreaderdao = new SaveEditReaderDao();
	public void saveeditbook(int id,String readerName,String readerPwd,int borrowNum,String ReaderContact) {
		saveeditreaderdao.SaveEditReader(id, readerName, readerPwd, borrowNum, ReaderContact);
	}
}
