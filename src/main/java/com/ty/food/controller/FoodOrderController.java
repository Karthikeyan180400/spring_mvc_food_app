package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.Foodorder;
import com.ty.food.dto.Item;
import com.ty.food.dto.User;
import com.ty.food.service.FoodorderServices;
import com.ty.food.service.ItemService;
import com.ty.food.service.UserServices;

@Controller
public class FoodOrderController {
	@Autowired
	FoodorderServices foodorderServices;
	@Autowired
	ItemService itemService;
	@Autowired
	UserServices userServices;

	@RequestMapping("/createorder")
	public ModelAndView createOrder(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
		Foodorder foodorder = new Foodorder();
		HttpSession httpSession = httpServletRequest.getSession();
		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");
		User user = userServices.getUser(email, password);
		foodorder.setUser(user);
		Foodorder foodorder2 = foodorderServices.saveOrder(foodorder);
		List<Item> items = (List<Item>) httpSession.getAttribute("items");
		List<Item> items2 = new ArrayList<Item>();
		for (Item item : items) {
			item.setFoodorder(foodorder2);
			items2.add(item);
		}
		itemService.saveItem(items2);
		foodorder2.setItems(items2);
		foodorderServices.insertOrderCost(foodorder2);
		modelAndView.setViewName("bill.jsp");
		modelAndView.addObject("items", items2);
		return modelAndView.addObject("foodorder", foodorder2);

	}

	@RequestMapping("/getfoodorders")
	public ModelAndView getUserFoodOrders(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		HttpSession httpSession = httpServletRequest.getSession();
		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");

		User user = userServices.validateUser(email, password);
		if (user != null) {
			System.out.println("hi");
			List<Foodorder> foodorders = new ArrayList<Foodorder>();
			List<Foodorder> foodorders2 = foodorderServices.getAllFoodOrder();
			for (Foodorder foodorder : foodorders2) {
				User user2 = foodorder.getUser();
				if (user2 != null && (user2.getId() == user.getId())) {
					foodorders.add(foodorder);
				}
			}
			if (foodorders.size() > 0) {
				modelAndView.addObject("foodorders", foodorders);
				modelAndView.setViewName("viewBookedOrders.jsp");
			} else {
				modelAndView.addObject("myMsg", "Sorry :( No Orders you have done");
				modelAndView.setViewName("dispaly.jsp");
			}
		} else {
			modelAndView.setViewName("userLogin.jsp");
		}
		return modelAndView;

	}

	@RequestMapping("/viewitems")
	public ModelAndView viewItems(@RequestParam(name = "id") int id, ModelAndView modelAndView,
			HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();
		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");

		User user = userServices.validateUser(email, password);
		if (user != null) {
			Foodorder foodorder = foodorderServices.getFoodorderById(id);
			List<Item> items = foodorder.getItems();
			if (items.size() > 0) {
				modelAndView.addObject("items", items);
				modelAndView.setViewName("viewItems.jsp");
			} else {
				modelAndView.addObject("myMsg", "Sorry :( No Orders you have done");
				modelAndView.setViewName("dispaly.jsp");
			}

		}
		return modelAndView;
	}

	@RequestMapping("/cancelorder")
	public ModelAndView cancleOrder(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		HttpSession httpSession = httpServletRequest.getSession();
		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");
		int id = Integer.parseInt(httpServletRequest.getParameter("id"));

		User user = userServices.validateUser(email, password);
		System.out.println(user);
		if (user != null) {
			boolean res = foodorderServices.deleteOrder(id);
			modelAndView.setViewName("getfoodorders");

		} else {
			modelAndView.setViewName("userLogin.jsp");
		}

		return modelAndView;

	}

}
