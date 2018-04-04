package com.book.service;

import com.book.common.Page;
import com.book.dao.ReaderDao;
import com.book.entity.Reader;

public class ListReaderService {
	private ReaderDao readerDao = new ReaderDao();

	public Page<Reader> getAllReader(int pageNo, int pageSize) {
		Page<Reader> readers = null;
		readers = readerDao.getAllReader(pageNo, pageSize);
		return readers;
	}
}
