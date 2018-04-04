package com.book.service;

import com.book.dao.DeleteReaderDao;

public class DeleteReaderService {
		DeleteReaderDao deletereaderdao = new DeleteReaderDao();
		public void deletereader(int id){
			deletereaderdao.DeleteReader(id);
		}
}
