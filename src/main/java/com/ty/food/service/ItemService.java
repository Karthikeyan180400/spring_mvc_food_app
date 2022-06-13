package com.ty.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.ItemDao;
import com.ty.food.dto.Item;
import com.ty.food.dto.Menu;

@Component
public class ItemService {
	@Autowired
	ItemDao itemDao;

	public List<Item> saveItem(List<Item> items) {
		List<Item> items2 = new ArrayList<Item>();
		for (Item item : items) {
			item.setCost(item.getQuantity() * item.getMenu().getCost());
			items2.add(item);
		}
		return itemDao.saveItem(items2);

	}

}
