package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.book.common.Page;
import com.book.entity.Reader;

public class ReaderDao {
	public Page<Reader> getAllReader(int pageNo, int pageSize) {
		Page<Reader> pagereader = null;
		try {
			String sql1 = " select count(*) from reader";
			ResultSet rs1 = MyDbUtil.Query(sql1);
			rs1.next();
			int count = rs1.getInt(1);

			String sql = " select * from reader limit ? ,?";
			ResultSet rs = MyDbUtil.Query(sql, (pageNo - 1) * pageSize, pageSize);

			List<Reader> reader = new ArrayList<Reader>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String readerName = rs.getString("readerName");
				String readerPwd = rs.getString("readerPwd");
				int borrowNum = Integer.parseInt(rs.getString("borrowNum"));
				String readerContact = rs.getString("readerContact");

				Reader reader1 = new Reader(id, readerName, readerPwd, borrowNum, readerContact);
				reader.add(reader1);
			}
			pagereader = new Page<>(reader, pageNo, pageSize, count);
			rs.close();
			MyDbUtil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pagereader;
	}
}
