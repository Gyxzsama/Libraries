package com.book.entity;

public class Book {
	private int id;
	private String bookname;
	private String author;
	private String publisher;
	private double price;
	private int stock;
	private int current;
	
	public Book(int id, String bookname, String author, String publisher, double price, int stock, int current) {
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.stock = stock;
		this.current = current;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}

	
}
