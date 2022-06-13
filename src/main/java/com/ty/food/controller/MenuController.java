package com.ty.food.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.Menu;
import com.ty.food.service.FoodorderServices;
import com.ty.food.service.MenuService;

@Controller
public class MenuController {
	@Autowired
	MenuService menuService;
	@Autowired
	FoodorderServices foodorderServices;

	@GetMapping("/createmenu")
	public ModelAndView createMenu(ModelAndView modelAndView) {
		modelAndView.setViewName("createMenu.jsp");
		modelAndView.addObject("menu", new Menu());
		return modelAndView;
	}

	@PostMapping("/savemenu")
	public ModelAndView saveMenu(@ModelAttribute Menu menu, ModelAndView modelAndView) {
		Menu menu2 = menuService.saveMenu(menu);
		modelAndView.setViewName("getllmenu");
		return modelAndView;

	}

	@RequestMapping("/editmenu")
	public ModelAndView getMenu(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		modelAndView.setViewName("updateMenu.jsp");
		return modelAndView.addObject("menu", menuService.getMenuById(id));

	}

	@RequestMapping("/getallmenu")
	public ModelAndView getAllMenu(ModelAndView modelAndView) {
		modelAndView.setViewName("showMenu.jsp");
		return modelAndView.addObject("menus", menuService.getAllMenu());

	}

	@RequestMapping("/getallmenufororder")
	public ModelAndView getAllMenuForOrder(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		modelAndView.setViewName("menuOrder.jsp");
		modelAndView.addObject("menus", menuService.getAllMenu());
		/*
		 * List<Item> items = new ArrayList<Item>(); modelAndView.addObject("items",
		 * items);
		 */
		return modelAndView;

	}

	@PostMapping("/updatemenu")
	public ModelAndView updateMenu(@ModelAttribute Menu menu, @RequestParam(name = "itemMenuId") int id,
			ModelAndView modelAndView) {
		modelAndView.setViewName("getallmenu");
		return modelAndView.addObject("menu", menuService.updateMenu(menu, id));

	}

	@RequestMapping("/deletemenu")
	public ModelAndView deleteMenu(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		menuService.deleteMenu(id);
		modelAndView.setViewName("getallmenu");

		return modelAndView;

	}

}
