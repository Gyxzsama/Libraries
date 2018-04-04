package com.book.service;

import com.book.dao.managerDao;
import com.book.entity.Manager;

public class ManagerService {
	managerDao managerdao = new managerDao();
	public Manager findUserByNameAndPassword(String name, String password) {
		Manager manager = null;
		manager = managerdao.selectUserByNameAndPassword(name, password);
		return manager;
	}
}
