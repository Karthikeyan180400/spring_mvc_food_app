package com.ty.food.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.UserDao;
import com.ty.food.dto.User;

@Component
public class UserServices {

	@Autowired
	UserDao userDao;

	public User saveUser(User user) {
		return userDao.saveUser(user);

	}

	public User getUserById(int id) {
		return userDao.getUserById(id);

	}

	public List<User> getAllUser() {
		return userDao.getAllUser();

	}

	public User updateUser(User user, int id) {
		return userDao.updateUser(user, id);

	}

	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);

	}

	public User getUser(String email, String password) {
		return userDao.getUser(email, password);

	}

	public User validateUser(String email, String password) {
		return userDao.validateUser(email, password);

	}

}
