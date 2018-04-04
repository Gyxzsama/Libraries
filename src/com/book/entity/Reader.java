package com.book.entity;

public class Reader {
	private int id;
	private String readerName;
	private String readerPwd;
	private int borrowNum;
	private String readerContact;
	
	public Reader(int id ,String readerName, String readerPwd, int borrowNum, String readerContact) {
		this.id = id;
		this.readerName = readerName;
		this.readerPwd=readerPwd;
		this.borrowNum = borrowNum;
		this.readerContact = readerContact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderPwd() {
		return readerPwd;
	}

	public void setReaderPwd(String readerPwd) {
		this.readerPwd = readerPwd;
	}

	public int getBorrowNum() {
		return borrowNum;
	}

	public void setBorrowNum(int borrowNum) {
		this.borrowNum = borrowNum;
	}

	public String getReaderContact() {
		return readerContact;
	}

	public void setReaderContact(String readerContact) {
		this.readerContact = readerContact;
	}
	
	
	
	
}
