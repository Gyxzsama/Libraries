package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.book.entity.Manager;



public class managerDao {
	public Manager selectUserByNameAndPassword(String name, String password) {
		Manager user = null;
		try {
			String sql = "select id,mgrName,mgrPwd,mgrContact from manager where mgrName =? and mgrPwd = ?";
			ResultSet rs = MyDbUtil.Query(sql, name,password);
			if(rs.next()){
				int id  = rs.getInt(1);
				String  mgrName  = rs.getString(2);
				String  mgrPwd  = rs.getString(3);
				String  mgrContact  = rs.getString(4);
				user = new Manager(id,mgrName,mgrPwd,mgrContact);
			}
			rs.close();
			MyDbUtil.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
