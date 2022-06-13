package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.Menu;

@Component
public class MenuDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Menu saveMenu(Menu menu) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}

	public Menu getMenuById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager.find(Menu.class, id);

	}

	public String getItemOffer(int itemId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select m from Menu m where itemId=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, itemId);
		List<Menu> menu = query.getResultList();
		for (Menu menu2 : menu) {
			return menu2.getOffer();
		}
		return null;
	}

	public double getItemCost(int itemId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select m from Menu m where itemId=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, itemId);
		List<Menu> menu = query.getResultList();
		for (Menu menu2 : menu) {
			return menu2.getCost();
		}
		return 0;
	}

	public List<Menu> getAllMenu() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select m from Menu m";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public Menu updateMenu(Menu menu, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Menu menu2 = entityManager.find(Menu.class, id);
		if (menu2 != null) {
			entityTransaction.begin();
			entityManager.merge(menu);
			entityTransaction.commit();
			return menu2;
		}
		return null;

	}

	public boolean deleteMenu(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Menu menu = entityManager.find(Menu.class, id);
		if (menu != null) {
			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();
			return true;
		}
		return false;

	}

}
