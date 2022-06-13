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

import com.ty.food.dto.User;
import com.ty.food.service.UserServices;

@Controller
public class UserController {
	@Autowired
	UserServices userServices;

	@GetMapping("/createuser")
	public ModelAndView createUser(ModelAndView modelAndView) {
		modelAndView.setViewName("userSignUp.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;

	}

	@PostMapping("/saveuser")
	public ModelAndView saveUSer(@ModelAttribute User user, ModelAndView modelAndView) {
		modelAndView.setViewName("userLogin.jsp");
		modelAndView.addObject("user", userServices.saveUser(user));
		return modelAndView;

	}

	@GetMapping("/loginuser")
	public ModelAndView loginUser(ModelAndView modelAndView) {
		modelAndView.setViewName("userLogin.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;

	}

	@RequestMapping("/validateuser")
	public ModelAndView validateUser(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		String email = httpServletRequest.getParameter("email");
		String password = httpServletRequest.getParameter("password");

		User user = userServices.validateUser(email, password);
		if (user != null) {

			HttpSession httpSession = httpServletRequest.getSession();
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("password", password);
			modelAndView.setViewName("userProfile.jsp");
			modelAndView.addObject("user", user);

		} else {
			modelAndView.setViewName("signupUserLogin.jsp");
		}
		return modelAndView;

	}

	@RequestMapping("/getuser")
	public ModelAndView getUser(HttpServletRequest httpServletRequest, ModelAndView modelAndView) {
		HttpSession httpSession = httpServletRequest.getSession();
		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");
		User user = userServices.getUser(email, password);
		if (user != null) {

			modelAndView.setViewName("userProfile.jsp");
			return modelAndView.addObject("user", user);

		}
		return modelAndView;

	}

	@RequestMapping("/edituser")
	public ModelAndView editUser(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		modelAndView.setViewName("updateUser.jsp");
		return modelAndView.addObject("user", userServices.getUserById(id));

	}

	@PostMapping("/updateuser")
	public ModelAndView updateUser(@ModelAttribute User user, @RequestParam(name = "id") int id,
			ModelAndView modelAndView) {
		modelAndView.setViewName("userLogin.jsp");
		userServices.updateUser(user, id);
		return modelAndView;

	}

	@RequestMapping("/deleteuser")
	public ModelAndView deleteUser(@RequestParam(name = "id") int id, ModelAndView modelAndView) {
		boolean res = userServices.deleteUser(id);
		if (res) {
			modelAndView.setViewName("createuser");

		} else {
			modelAndView.setViewName("getuser");
		}
		return modelAndView;

	}

}
