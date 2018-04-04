package com.book.service;

import com.book.dao.EditReaderDao;
import com.book.entity.Reader;

public class EditReaderService {
	EditReaderDao editreaderdao = new EditReaderDao();

	public Reader editreader(int id) {
		return editreaderdao.SelectReader(id);
	}
}
