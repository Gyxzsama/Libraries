package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListInfoDao {

	public int getAllBookType(){
		int count=0;
		String sql1 = " select count(*) from book";
		ResultSet rs1 = MyDbUtil.Query(sql1);
		try {
			rs1.next();
			count = rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getAllReaderNum() {
		int count=0;
		String sql1 = " select count(*) from reader";
		ResultSet rs1 = MyDbUtil.Query(sql1);
		try {
			rs1.next();
			count = rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getAllBookNum() {
		int count=0;
		String sql = " select * from book";
		ResultSet rs = MyDbUtil.Query(sql);
		try {
			while (rs.next()) {
				int stock = rs.getInt("stock");
				count=count+stock;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getAllReaderBorrow() {
		int count=0;
		String sql1 = " select count(*) from borrow";
		ResultSet rs1 = MyDbUtil.Query(sql1);
		try {
			rs1.next();
			count = rs1.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
