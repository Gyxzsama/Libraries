package com.book.service;


import com.book.dao.ListInfoDao;

public class ListInfoService {
	private ListInfoDao listInfoDao = new ListInfoDao();
	public int getAllBookType(){
		return listInfoDao.getAllBookType();
	}
	public int getAllBookNum() {
		return listInfoDao.getAllBookNum();
	}
	public int getAllReaderNum() {
		return listInfoDao.getAllReaderNum();
	}
	public int getAllReaderBorrow() {
		return listInfoDao.getAllReaderBorrow();
	}
	
}
