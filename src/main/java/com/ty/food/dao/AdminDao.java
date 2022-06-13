package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.Admin;

@Component
public class AdminDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Admin saveAdmin(Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;

	}

	public Admin getAdminById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Admin admin = entityManager.find(Admin.class, id);
		return admin;

	}

	public List<Admin> getAllAdmin() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select a from Admin a";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public Admin updateAdmin(Admin admin, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Admin admin1 = entityManager.find(Admin.class, id);
		if (admin1 != null) {
			entityTransaction.begin();
			entityManager.merge(admin);
			entityTransaction.commit();
			return admin;
		}

		return null;

	}

	public Admin getAdmin(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select a from Admin a where email=?1 and password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Admin> admins = query.getResultList();
		for (Admin admin : admins) {
			return admin;
		}
		return null;

	}

	public Admin validateAdmin(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select a from Admin a where email=?1 and password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Admin> admins = query.getResultList();
		for (Admin admin : admins) {
			return admin;
		}
		return null;

	}

	public boolean deleteAdmin(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Admin admin = entityManager.find(Admin.class, id);
		if (admin != null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
			return true;
		}

		return false;

	}

}
