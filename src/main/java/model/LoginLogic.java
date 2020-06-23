package model;

import dao.UserDao;
import entity.User;

public class LoginLogic {
	
	public User getUser(User user) {
		
		UserDao userDao = new UserDao();
		return userDao.findUser(user);
	}
	
}
