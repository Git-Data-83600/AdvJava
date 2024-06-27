package com.sunbeam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;
import com.sunbeam.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}


	@GetMapping("/login")
	public String renderLoginForm() {
		System.out.println("in render login form");
		return "/user/login";// AVN - /WEB-INF/views/user/login.jsp
	}

	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String em, @RequestParam String pass, Model map, HttpSession session) {
	
		try {
		
			User user = userService.authenticateUser(em, pass);
			
			session.setAttribute("user_details", user);
			if (user.getRole() == Role.BLOGGER)
				return "redirect:/blogger/home";
			
			if (user.getRole() == Role.ADMIN)
				return "/admin/home";// AVN - /WEB-INF/views/blogger/home.jsp
			return "/commenter/home";
		} catch (RuntimeException e) {
			System.out.println(e);
		
			map.addAttribute("message", e.getMessage());
			return "/user/login";
		}
	}

	
	@GetMapping("/logout")
	public String logout(HttpSession session,Model map) {
		System.out.println("in logout");
	
		map.addAttribute("details", session.getAttribute("user_details"));
		
		session.invalidate();
	
		return "/user/logout";
	}

}
