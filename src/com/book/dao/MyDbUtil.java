package com.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDbUtil {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/library?useUnicode=true&characterEncoding=utf8";
	private static String userName = "root";
	private static String passWord = "root";
	private static ThreadLocal<Connection> temp = new ThreadLocal<Connection>();
	private static PreparedStatement psta = null; 	// 操作
	private static ResultSet rs = null; 			// 读取
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 获取数据链接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = temp.get();// 从其中获取一个数据库链接
			if (conn == null) {
				conn = DriverManager.getConnection(url, userName, passWord);
				temp.set(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return conn;
	}

	// 关闭数据库连接
	public static void closeConnection() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psta != null) {
			try {
				psta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		Connection conn = temp.get();
		if (conn != null) {
			try {
				conn.close(); // 此方法有bug
				temp.set(null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 执行查询，返回结果集
	public static ResultSet Query(String sql, Object... objs) {
		rs = null;
		psta = null;
		try {
			Connection conn = MyDbUtil.getConnection();
			psta = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				psta.setObject(i + 1, objs[i]);
			}
			rs = psta.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 更新
	public static int UpDate(String sql, Object... objs) {
		int count = 0;// 返回影响的行数
		psta = null;
		try {
			Connection conn = MyDbUtil.getConnection();
			psta = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				psta.setObject(i + 1, objs[i]);
			}
			count = psta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
