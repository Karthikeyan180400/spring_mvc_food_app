package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.User;

@Component
public class UserDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public User saveUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;

	}

	public User getUserById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		return user;

	}

	public List<User> getAllUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select u from User u";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public User updateUser(User user, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user1 = entityManager.find(User.class, id);
		if (user1 != null) {
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			return user;
		}

		return null;

	}

	public User getUser(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select u from User u where email=?1 and password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		for (User user : users) {
			return user;
		}
		return null;

	}

	public User validateUser(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select u from User u where email=?1 and password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		for (User user : users) {
			return user;
		}
		return null;

	}

	public boolean deleteUser(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}

		return false;

	}

}
