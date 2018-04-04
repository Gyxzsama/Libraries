package com.book.entity;

public class Manager {
	private int id;
	private String mgrName;
	private String mgrPwd;
	private String mgrContact;
	
	public Manager(int id, String mgrName, String mgrPwd, String mgrContact) {
		super();
		this.id = id;
		this.mgrName = mgrName;
		this.mgrPwd = mgrPwd;
		this.mgrContact = mgrContact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMgrName() {
		return mgrName;
	}
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}
	public String getMgrPwd() {
		return mgrPwd;
	}
	public void setMgrPwd(String mgrPwd) {
		this.mgrPwd = mgrPwd;
	}
	public String getMgrContact() {
		return mgrContact;
	}
	public void setMgrContact(String mgrContact) {
		this.mgrContact = mgrContact;
	}
	
}



