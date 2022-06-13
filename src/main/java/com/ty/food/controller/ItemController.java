package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.Item;
import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

@Controller
public class ItemController {
	@Autowired
	MenuService menuService;

	@GetMapping("/setitem")
	public ModelAndView setItemSession(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		List<Item> items = new ArrayList<Item>();
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute("items", items);
		modelAndView.setViewName("getallmenufororder");
		return modelAndView;

	}

	@GetMapping("/additem")
	public ModelAndView addItem(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		String itemName = httpServletRequest.getParameter("name");
		String id = httpServletRequest.getParameter("id");
		modelAndView.addObject("itemName", itemName);
		modelAndView.addObject("id", id);
		modelAndView.setViewName("addOrder.jsp");
		Menu menu = menuService.getMenuById(Integer.parseInt(id));
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute("menu", menu);
		return modelAndView.addObject("item", new Item());

	}

	@RequestMapping("/createitem")
	public ModelAndView createItem(HttpServletRequest httpServletRequest, @ModelAttribute Item item,
			ModelAndView modelAndView) {
		HttpSession httpSession = httpServletRequest.getSession();
		List<Item> items = (List<Item>) httpSession.getAttribute("items");
		int quantity = Integer.parseInt(httpServletRequest.getParameter("quantity"));
		Menu menu = (Menu) httpSession.getAttribute("menu");
		item.setQuantity(quantity);
		item.setMenu(menu);
		items.add(item);
		modelAndView.addObject("items", items);
		modelAndView.setViewName("viewOrder.jsp");
		return modelAndView;

	}

	@RequestMapping("/saveitem")
	public ModelAndView saveItem(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		HttpSession httpSession = httpServletRequest.getSession();
		List<Item> items = (List<Item>) httpSession.getAttribute("items");
		modelAndView.addObject("item", items);
		modelAndView.setViewName("createorder");
		return modelAndView;

	}

}
