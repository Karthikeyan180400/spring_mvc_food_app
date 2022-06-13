package com.ty.food.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.Foodorder;
import com.ty.food.dto.Item;

@Component
public class FoodorderDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Foodorder saveOrder(Foodorder foodorder) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		/*
		 * List<Item> items2 = new ArrayList<Item>(); for (Item item : items) {
		 * item.setFoodorder(foodorder); items2.add(item); } foodorder.setItem(items2);
		 */
		entityTransaction.begin();
		entityManager.persist(foodorder);
		entityTransaction.commit();
		return foodorder;

	}

	/*
	 * public Item getItemOrder(int id) { EntityManagerFactory entityManagerFactory
	 * = Persistence.createEntityManagerFactory("vikas"); EntityManager
	 * entityManager = entityManagerFactory.createEntityManager(); return
	 * entityManager.find(Item.class, id);
	 * 
	 * }
	 * 
	 * 
	 * public Foodorder getOrderItem(int id) { EntityManagerFactory
	 * entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	 * EntityManager entityManager = entityManagerFactory.createEntityManager();
	 * return entityManager.find(Foodorder.class, id);
	 * 
	 * }
	 */

	public Foodorder insertOrderCost(Foodorder foodorder) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		/*
		 * List<Item> items2 = new ArrayList<Item>(); for (Item item : items) {
		 * item.setFoodorder(foodorder); items2.add(item); } foodorder.setItem(items2);
		 */
		entityTransaction.begin();
		entityManager.merge(foodorder);
		entityTransaction.commit();
		return foodorder;

	}

	public Foodorder getItem(String name, long phone) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Foodorder f where name=?1 and phone=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, name);
		query.setParameter(2, phone);
		List<Foodorder> foodorders = query.getResultList();
		if (foodorders.size() > 0) {
			for (Foodorder foodorder : foodorders) {
				return foodorder;
			}
		}
		return null;

	}

	public List<Foodorder> getAllFoodOrder() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "select f from Foodorder f";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public Foodorder getFoodorderById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Foodorder.class, id);

	}

	public List<Item> updateItem(List<Item> items, int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Foodorder foodorder1 = entityManager.find(Foodorder.class, id);
		List<Item> items2 = new ArrayList<Item>();
		for (Item item : items) {
			item.setFoodorder(foodorder1);
			items2.add(item);
		}

		foodorder1.setItems(items2);
		entityTransaction.begin();
		entityManager.merge(foodorder1);
		entityTransaction.commit();
		return items2;

	}

	public boolean deleteOrder(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Foodorder foodorder = entityManager.find(Foodorder.class, id);
		if (foodorder != null) {
			entityTransaction.begin();
			for (Item item : foodorder.getItems()) {
				entityManager.remove(item);
			}
			entityManager.remove(foodorder);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
