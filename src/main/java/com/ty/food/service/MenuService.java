package com.ty.food.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.MenuDao;
import com.ty.food.dto.Menu;

@Component
public class MenuService {
	
	@Autowired
	MenuDao menuDao;
	public Menu saveMenu(Menu menu) {
		return menuDao.saveMenu(menu);
	}

	public Menu getMenuById(int id) {
		return menuDao.getMenuById(id);

	}

	public List<Menu> getAllMenu() {
		return menuDao.getAllMenu();

	}

	public Menu updateMenu(Menu menu, int id) {
		return menuDao.updateMenu(menu, id);

	}

	public boolean deleteMenu(int id) {
		MenuDao menuDao = new MenuDao();
		return menuDao.deleteMenu(id);

	}

	public double offer(int itemId) {
		String offer = menuDao.getItemOffer(itemId);
		if (offer == null) {
			offer = "0%";
		}
		String offer1 = offer.replace("%", "");
		double offerValue = (int) (Integer.parseInt(offer1));
		return offerValue;

	}

	public double itemCost(int itemId) {
		return menuDao.getItemCost(itemId);

	}

}
