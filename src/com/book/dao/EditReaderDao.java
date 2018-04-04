package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.book.entity.Reader;

public class EditReaderDao {

	public Reader SelectReader(int id) {
		String sql = " select * from reader where id=?";
		ResultSet rs = MyDbUtil.Query(sql, id);
		Reader reader = null;
		try {
			if (rs.next()) {
				String readerName = rs.getString(2);
				String readerPwd = rs.getString(3);
				int borrowNum = rs.getInt(4);
				String readerContact = rs.getString(5);
				reader = new Reader(id, readerName, readerPwd, borrowNum, readerContact);
			}
			rs.close();
			MyDbUtil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reader;
	}
}
