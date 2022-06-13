package com.ty.food.service;

import static com.ty.food.util.Tax.CGST;
import static com.ty.food.util.Tax.SGST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.FoodorderDao;
import com.ty.food.dto.Foodorder;
import com.ty.food.dto.Item;
import com.ty.food.dto.Menu;

@Component
public class FoodorderServices {
	@Autowired
	FoodorderDao foodorderDao;
	@Autowired
	ItemService itemService;

	public Foodorder saveOrder(Foodorder foodorder) {
		return foodorderDao.saveOrder(foodorder);

	}

	/*
	 * public Item getItemOrder(int id) { FoodorderDao foodorderDao = new
	 * FoodorderDao(); return foodorderDao.getItemOrder(id);
	 * 
	 * }
	 */

	public Foodorder insertOrderCost(Foodorder foodorder) {
		double cost_sum = 0;
		List<Item> items = foodorder.getItems();
		for (Item item : items) {
			Menu menu = item.getMenu();
			String offer = menu.getOffer();
			double offer_cost = 0;
			if (offer == null) {
				offer_cost = 0;
			} else {
				offer_cost = Double.parseDouble(offer.replace("%", ""));
			}
			cost_sum = cost_sum + (item.getCost() - (item.getCost() * (offer_cost / 100)));
		}
		double total_cost = cost_sum + (cost_sum * (CGST + SGST) / 100);
		foodorder.setTotal(total_cost);
		return foodorderDao.insertOrderCost(foodorder);

	}

	public Foodorder getItem(String name, long phone) {
		FoodorderDao foodorderDao = new FoodorderDao();
		return foodorderDao.getItem(name, phone);

	}

	public List<Foodorder> getAllFoodOrder() {
		FoodorderDao foodorderDao = new FoodorderDao();
		return foodorderDao.getAllFoodOrder();

	}

	public Foodorder getFoodorderById(int id) {
		return foodorderDao.getFoodorderById(id);

	}

	public List<Item> updateItem(List<Item> items, int id) {
		FoodorderDao foodorderDao = new FoodorderDao();
		return foodorderDao.updateItem(items, id);

	}

	public boolean deleteOrder(int id) {
		FoodorderDao foodorderDao = new FoodorderDao();
		return foodorderDao.deleteOrder(id);
	}

}
