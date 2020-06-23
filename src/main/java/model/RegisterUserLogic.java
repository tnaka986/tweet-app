package model;

import dao.UserDao;
import entity.User;

public class RegisterUserLogic {

	public boolean execute(User user) {
		
		UserDao dao = new UserDao();
		return dao.registUser(user);
	}
	
	public boolean userExistCheck(User user) {
		
		UserDao dao = new UserDao();
		if(dao.findUser(user) == null) {
			return false;
		} else {
			return true;
		}
	}
	
}
