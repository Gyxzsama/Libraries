package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.common.Page;
import com.book.entity.Book;

public class BookDao {
	public Page<Book> getAllBook(int pageNo, int pageSize) {
		Page<Book> pagebook = null;

		try {
			String sql1 = " select count(*) from book";
			ResultSet rs1 = MyDbUtil.Query(sql1);
			rs1.next();
			int count = rs1.getInt(1);
			String sql = " select * from book limit ? ,?";
			ResultSet rs = MyDbUtil.Query(sql, (pageNo - 1) * pageSize, pageSize);
			List<Book> books = new ArrayList<Book>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String bookname = rs.getString("bookName");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				double price = rs.getInt("price");
				int stock = rs.getInt("stock");
				int current = rs.getInt("current");
				Book books1 = new Book(id, bookname, author, publisher, price, stock, current);
				books.add(books1);
			}
			pagebook = new Page<>(books, pageNo, pageSize, count);
			rs.close();
			MyDbUtil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pagebook;
	}

	public List<Book> getBackBook(int id) {
		List<Book> books = new ArrayList<Book>();
		try {
			String sql1 = " select count(*) from book";
			ResultSet rs1 = MyDbUtil.Query(sql1);
			rs1.next();
			String sql = " select * FROM book b1 join borrow b2 on b1.id=b2.bookId and readerId="+id;
			ResultSet rs = MyDbUtil.Query(sql);
			while (rs.next()) {
				int bid = rs.getInt("id");
				String bookname = rs.getString("bookName");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				double price = rs.getInt("price");
				Book books1 = new Book(bid, bookname, author, publisher, price, 0, 0);
				books.add(books1);
			}
			rs.close();
			MyDbUtil.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}
}
