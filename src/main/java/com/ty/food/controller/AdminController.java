package com.ty.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.Admin;
import com.ty.food.dto.User;
import com.ty.food.service.AdminServices;
import com.ty.food.service.UserServices;

@Controller
public class AdminController {
	@Autowired
	AdminServices adminServices;

	@GetMapping("/createadmin")
	public ModelAndView createAdmin(ModelAndView modelAndView) {
		modelAndView.setViewName("adminSignUp.jsp");
		modelAndView.addObject("admin", new Admin());
		return modelAndView;

	}

	@PostMapping("/saveadmin")
	public ModelAndView saveAdmin(@ModelAttribute Admin admin, ModelAndView modelAndView) {
		modelAndView.setViewName("adminLogin.jsp");
		modelAndView.addObject("admin", adminServices.saveAdmin(admin));
		return modelAndView;

	}

	@GetMapping("/loginadmin")
	public ModelAndView loginAdmin(ModelAndView modelAndView) {
		modelAndView.setViewName("adminLogin.jsp");
		modelAndView.addObject("admin", new Admin());
		return modelAndView;

	}

	@RequestMapping("/validateadmin")
	public ModelAndView validateAdmin(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		String email = httpServletRequest.getParameter("email");
		String password = httpServletRequest.getParameter("password");

		Admin admin = adminServices.validateAdmin(email, password);
		if (admin != null) {

			HttpSession httpSession = httpServletRequest.getSession();
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("password", password);
			modelAndView.setViewName("adminProfile.jsp");
			modelAndView.addObject("admin", admin);

		} else {
			modelAndView.setViewName("signupAdminLogin.jsp");
		}
		return modelAndView;

	}

	@RequestMapping("/getadmin")
	public ModelAndView getAdmin(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		HttpSession httpSession = httpServletRequest.getSession();
		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");
		Admin admin = adminServices.getAdmin(email, password);
		if (admin != null) {

			modelAndView.setViewName("adminProfile.jsp");
			return modelAndView.addObject("admin", admin);

		}
		return modelAndView;

	}

	@RequestMapping("/editadmin")
	public ModelAndView editAdmin(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		modelAndView.setViewName("updateAdmin.jsp");
		return modelAndView.addObject("admin", adminServices.getAdminById(id));

	}

	@PostMapping("/updateadmin")
	public ModelAndView updateAdmin(@ModelAttribute Admin admin, @RequestParam(name = "id") int id,
			ModelAndView modelAndView) {
		modelAndView.setViewName("adminLogin.jsp");
		adminServices.updateAdmin(admin, id);
		return modelAndView;

	}

	@RequestMapping("/deleteadmin")
	public ModelAndView deleteAdmin(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		boolean res = adminServices.deleteAdmin(id);
		if (res) {
			modelAndView.setViewName("createadmin");

		} else {
			modelAndView.setViewName("getadmin");
		}
		return modelAndView;

	}

}
