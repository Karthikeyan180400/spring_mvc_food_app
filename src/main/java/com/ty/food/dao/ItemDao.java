package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.Item;

@Component
public class ItemDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public List<Item> saveItem(List<Item> items) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		for (Item item : items) {
			entityManager.persist(item);
		}
		entityTransaction.commit();
		return items;

	}

}
