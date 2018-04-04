package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.entity.Book;

public class EditBookDao {
	
	public Book SelectBook(int id){
		String sql = " select * from book where id=?";
		ResultSet rs =MyDbUtil.Query(sql, id);
		Book book=null;
		try {
			if(rs.next()){
				String  bookname  = rs.getString(2);
				String  author  = rs.getString(3);
				String  publisher  = rs.getString(4);
				double price = rs.getDouble(5);
				int stock =rs.getInt(6);
				int current = rs.getInt(7);
				book=new Book(id, bookname, author, publisher, price, stock, current);
			}
			rs.close();
			MyDbUtil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
}
