package com.book.common;

import java.util.List;

//分页器
public class Page<T> {
	private List<T> objects;
	private int pageNo;
	private int pageSize;
	private int count;
	// -------
	private int pageCount;
	private int prePage;
	private int nextPage;
	private int lastPage;


	public Page(List<T> objects, int pageNo, int pageSize, int count) {
		this.objects = objects;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.count = count;
		this.pageCount = (int) (count / pageSize) + (count % pageSize == 0 ? 0 : 1);

	}

	public List<T> getObjects() {
		return objects;
	}

	public void setObjects(List<T> objects) {
		this.objects = objects;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	// 获取上一页
	public int getPrePage() {
		if (this.pageNo == 1) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}

	public void setPrePage(int prePage) {
		if (this.pageNo == 1) {
			this.prePage = 1;
		} else {
			this.prePage = this.pageNo - 1;
		}
	}

	public int getNextPage() {
		if (this.pageNo == pageCount) {
			return pageCount;
		} else {
			return this.pageNo + 1;
		}
	}

	public void setNextPage(int nextPage) {
		if (this.pageNo == pageCount) {
			this.nextPage = pageCount;
		} else {
			 this.nextPage = this.nextPage + 1;
		}
	}

	public int getLastPage() {
		return this.lastPage = pageCount;
	}



}
