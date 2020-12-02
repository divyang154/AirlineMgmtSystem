package com.flyway.service;

import java.util.Date;

import com.flyway.controller.UserException;
import com.flyway.dao.UserDao;
import com.flyway.pojo.User;

public class UserService {

	UserDao userDao = new UserDao();

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public User userCreateService(String username,String password,String email,String role)throws UserException {
		User user=new User();
		user.setUsername(username);
		User newUser=null;
		try {
		newUser=userDao.getUser(username);
		}
		catch(Exception e) {			
		}
		if(newUser!=null) {
			throw new UserException("User already exists with entered username please enter new username");
		}
		user.setPassword(password);
		user.setUserEmail(email);
		user.setCreatedOn(new Date());
		user.setUpdatedOn(new Date());
		user.setUserRole(role);
		userDao.create(user);
		return user;
	}

	public User getUserService(String username) {
		User user = userDao.getUser(username);
		return user;
	}
	
	public void updateUser(Integer userId,String username,String password,String email,String role) {
		User user=userDao.getUser(username);
		user.setPassword(password);
		user.setUserEmail(email);
		user.setUserRole(role);
		user.setUpdatedOn(new Date());
		user.setUpdatedBy(userId);
		userDao.updateUser(user);
	}

}
